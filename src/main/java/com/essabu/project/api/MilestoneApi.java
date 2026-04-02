package com.essabu.project.api;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.project.model.request.CreateMilestoneRequest;
import com.essabu.project.model.request.UpdateMilestoneRequest;
import com.essabu.project.model.response.MilestoneResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * API client for managing milestone resources in the Essabu Project module.
 *
 * Provides typed methods to interact with the milestone REST API endpoints
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
 * Base path: /api/project/milestones
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class MilestoneApi extends BaseApi {

    private static final String BASE_PATH = "/api/project/milestones";

    public MilestoneApi(HttpClientWrapper http) { super(http); }

    public PageResponse<MilestoneResponse> list(PageRequest page) {
        return http.get(withPagination(BASE_PATH, page), new TypeReference<>() {});
    }
    public MilestoneResponse getById(String id) { return http.get(BASE_PATH + "/" + id, MilestoneResponse.class); }
    public MilestoneResponse create(CreateMilestoneRequest request) { return http.post(BASE_PATH, request, MilestoneResponse.class); }
    public MilestoneResponse update(String id, UpdateMilestoneRequest request) { return http.patch(BASE_PATH + "/" + id, request, MilestoneResponse.class); }
    public void delete(String id) { http.delete(BASE_PATH + "/" + id); }
}
