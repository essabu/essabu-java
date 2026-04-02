package com.essabu.payment.api.payment;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.payment.model.payment.response.SettlementResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing settlement resources in the Essabu Payment module.
 *
 * Provides typed methods to interact with the settlement REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Base path: /api/payment/settlements
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class SettlementApi extends BaseApi {

    private static final String BASE_PATH = "/api/payment/settlements";

    public SettlementApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Lists the settlements of a company.
     */
    public PageResponse<SettlementResponse> getByCompany(UUID companyId, PageRequest page) {
        String path = withParam(BASE_PATH, "companyId", companyId);
        path = withPagination(path, page);
        return http.get(path, new TypeReference<>() {});
    }
}
