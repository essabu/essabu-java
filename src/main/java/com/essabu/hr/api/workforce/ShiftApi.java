package com.essabu.hr.api.workforce;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.BaseApi;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.hr.model.workforce.request.CreateShiftRequest;
import com.essabu.hr.model.workforce.request.UpdateShiftRequest;
import com.essabu.hr.model.workforce.response.ShiftResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing shift resources in the Essabu HR module.
 *
 * Provides typed methods to interact with the shift REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - list: list operation
 * - update: update operation
 * - delete: delete operation
 *
 * Base path: /api/hr/shifts
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class ShiftApi extends BaseApi {

    private static final String BASE_PATH = "/api/hr/shifts";

    public ShiftApi(HttpClientWrapper http) {
        super(http);
    }

    public ShiftResponse create(CreateShiftRequest request) {
        return http.post(BASE_PATH, request, ShiftResponse.class);
    }

    public ShiftResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, ShiftResponse.class);
    }

    public PageResponse<ShiftResponse> list(PageRequest page) {
        return http.get(withPagination(BASE_PATH, page),
                new TypeReference<PageResponse<ShiftResponse>>() {});
    }

    public ShiftResponse update(UUID id, UpdateShiftRequest request) {
        return http.put(BASE_PATH + "/" + id, request, ShiftResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }

    public List<ShiftResponse> getMyWeek(UUID employeeId, String week) {
        return http.get(BASE_PATH + "/my-week?employeeId=" + employeeId + "&week=" + week,
                new TypeReference<>() {});
    }
}
