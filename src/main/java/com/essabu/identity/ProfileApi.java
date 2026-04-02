package com.essabu.identity;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;

import java.util.Map;

/**
 * API client for user profile operations.
 * Endpoint base: /api/identity/profiles
 */
public final class ProfileApi extends BaseApi {

    private static final String BASE = "/api/identity/profiles";

    public ProfileApi(HttpClientWrapper http) {
        super(http);
    }

    public Map getMyProfile() {
        return http.get(BASE + "/me", Map.class);
    }

    public Map updateMyProfile(Map<String, Object> request) {
        return http.put(BASE + "/me", request, Map.class);
    }
}
