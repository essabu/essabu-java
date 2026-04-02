package com.essabu.hr;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for HR employee operations.
 * Endpoint base: /api/hr/employees
 */
public final class EmployeeApi extends BaseApi {

    private static final String BASE = "/api/hr/employees";

    public EmployeeApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(UUID companyId, PageRequest pageRequest) {
        String path = withParam(BASE, "companyId", companyId);
        path = withPagination(path, pageRequest);
        return http.get(path, pageType(Map.class));
    }

    public Map getById(UUID id) {
        return http.get(BASE + "/" + id, Map.class);
    }

    public Map create(Map<String, Object> request) {
        return http.post(BASE, request, Map.class);
    }

    public Map update(UUID id, Map<String, Object> request) {
        return http.put(BASE + "/" + id, request, Map.class);
    }

    public void delete(UUID id) {
        http.delete(BASE + "/" + id);
    }

    public Map getLeaveBalance(UUID employeeId) {
        return http.get(BASE + "/" + employeeId + "/leave-balance", Map.class);
    }
}
