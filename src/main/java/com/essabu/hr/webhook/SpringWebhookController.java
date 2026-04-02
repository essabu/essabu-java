package com.essabu.hr.webhook;

import com.essabu.hr.model.common.HrEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring REST controller that receives and processes HR webhook events
 * from the Essabu HR API.
 *
 * Exposes a POST endpoint (configurable via essabu.hr.webhook.path property,
 * defaulting to /api/hr-events) that accepts JSON webhook payloads. Each
 * incoming request is first verified against the shared webhook secret using
 * HMAC-SHA256 signature validation to ensure authenticity. Once verified,
 * the payload is deserialized into an HrEvent object and dispatched to the
 * registered WebhookListener implementation for processing.
 *
 * Response codes:
 * - 200 OK: the event was successfully processed
 * - 401 Unauthorized: the signature header is missing or invalid
 * - 500 Internal Server Error: an unexpected error occurred during processing
 *
 * The controller is automatically registered by the Spring Boot
 * auto-configuration when the necessary properties and listener bean are present.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@RestController
public class SpringWebhookController {

    private static final Logger log = LoggerFactory.getLogger(SpringWebhookController.class);
    private static final String SIGNATURE_HEADER = "X-Essabu-Signature";

    private final WebhookListener listener;
    private final String webhookSecret;
    private final ObjectMapper objectMapper;

    /**
     * Creates a new webhook controller.
     *
     * @param listener      the listener that will process incoming events
     * @param webhookSecret the shared secret used to verify HMAC-SHA256 signatures
     */
    public SpringWebhookController(WebhookListener listener, String webhookSecret) {
        this.listener = listener;
        this.webhookSecret = webhookSecret;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    /**
     * Receives and processes a webhook event.
     *
     * The actual path mapping is configured dynamically via the
     * EssabuHrAutoConfiguration Spring Boot auto-configuration class.
     *
     * @param payload         the raw JSON request body
     * @param signatureHeader the HMAC-SHA256 signature from the X-Essabu-Signature header
     * @return 200 OK on success, 401 Unauthorized on bad signature, 500 Internal Server Error on failure
     */
    @PostMapping(value = "${essabu.hr.webhook.path:/api/hr-events}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> handleWebhook(
            @RequestBody String payload,
            @RequestHeader(value = SIGNATURE_HEADER, required = false) String signatureHeader) {

        // Verify signature
        if (webhookSecret != null && !webhookSecret.isBlank()) {
            if (signatureHeader == null || signatureHeader.isBlank()) {
                log.warn("Webhook received without signature header");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("{\"error\":\"Missing signature header\"}");
            }
            if (!WebhookVerifier.verify(webhookSecret, payload, signatureHeader)) {
                log.warn("Webhook received with invalid signature");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("{\"error\":\"Signature invalide\"}");
            }
        }

        // Deserialize and dispatch
        try {
            HrEvent event = objectMapper.readValue(payload, HrEvent.class);
            log.debug("HR event received: type={}, id={}", event.getType(), event.getId());
            listener.onEvent(event);
            return ResponseEntity.ok("{\"status\":\"ok\"}");
        } catch (Exception e) {
            log.error("Error while processing webhook event", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"Internal error while processing event\"}");
        }
    }
}
