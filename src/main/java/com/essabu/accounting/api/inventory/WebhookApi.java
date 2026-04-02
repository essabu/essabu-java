package com.essabu.accounting.api.inventory;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.accounting.model.inventory.request.CreateWebhookRequest;
import com.essabu.accounting.model.inventory.request.UpdateWebhookRequest;
import com.essabu.accounting.model.inventory.response.WebhookDeliveryResponse;
import com.essabu.accounting.model.inventory.response.WebhookSubscriptionResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing webhook resources in the Essabu Accounting module.
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
 * - list: list operation
 * - update: update operation
 * - delete: delete operation
 * - test: test operation
 *
 * Base path: /api/accounting/webhooks
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class WebhookApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/webhooks";

    public WebhookApi(HttpClientWrapper http) {
        super(http);
    }

    public WebhookSubscriptionResponse create(CreateWebhookRequest request) {
        return http.post(BASE_PATH, request, WebhookSubscriptionResponse.class);
    }

    public WebhookSubscriptionResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, WebhookSubscriptionResponse.class);
    }

    public List<WebhookSubscriptionResponse> list() {
        return http.get(BASE_PATH, new TypeReference<>() {});
    }

    public WebhookSubscriptionResponse update(UUID id, UpdateWebhookRequest request) {
        return http.put(BASE_PATH + "/" + id, request, WebhookSubscriptionResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }

    public List<WebhookDeliveryResponse> getDeliveries(UUID id) {
        return http.get(BASE_PATH + "/" + id + "/deliveries", new TypeReference<>() {});
    }

    public void test(UUID id) {
        http.postEmptyVoid(BASE_PATH + "/" + id + "/test");
    }
}
