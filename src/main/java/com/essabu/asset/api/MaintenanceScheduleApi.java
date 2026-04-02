package com.essabu.asset.api;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.asset.model.request.CreateMaintenanceScheduleRequest;
import com.essabu.asset.model.request.UpdateMaintenanceScheduleRequest;
import com.essabu.asset.model.response.MaintenanceScheduleResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * API client for managing maintenance schedule resources in the Essabu Asset module.
 *
 * Provides typed methods to interact with the maintenance schedule REST API endpoints
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
 * Base path: /api/asset/maintenance-schedules
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class MaintenanceScheduleApi extends BaseApi {

    private static final String BASE_PATH = "/api/asset/maintenance-schedules";

    public MaintenanceScheduleApi(HttpClientWrapper http) { super(http); }

    public PageResponse<MaintenanceScheduleResponse> list(PageRequest page) {
        return http.get(withPagination(BASE_PATH, page), new TypeReference<>() {});
    }
    public MaintenanceScheduleResponse getById(String id) { return http.get(BASE_PATH + "/" + id, MaintenanceScheduleResponse.class); }
    public MaintenanceScheduleResponse create(CreateMaintenanceScheduleRequest request) { return http.post(BASE_PATH, request, MaintenanceScheduleResponse.class); }
    public MaintenanceScheduleResponse update(String id, UpdateMaintenanceScheduleRequest request) { return http.patch(BASE_PATH + "/" + id, request, MaintenanceScheduleResponse.class); }
    public void delete(String id) { http.delete(BASE_PATH + "/" + id); }
}
