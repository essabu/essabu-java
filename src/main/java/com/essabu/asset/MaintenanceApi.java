package com.essabu.asset;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for maintenance log and maintenance schedule operations.
 * Endpoint bases: /api/asset/maintenance-logs, /api/asset/maintenance-schedules
 */
public final class MaintenanceApi extends BaseApi {

    private static final String LOGS = "/api/asset/maintenance-logs";
    private static final String SCHEDULES = "/api/asset/maintenance-schedules";

    public MaintenanceApi(HttpClientWrapper http) {
        super(http);
    }

    // -- Maintenance Logs --
    public PageResponse<Map> listLogs(PageRequest pageRequest) {
        return http.get(withPagination(LOGS, pageRequest), pageType(Map.class));
    }
    public Map getLogById(UUID id) { return http.get(LOGS + "/" + id, Map.class); }
    public Map createLog(Map<String, Object> request) { return http.post(LOGS, request, Map.class); }
    public Map updateLog(UUID id, Map<String, Object> request) { return http.put(LOGS + "/" + id, request, Map.class); }
    public void deleteLog(UUID id) { http.delete(LOGS + "/" + id); }

    // -- Maintenance Schedules --
    public PageResponse<Map> listSchedules(PageRequest pageRequest) {
        return http.get(withPagination(SCHEDULES, pageRequest), pageType(Map.class));
    }
    public Map getScheduleById(UUID id) { return http.get(SCHEDULES + "/" + id, Map.class); }
    public Map createSchedule(Map<String, Object> request) { return http.post(SCHEDULES, request, Map.class); }
    public Map updateSchedule(UUID id, Map<String, Object> request) { return http.put(SCHEDULES + "/" + id, request, Map.class); }
    public void deleteSchedule(UUID id) { http.delete(SCHEDULES + "/" + id); }
}
