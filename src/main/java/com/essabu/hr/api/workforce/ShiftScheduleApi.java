package com.essabu.hr.api.workforce;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.BaseApi;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.hr.model.workforce.request.CreateShiftScheduleRequest;
import com.essabu.hr.model.workforce.request.CreateShiftSwapRequest;
import com.essabu.hr.model.workforce.response.ShiftScheduleResponse;
import com.essabu.hr.model.workforce.response.ShiftSwapRequestResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Map;
import java.util.UUID;

/**
 * API client for managing shift schedule resources in the Essabu HR module.
 *
 * Provides typed methods to interact with the shift schedule REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - list: list operation
 * - approve: approve operation
 * - publish: publish operation
 * - requestSwap: request swap operation
 * - approveSwap: approve swap operation
 *
 * Base path: /api/hr/shift-schedules
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class ShiftScheduleApi extends BaseApi {

    private static final String BASE_PATH = "/api/hr/shift-schedules";

    public ShiftScheduleApi(HttpClientWrapper http) {
        super(http);
    }

    public ShiftScheduleResponse create(CreateShiftScheduleRequest request) {
        return http.post(BASE_PATH, request, ShiftScheduleResponse.class);
    }

    public ShiftScheduleResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, ShiftScheduleResponse.class);
    }

    public PageResponse<ShiftScheduleResponse> list(PageRequest page) {
        return http.get(withPagination(BASE_PATH, page),
                new TypeReference<PageResponse<ShiftScheduleResponse>>() {});
    }

    public ShiftScheduleResponse approve(UUID id, UUID approvedBy) {
        return http.put(BASE_PATH + "/" + id + "/approve",
                Map.of("approvedBy", approvedBy.toString()),
                ShiftScheduleResponse.class);
    }

    public ShiftScheduleResponse publish(UUID id) {
        return http.put(BASE_PATH + "/" + id + "/publish", null, ShiftScheduleResponse.class);
    }

    public ShiftSwapRequestResponse requestSwap(CreateShiftSwapRequest request) {
        return http.post("/api/hr/shift-swap-requests", request, ShiftSwapRequestResponse.class);
    }

    public ShiftSwapRequestResponse approveSwap(UUID swapId) {
        return http.put("/api/hr/shift-swap-requests/" + swapId + "/approve", null,
                ShiftSwapRequestResponse.class);
    }
}
