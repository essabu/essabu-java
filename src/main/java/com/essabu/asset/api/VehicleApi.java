package com.essabu.asset.api;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.asset.model.request.CreateVehicleRequest;
import com.essabu.asset.model.request.UpdateVehicleRequest;
import com.essabu.asset.model.response.VehicleResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * API client for managing vehicle resources in the Essabu Asset module.
 *
 * Provides typed methods to interact with the vehicle REST API endpoints
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
 * Base path: /api/asset/vehicles
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class VehicleApi extends BaseApi {

    private static final String BASE_PATH = "/api/asset/vehicles";

    public VehicleApi(HttpClientWrapper http) { super(http); }

    public PageResponse<VehicleResponse> list(PageRequest page) {
        return http.get(withPagination(BASE_PATH, page), new TypeReference<>() {});
    }
    public VehicleResponse getById(String id) { return http.get(BASE_PATH + "/" + id, VehicleResponse.class); }
    public VehicleResponse create(CreateVehicleRequest request) { return http.post(BASE_PATH, request, VehicleResponse.class); }
    public VehicleResponse update(String id, UpdateVehicleRequest request) { return http.patch(BASE_PATH + "/" + id, request, VehicleResponse.class); }
    public void delete(String id) { http.delete(BASE_PATH + "/" + id); }
}
