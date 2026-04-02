package com.essabu.payment.api.subscription;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.payment.model.subscription.response.SaasInvoiceResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing saas invoice resources in the Essabu Payment module.
 *
 * Provides typed methods to interact with the saas invoice REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Base path: /api/payment/invoices
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class SaasInvoiceApi extends BaseApi {

    private static final String BASE_PATH = "/api/payment/invoices";

    public SaasInvoiceApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Lists the SaaS invoices of a subscription.
     */
    public PageResponse<SaasInvoiceResponse> getBySubscription(UUID subscriptionId, PageRequest page) {
        String path = withParam(BASE_PATH, "subscriptionId", subscriptionId);
        path = withPagination(path, page);
        return http.get(path, new TypeReference<>() {});
    }
}
