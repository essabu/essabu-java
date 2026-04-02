package com.essabu.hr.api.admin;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.BaseApi;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.hr.model.admin.response.AuditLogResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing history resources in the Essabu HR module.
 *
 * Provides typed methods to interact with the history REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - listByEmployee: list by employee operation
 * - listByEntityType: list by entity type operation
 *
 * Base path: /api/hr/history
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class HistoryApi extends BaseApi {

    private static final String BASE_PATH = "/api/hr/history";

    public HistoryApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<AuditLogResponse> listByEmployee(UUID employeeId, PageRequest page) {
        String path = withPagination(BASE_PATH + "?employeeId=" + employeeId, page);
        return http.get(path, new TypeReference<PageResponse<AuditLogResponse>>() {});
    }

    public PageResponse<AuditLogResponse> listByEntityType(String entityType, PageRequest page) {
        String path = withPagination(BASE_PATH + "?entityType=" + entityType, page);
        return http.get(path, new TypeReference<PageResponse<AuditLogResponse>>() {});
    }
}
