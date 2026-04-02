package com.essabu.payment.api.payment;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.payment.model.webhook.request.CreateWebhookRequest;
import com.essabu.payment.model.webhook.response.PaymentWebhookResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing webhook resources in the Essabu Payment module.
 *
 * Provides typed methods to interact with the webhook REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - delete: delete operation
 *
 * Base path: /api/payment/webhooks
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class WebhookApi extends BaseApi {

    private static final String BASE_PATH = "/api/payment/webhooks";

    public WebhookApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Creates a new webhook.
     */
    public PaymentWebhookResponse create(CreateWebhookRequest request) {
        return http.post(BASE_PATH, request, PaymentWebhookResponse.class);
    }

    /**
     * Lists the webhooks of a company.
     */
    public List<PaymentWebhookResponse> getByCompany(UUID companyId) {
        String path = withParam(BASE_PATH, "companyId", companyId);
        return http.get(path, new TypeReference<>() {});
    }

    /**
     * Deletes a webhook.
     */
    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }
}
