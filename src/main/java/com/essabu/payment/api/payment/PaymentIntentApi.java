package com.essabu.payment.api.payment;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.payment.model.payment.request.CreatePaymentIntentRequest;
import com.essabu.payment.model.payment.response.PaymentIntentResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing payment intent resources in the Essabu Payment module.
 *
 * Provides typed methods to interact with the payment intent REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - confirm: confirm operation
 * - cancel: cancel operation
 *
 * Base path: /api/payment/intents
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class PaymentIntentApi extends BaseApi {

    private static final String BASE_PATH = "/api/payment/intents";

    public PaymentIntentApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Creates a new payment intent.
     */
    public PaymentIntentResponse create(CreatePaymentIntentRequest request) {
        return http.post(BASE_PATH, request, PaymentIntentResponse.class);
    }

    /**
     * Confirms a payment intent.
     */
    public PaymentIntentResponse confirm(UUID id) {
        return http.post(BASE_PATH + "/" + id + "/confirm", null, PaymentIntentResponse.class);
    }

    /**
     * Cancels a payment intent.
     */
    public PaymentIntentResponse cancel(UUID id) {
        return http.post(BASE_PATH + "/" + id + "/cancel", null, PaymentIntentResponse.class);
    }

    /**
     * Retrieves a payment intent by its identifier.
     */
    public PaymentIntentResponse getById(UUID id) {
        return http.get(BASE_PATH + "/" + id, PaymentIntentResponse.class);
    }

    /**
     * Lists the payment intents of a company.
     */
    public PageResponse<PaymentIntentResponse> getByCompany(UUID companyId, PageRequest page) {
        String path = withParam(BASE_PATH, "companyId", companyId);
        path = withPagination(path, page);
        return http.get(path, new TypeReference<>() {});
    }
}
