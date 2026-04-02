package com.essabu.identity;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for session management operations.
 * Endpoint base: /api/identity/sessions
 */
public final class SessionApi extends BaseApi {

    private static final String BASE = "/api/identity/sessions";

    public SessionApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(BASE, pageRequest), pageType(Map.class));
    }

    public void revoke(UUID id) {
        http.delete(BASE + "/" + id);
    }

    public void revokeAll() {
        http.delete(BASE);
    }
}
