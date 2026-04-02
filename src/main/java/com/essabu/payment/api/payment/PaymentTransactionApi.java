package com.essabu.payment.api.payment;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.payment.model.payment.response.PaymentTransactionResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing payment transaction resources in the Essabu Payment module.
 *
 * Provides typed methods to interact with the payment transaction REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Base path: /api/payment/transactions
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class PaymentTransactionApi extends BaseApi {

    private static final String BASE_PATH = "/api/payment/transactions";

    public PaymentTransactionApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Retrieves a transaction by its identifier.
     */
    public PaymentTransactionResponse getById(UUID id) {
        return http.get(BASE_PATH + "/" + id, PaymentTransactionResponse.class);
    }

    /**
     * Lists the transactions of a company.
     */
    public PageResponse<PaymentTransactionResponse> getByCompany(UUID companyId, PageRequest page) {
        String path = withParam(BASE_PATH, "companyId", companyId);
        path = withPagination(path, page);
        return http.get(path, new TypeReference<>() {});
    }
}
