package com.essabu.asset;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for fleet management operations (fuel logs, trip logs).
 * Endpoint bases: /api/asset/fuel-logs, /api/asset/trip-logs
 */
public final class FleetApi extends BaseApi {

    private static final String FUEL_LOGS = "/api/asset/fuel-logs";
    private static final String TRIP_LOGS = "/api/asset/trip-logs";

    public FleetApi(HttpClientWrapper http) {
        super(http);
    }

    // -- Fuel Logs --
    public PageResponse<Map> listFuelLogs(PageRequest pageRequest) {
        return http.get(withPagination(FUEL_LOGS, pageRequest), pageType(Map.class));
    }
    public Map getFuelLogById(UUID id) { return http.get(FUEL_LOGS + "/" + id, Map.class); }
    public Map createFuelLog(Map<String, Object> request) { return http.post(FUEL_LOGS, request, Map.class); }
    public Map updateFuelLog(UUID id, Map<String, Object> request) { return http.put(FUEL_LOGS + "/" + id, request, Map.class); }
    public void deleteFuelLog(UUID id) { http.delete(FUEL_LOGS + "/" + id); }

    // -- Trip Logs --
    public PageResponse<Map> listTripLogs(PageRequest pageRequest) {
        return http.get(withPagination(TRIP_LOGS, pageRequest), pageType(Map.class));
    }
    public Map getTripLogById(UUID id) { return http.get(TRIP_LOGS + "/" + id, Map.class); }
    public Map createTripLog(Map<String, Object> request) { return http.post(TRIP_LOGS, request, Map.class); }
    public Map updateTripLog(UUID id, Map<String, Object> request) { return http.put(TRIP_LOGS + "/" + id, request, Map.class); }
    public void deleteTripLog(UUID id) { http.delete(TRIP_LOGS + "/" + id); }
}
