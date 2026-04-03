package com.essabu.compliance;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for compliance audit log operations.
 * Endpoint base: /api/compliance/audits
 */
public final class AuditApi extends BaseApi {

    private static final String BASE = "/api/compliance/audits";

    public AuditApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(PageRequest pageRequest) {
        String path = withPagination(BASE, pageRequest);
        return http.get(path, pageType(Map.class));
    }

    public Map getById(UUID id) {
        return http.get(BASE + "/" + id, Map.class);
    }

    public Map create(Map<String, Object> request) {
        return http.post(BASE, request, Map.class);
    }

    public Map update(UUID id, Map<String, Object> request) {
        return http.put(BASE + "/" + id, request, Map.class);
    }

    public void delete(UUID id) {
        http.delete(BASE + "/" + id);
    }
}
