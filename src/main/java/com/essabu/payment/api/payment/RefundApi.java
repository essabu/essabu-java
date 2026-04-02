package com.essabu.payment.api.payment;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.payment.model.payment.request.CreateRefundRequest;
import com.essabu.payment.model.payment.response.RefundResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing refund resources in the Essabu Payment module.
 *
 * Provides typed methods to interact with the refund REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 *
 * Base path: /api/payment/refunds
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class RefundApi extends BaseApi {

    private static final String BASE_PATH = "/api/payment/refunds";

    public RefundApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Creates a new refund.
     */
    public RefundResponse create(CreateRefundRequest request) {
        return http.post(BASE_PATH, request, RefundResponse.class);
    }

    /**
     * Lists the refunds of a company.
     */
    public PageResponse<RefundResponse> getByCompany(UUID companyId, PageRequest page) {
        String path = withParam(BASE_PATH, "companyId", companyId);
        path = withPagination(path, page);
        return http.get(path, new TypeReference<>() {});
    }
}
