package com.essabu.payment.api.payment;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.payment.model.payment.request.CreatePaymentAccountRequest;
import com.essabu.payment.model.payment.response.PaymentAccountResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing payment account resources in the Essabu Payment module.
 *
 * Provides typed methods to interact with the payment account REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 *
 * Base path: /api/payment/accounts
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class PaymentAccountApi extends BaseApi {

    private static final String BASE_PATH = "/api/payment/accounts";

    public PaymentAccountApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Creates a new payment account.
     */
    public PaymentAccountResponse create(CreatePaymentAccountRequest request) {
        return http.post(BASE_PATH, request, PaymentAccountResponse.class);
    }

    /**
     * Lists the payment accounts of a company.
     */
    public PageResponse<PaymentAccountResponse> getByCompany(UUID companyId, PageRequest page) {
        String path = withParam(BASE_PATH, "companyId", companyId);
        path = withPagination(path, page);
        return http.get(path, new TypeReference<>() {});
    }
}
