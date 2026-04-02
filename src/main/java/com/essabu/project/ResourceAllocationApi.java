package com.essabu.project;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for resource allocation operations.
 * Endpoint base: /api/project/resource-allocations
 */
public final class ResourceAllocationApi extends BaseApi {

    private static final String BASE = "/api/project/resource-allocations";

    public ResourceAllocationApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(BASE, pageRequest), pageType(Map.class));
    }

    public Map getById(UUID id) { return http.get(BASE + "/" + id, Map.class); }
    public Map create(Map<String, Object> request) { return http.post(BASE, request, Map.class); }
    public Map update(UUID id, Map<String, Object> request) { return http.put(BASE + "/" + id, request, Map.class); }
    public void delete(UUID id) { http.delete(BASE + "/" + id); }
}
