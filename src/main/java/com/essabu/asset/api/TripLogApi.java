package com.essabu.asset.api;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.asset.model.request.CreateTripLogRequest;
import com.essabu.asset.model.request.UpdateTripLogRequest;
import com.essabu.asset.model.response.TripLogResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * API client for managing trip log resources in the Essabu Asset module.
 *
 * Provides typed methods to interact with the trip log REST API endpoints
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
 * Base path: /api/asset/trip-logs
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class TripLogApi extends BaseApi {

    private static final String BASE_PATH = "/api/asset/trip-logs";

    public TripLogApi(HttpClientWrapper http) { super(http); }

    public PageResponse<TripLogResponse> list(PageRequest page) {
        return http.get(withPagination(BASE_PATH, page), new TypeReference<>() {});
    }
    public TripLogResponse getById(String id) { return http.get(BASE_PATH + "/" + id, TripLogResponse.class); }
    public TripLogResponse create(CreateTripLogRequest request) { return http.post(BASE_PATH, request, TripLogResponse.class); }
    public TripLogResponse update(String id, UpdateTripLogRequest request) { return http.patch(BASE_PATH + "/" + id, request, TripLogResponse.class); }
    public void delete(String id) { http.delete(BASE_PATH + "/" + id); }
}
