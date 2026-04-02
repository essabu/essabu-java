package com.essabu.asset.api;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.asset.model.request.CreateAssetRequest;
import com.essabu.asset.model.request.UpdateAssetRequest;
import com.essabu.asset.model.response.AssetResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * API client for managing asset resources in the Essabu Asset module.
 *
 * Provides typed methods to interact with the asset REST API endpoints
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
 * Base path: /api/asset/assets
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class AssetApi extends BaseApi {

    private static final String BASE_PATH = "/api/asset/assets";

    public AssetApi(HttpClientWrapper http) { super(http); }

    public PageResponse<AssetResponse> list(PageRequest page) {
        return http.get(withPagination(BASE_PATH, page), new TypeReference<>() {});
    }
    public AssetResponse getById(String id) { return http.get(BASE_PATH + "/" + id, AssetResponse.class); }
    public AssetResponse create(CreateAssetRequest request) { return http.post(BASE_PATH, request, AssetResponse.class); }
    public AssetResponse update(String id, UpdateAssetRequest request) { return http.patch(BASE_PATH + "/" + id, request, AssetResponse.class); }
    public void delete(String id) { http.delete(BASE_PATH + "/" + id); }
}
