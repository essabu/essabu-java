package com.essabu.accounting.api.transactions;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.accounting.model.transactions.request.RecordPaymentRequest;
import com.essabu.accounting.model.transactions.request.UpdatePaymentRequest;
import com.essabu.accounting.model.transactions.response.PaymentResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing payment resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the payment REST API endpoints
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
 * - confirm: confirm operation
 * - cancel: cancel operation
 *
 * Base path: /api/accounting/payments
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class PaymentApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/payments";

    public PaymentApi(HttpClientWrapper http) {
        super(http);
    }

    public PaymentResponse create(RecordPaymentRequest request) {
        return http.post(BASE_PATH, request, PaymentResponse.class);
    }

    public PaymentResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, PaymentResponse.class);
    }

    public PageResponse<PaymentResponse> list(UUID companyId, PageRequest page) {
        String path = withPagination(BASE_PATH + "?companyId=" + companyId, page);
        return http.get(path, new TypeReference<>() {});
    }

    public PaymentResponse update(UUID id, UpdatePaymentRequest request) {
        return http.put(BASE_PATH + "/" + id, request, PaymentResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }

    public PaymentResponse confirm(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/confirm", PaymentResponse.class);
    }

    public PaymentResponse cancel(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/cancel", PaymentResponse.class);
    }
}
