package com.essabu.hr.api.core;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.BaseApi;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.hr.model.core.request.CreateDepartmentRequest;
import com.essabu.hr.model.core.request.UpdateDepartmentRequest;
import com.essabu.hr.model.core.response.DepartmentResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing department resources in the Essabu HR module.
 *
 * Provides typed methods to interact with the department REST API endpoints
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
 * Base path: /api/hr/departments
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class DepartmentApi extends BaseApi {

    private static final String BASE_PATH = "/api/hr/departments";

    public DepartmentApi(HttpClientWrapper http) {
        super(http);
    }

    public DepartmentResponse create(CreateDepartmentRequest request) {
        return http.post(BASE_PATH, request, DepartmentResponse.class);
    }

    public DepartmentResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, DepartmentResponse.class);
    }

    public PageResponse<DepartmentResponse> list(PageRequest page) {
        return http.get(withPagination(BASE_PATH, page),
                new TypeReference<PageResponse<DepartmentResponse>>() {});
    }

    public DepartmentResponse update(UUID id, UpdateDepartmentRequest request) {
        return http.put(BASE_PATH + "/" + id, request, DepartmentResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }
}
