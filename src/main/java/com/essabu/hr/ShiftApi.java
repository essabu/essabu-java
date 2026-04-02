package com.essabu.hr;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for HR shift, shift schedule, and shift swap operations.
 * Endpoint bases: /api/hr/shifts, /api/hr/shift-schedules, /api/hr/shift-swap-requests
 */
public final class ShiftApi extends BaseApi {

    private static final String SHIFTS = "/api/hr/shifts";
    private static final String SCHEDULES = "/api/hr/shift-schedules";
    private static final String SWAPS = "/api/hr/shift-swap-requests";

    public ShiftApi(HttpClientWrapper http) {
        super(http);
    }

    // -- Shifts --

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(SHIFTS, pageRequest), pageType(Map.class));
    }

    public Map getById(UUID id) {
        return http.get(SHIFTS + "/" + id, Map.class);
    }

    public Map create(Map<String, Object> request) {
        return http.post(SHIFTS, request, Map.class);
    }

    public Map update(UUID id, Map<String, Object> request) {
        return http.put(SHIFTS + "/" + id, request, Map.class);
    }

    public void delete(UUID id) {
        http.delete(SHIFTS + "/" + id);
    }

    // -- Shift Schedules --

    public PageResponse<Map> listSchedules(PageRequest pageRequest) {
        return http.get(withPagination(SCHEDULES, pageRequest), pageType(Map.class));
    }

    public Map getScheduleById(UUID id) {
        return http.get(SCHEDULES + "/" + id, Map.class);
    }

    public Map createSchedule(Map<String, Object> request) {
        return http.post(SCHEDULES, request, Map.class);
    }

    public Map updateSchedule(UUID id, Map<String, Object> request) {
        return http.put(SCHEDULES + "/" + id, request, Map.class);
    }

    public void deleteSchedule(UUID id) {
        http.delete(SCHEDULES + "/" + id);
    }

    // -- Shift Swap Requests --

    public PageResponse<Map> listSwapRequests(PageRequest pageRequest) {
        return http.get(withPagination(SWAPS, pageRequest), pageType(Map.class));
    }

    public Map createSwapRequest(Map<String, Object> request) {
        return http.post(SWAPS, request, Map.class);
    }

    public Map approveSwapRequest(UUID id) {
        return http.post(SWAPS + "/" + id + "/approve", null, Map.class);
    }

    public Map rejectSwapRequest(UUID id) {
        return http.post(SWAPS + "/" + id + "/reject", null, Map.class);
    }
}
