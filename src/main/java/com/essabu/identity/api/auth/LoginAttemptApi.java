package com.essabu.identity.api.auth;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * API client for managing login attempt resources in the Essabu Identity module.
 *
 * Provides typed methods to interact with the login attempt REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Base path: /api/identity/login-attempts
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class LoginAttemptApi extends BaseApi {

    private static final String BASE_PATH = "/api/identity/login-attempts";

    public LoginAttemptApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Lists login attempts.
     */
    public List<Map<String, Object>> list(PageRequest page) {
        String path = withPagination(BASE_PATH, page);
        return http.get(path, new TypeReference<>() {});
    }

    /**
     * Lists recent failed login attempts.
     */
    public List<Map<String, Object>> recentFailures() {
        return http.get(BASE_PATH + "/recent-failures", new TypeReference<>() {});
    }
}
