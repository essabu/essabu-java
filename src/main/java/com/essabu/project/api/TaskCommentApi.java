package com.essabu.project.api;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.project.model.request.CreateTaskCommentRequest;
import com.essabu.project.model.request.UpdateTaskCommentRequest;
import com.essabu.project.model.response.TaskCommentResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * API client for managing task comment resources in the Essabu Project module.
 *
 * Provides typed methods to interact with the task comment REST API endpoints
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
 * Base path: /api/project/task-comments
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class TaskCommentApi extends BaseApi {

    private static final String BASE_PATH = "/api/project/task-comments";

    public TaskCommentApi(HttpClientWrapper http) { super(http); }

    public PageResponse<TaskCommentResponse> list(PageRequest page) {
        return http.get(withPagination(BASE_PATH, page), new TypeReference<>() {});
    }
    public TaskCommentResponse getById(String id) { return http.get(BASE_PATH + "/" + id, TaskCommentResponse.class); }
    public TaskCommentResponse create(CreateTaskCommentRequest request) { return http.post(BASE_PATH, request, TaskCommentResponse.class); }
    public TaskCommentResponse update(String id, UpdateTaskCommentRequest request) { return http.patch(BASE_PATH + "/" + id, request, TaskCommentResponse.class); }
    public void delete(String id) { http.delete(BASE_PATH + "/" + id); }
}
