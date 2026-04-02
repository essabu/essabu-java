package com.essabu.accounting.api.transactions;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.accounting.model.transactions.request.CreatePaymentTermRequest;
import com.essabu.accounting.model.transactions.request.UpdatePaymentTermRequest;
import com.essabu.accounting.model.transactions.response.PaymentTermResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing payment term resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the payment term REST API endpoints
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
 *
 * Base path: /api/accounting/payment-terms
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class PaymentTermApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/payment-terms";

    public PaymentTermApi(HttpClientWrapper http) {
        super(http);
    }

    public PaymentTermResponse create(CreatePaymentTermRequest request) {
        return http.post(BASE_PATH, request, PaymentTermResponse.class);
    }

    public List<PaymentTermResponse> list(UUID companyId) {
        return http.get(BASE_PATH + "?companyId=" + companyId, new TypeReference<>() {});
    }

    public PaymentTermResponse update(UUID id, UpdatePaymentTermRequest request) {
        return http.put(BASE_PATH + "/" + id, request, PaymentTermResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }
}
