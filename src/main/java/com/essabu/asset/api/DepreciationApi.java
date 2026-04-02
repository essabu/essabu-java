package com.essabu.asset.api;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.asset.model.request.CreateDepreciationRequest;
import com.essabu.asset.model.request.UpdateDepreciationRequest;
import com.essabu.asset.model.response.DepreciationResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * API client for managing depreciation resources in the Essabu Asset module.
 *
 * Provides typed methods to interact with the depreciation REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - list: list operation
 * - create: create operation
 * - update: update operation
 * - delete: delete operation
 *
 * Base path: /api/asset/depreciations
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class DepreciationApi extends BaseApi {

    private static final String BASE_PATH = "/api/asset/depreciations";

    public DepreciationApi(HttpClientWrapper http) { super(http); }

    public PageResponse<DepreciationResponse> list(PageRequest page) {
        return http.get(withPagination(BASE_PATH, page), new TypeReference<>() {});
    }
    public DepreciationResponse getById(String id) { return http.get(BASE_PATH + "/" + id, DepreciationResponse.class); }
    public DepreciationResponse create(CreateDepreciationRequest request) { return http.post(BASE_PATH, request, DepreciationResponse.class); }
    public DepreciationResponse update(String id, UpdateDepreciationRequest request) { return http.patch(BASE_PATH + "/" + id, request, DepreciationResponse.class); }
    public void delete(String id) { http.delete(BASE_PATH + "/" + id); }
}
