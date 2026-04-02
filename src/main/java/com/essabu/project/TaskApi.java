package com.essabu.project;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for task and task comment operations.
 * Endpoint bases: /api/project/tasks, /api/project/task-comments
 */
public final class TaskApi extends BaseApi {

    private static final String TASKS = "/api/project/tasks";
    private static final String COMMENTS = "/api/project/task-comments";

    public TaskApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(TASKS, pageRequest), pageType(Map.class));
    }

    public Map getById(UUID id) { return http.get(TASKS + "/" + id, Map.class); }
    public Map create(Map<String, Object> request) { return http.post(TASKS, request, Map.class); }
    public Map update(UUID id, Map<String, Object> request) { return http.put(TASKS + "/" + id, request, Map.class); }
    public void delete(UUID id) { http.delete(TASKS + "/" + id); }

    // -- Comments --
    public PageResponse<Map> listComments(UUID taskId, PageRequest pageRequest) {
        String path = withParam(COMMENTS, "taskId", taskId);
        return http.get(withPagination(path, pageRequest), pageType(Map.class));
    }

    public Map createComment(Map<String, Object> request) { return http.post(COMMENTS, request, Map.class); }
    public Map updateComment(UUID id, Map<String, Object> request) { return http.put(COMMENTS + "/" + id, request, Map.class); }
    public void deleteComment(UUID id) { http.delete(COMMENTS + "/" + id); }
}
