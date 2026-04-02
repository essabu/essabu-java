package com.essabu.hr.api.core;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.BaseApi;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.hr.model.core.request.CreateEmployeeRequest;
import com.essabu.hr.model.core.request.UpdateEmployeeRequest;
import com.essabu.hr.model.core.response.EmployeeResponse;
import com.essabu.hr.model.core.response.OrgChartResponse;
import com.essabu.hr.model.workforce.response.LeaveBalanceResponse;
import com.essabu.hr.model.admin.response.AuditLogResponse;
import com.essabu.hr.model.talent.response.EmployeeDocumentResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing employee resources in the Essabu HR module.
 *
 * Provides typed methods to interact with the employee REST API endpoints
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
 * Base path: /api/hr/employees
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class EmployeeApi extends BaseApi {

    private static final String BASE_PATH = "/api/hr/employees";

    public EmployeeApi(HttpClientWrapper http) {
        super(http);
    }

    public EmployeeResponse create(CreateEmployeeRequest request) {
        return http.post(BASE_PATH, request, EmployeeResponse.class);
    }

    public EmployeeResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, EmployeeResponse.class);
    }

    public PageResponse<EmployeeResponse> list(PageRequest page) {
        return http.get(withPagination(BASE_PATH, page),
                new TypeReference<PageResponse<EmployeeResponse>>() {});
    }

    public EmployeeResponse update(UUID id, UpdateEmployeeRequest request) {
        return http.put(BASE_PATH + "/" + id, request, EmployeeResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }

    public List<LeaveBalanceResponse> getLeaveBalances(UUID employeeId) {
        return http.get(BASE_PATH + "/" + employeeId + "/leave-balance",
                new TypeReference<>() {});
    }

    public List<AuditLogResponse> getHistory(UUID employeeId) {
        return http.get(BASE_PATH + "/" + employeeId + "/history",
                new TypeReference<>() {});
    }

    public List<EmployeeDocumentResponse> getDocuments(UUID employeeId) {
        return http.get(BASE_PATH + "/" + employeeId + "/documents",
                new TypeReference<>() {});
    }

    public List<EmployeeResponse> getOrgTree(UUID employeeId) {
        return http.get(BASE_PATH + "/" + employeeId + "/org-tree",
                new TypeReference<>() {});
    }

    public OrgChartResponse getOrgChart() {
        return http.get(BASE_PATH + "/org-chart", OrgChartResponse.class);
    }
}
