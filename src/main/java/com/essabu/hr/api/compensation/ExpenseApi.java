package com.essabu.hr.api.compensation;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.BaseApi;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.hr.model.compensation.request.CreateExpenseReportRequest;
import com.essabu.hr.model.compensation.response.ExpenseReportResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Map;
import java.util.UUID;

/**
 * API client for managing expense resources in the Essabu HR module.
 *
 * Provides typed methods to interact with the expense REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - list: list operation
 * - submit: submit operation
 * - approve: approve operation
 * - reject: reject operation
 *
 * Base path: /api/hr/expense-reports
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class ExpenseApi extends BaseApi {

    private static final String BASE_PATH = "/api/hr/expense-reports";

    public ExpenseApi(HttpClientWrapper http) {
        super(http);
    }

    public ExpenseReportResponse create(CreateExpenseReportRequest request) {
        return http.post(BASE_PATH, request, ExpenseReportResponse.class);
    }

    public ExpenseReportResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, ExpenseReportResponse.class);
    }

    public PageResponse<ExpenseReportResponse> list(PageRequest page) {
        return http.get(withPagination(BASE_PATH, page),
                new TypeReference<PageResponse<ExpenseReportResponse>>() {});
    }

    public ExpenseReportResponse submit(UUID id) {
        return http.put(BASE_PATH + "/" + id + "/submit", null, ExpenseReportResponse.class);
    }

    public ExpenseReportResponse approve(UUID id, UUID approvedBy) {
        return http.put(BASE_PATH + "/" + id + "/approve",
                Map.of("approvedBy", approvedBy),
                ExpenseReportResponse.class);
    }

    public ExpenseReportResponse reject(UUID id) {
        return http.put(BASE_PATH + "/" + id + "/reject", null, ExpenseReportResponse.class);
    }
}
