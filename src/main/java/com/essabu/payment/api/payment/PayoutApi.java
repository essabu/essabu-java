package com.essabu.payment.api.payment;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.payment.model.payment.request.CreatePayoutRequest;
import com.essabu.payment.model.payment.response.PayoutResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing payout resources in the Essabu Payment module.
 *
 * Provides typed methods to interact with the payout REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 *
 * Base path: /api/payment/payouts
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class PayoutApi extends BaseApi {

    private static final String BASE_PATH = "/api/payment/payouts";

    public PayoutApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Creates a new payout.
     */
    public PayoutResponse create(CreatePayoutRequest request) {
        return http.post(BASE_PATH, request, PayoutResponse.class);
    }

    /**
     * Lists the payouts of a company.
     */
    public PageResponse<PayoutResponse> getByCompany(UUID companyId, PageRequest page) {
        String path = withParam(BASE_PATH, "companyId", companyId);
        path = withPagination(path, page);
        return http.get(path, new TypeReference<>() {});
    }
}
