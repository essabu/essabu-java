package com.essabu.accounting.webhook;

import com.essabu.common.internal.JsonMapper;
import com.essabu.accounting.model.common.AccountingEvent;
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

    private final WebhookListener listener;
    private final WebhookVerifier verifier;
    private final String webhookPath;

    public SpringWebhookController(WebhookListener listener, WebhookVerifier verifier, String webhookPath) {
        this.listener = listener;
        this.verifier = verifier;
        this.webhookPath = webhookPath;
    }

    @PostMapping("${essabu.accounting.webhook.path:/api/accounting-events}")
    public ResponseEntity<Void> handleWebhook(
            @RequestBody String body,
            @RequestHeader(value = "X-Webhook-Signature", required = false) String signature) {

        if (verifier != null && !verifier.verify(body, signature)) {
            return ResponseEntity.status(401).build();
        }

        AccountingEvent event = JsonMapper.fromJson(body, AccountingEvent.class);
        listener.onEvent(event);

        return ResponseEntity.ok().build();
    }
}
