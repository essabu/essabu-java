package com.essabu.project.api;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.project.model.request.CreateReportRequest;
import com.essabu.project.model.request.UpdateReportRequest;
import com.essabu.project.model.response.ReportResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * API client for managing report resources in the Essabu Project module.
 *
 * Provides typed methods to interact with the report REST API endpoints
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
 * Base path: /api/project/reports
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class ReportApi extends BaseApi {

    private static final String BASE_PATH = "/api/project/reports";

    public ReportApi(HttpClientWrapper http) { super(http); }

    public PageResponse<ReportResponse> list(PageRequest page) {
        return http.get(withPagination(BASE_PATH, page), new TypeReference<>() {});
    }
    public ReportResponse getById(String id) { return http.get(BASE_PATH + "/" + id, ReportResponse.class); }
    public ReportResponse create(CreateReportRequest request) { return http.post(BASE_PATH, request, ReportResponse.class); }
    public ReportResponse update(String id, UpdateReportRequest request) { return http.patch(BASE_PATH + "/" + id, request, ReportResponse.class); }
    public void delete(String id) { http.delete(BASE_PATH + "/" + id); }
}
