package com.essabu.payment.api.lending;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.payment.model.lending.request.CreateCollateralRequest;
import com.essabu.payment.model.lending.request.UpdateCollateralRequest;
import com.essabu.payment.model.lending.response.CollateralResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing collateral resources in the Essabu Payment module.
 *
 * Provides typed methods to interact with the collateral REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - update: update operation
 *
 * Base path: /api/lending/collaterals
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class CollateralApi extends BaseApi {

    private static final String BASE_PATH = "/api/lending/collaterals";

    public CollateralApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Creates a new collateral.
     */
    public CollateralResponse create(CreateCollateralRequest request) {
        return http.post(BASE_PATH, request, CollateralResponse.class);
    }

    /**
     * Retrieves a collateral by its identifier.
     */
    public CollateralResponse getById(UUID id) {
        return http.get(BASE_PATH + "/" + id, CollateralResponse.class);
    }

    /**
     * Lists the collaterals of a company.
     */
    public PageResponse<CollateralResponse> getByCompany(UUID companyId, PageRequest page) {
        String path = withParam(BASE_PATH, "companyId", companyId);
        path = withPagination(path, page);
        return http.get(path, new TypeReference<>() {});
    }

    /**
     * Updates a collateral.
     */
    public CollateralResponse update(UUID id, UpdateCollateralRequest request) {
        return http.put(BASE_PATH + "/" + id, request, CollateralResponse.class);
    }
}
