package com.essabu.hr.api.workforce;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.BaseApi;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.hr.model.workforce.request.CreateLeaveRequestRequest;
import com.essabu.hr.model.workforce.response.LeaveBalanceResponse;
import com.essabu.hr.model.workforce.response.LeaveRequestResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * API client for managing leave resources in the Essabu HR module.
 *
 * Provides typed methods to interact with the leave REST API endpoints
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
 * - reject: reject operation
 * - cancel: cancel operation
 *
 * Base path: /api/hr/leave-requests
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class LeaveApi extends BaseApi {

    private static final String BASE_PATH = "/api/hr/leave-requests";

    public LeaveApi(HttpClientWrapper http) {
        super(http);
    }

    public LeaveRequestResponse create(CreateLeaveRequestRequest request) {
        return http.post(BASE_PATH, request, LeaveRequestResponse.class);
    }

    public PageResponse<LeaveRequestResponse> list(PageRequest page) {
        return http.get(withPagination(BASE_PATH, page),
                new TypeReference<PageResponse<LeaveRequestResponse>>() {});
    }

    public LeaveRequestResponse approve(UUID id, UUID approvedBy) {
        return http.put(BASE_PATH + "/" + id + "/approve",
                Map.of("approvedBy", approvedBy),
                LeaveRequestResponse.class);
    }

    public LeaveRequestResponse reject(UUID id) {
        return http.put(BASE_PATH + "/" + id + "/reject", null, LeaveRequestResponse.class);
    }

    public LeaveRequestResponse cancel(UUID id) {
        return http.put(BASE_PATH + "/" + id + "/cancel", null, LeaveRequestResponse.class);
    }

    public List<LeaveBalanceResponse> getBalances(UUID employeeId) {
        return http.get(withParam("/api/hr/leave-balances", "employeeId", employeeId),
                new TypeReference<>() {});
    }
}
