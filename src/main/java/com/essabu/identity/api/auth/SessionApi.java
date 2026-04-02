package com.essabu.identity.api.auth;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.identity.model.auth.response.MessageResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * API client for managing session resources in the Essabu Identity module.
 *
 * Provides typed methods to interact with the session REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - invalidate: invalidate operation
 * - revokeAll: revoke all operation
 *
 * Base path: /api/identity/sessions
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class SessionApi extends BaseApi {

    private static final String BASE_PATH = "/api/identity/sessions";

    public SessionApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Lists all active sessions of the current user.
     */
    public List<Map<String, Object>> list() {
        return http.get(BASE_PATH, new TypeReference<>() {});
    }

    /**
     * Retrieves the details of a specific session.
     */
    public Map<String, Object> get(UUID sessionId) {
        return http.get(BASE_PATH + "/" + sessionId, new TypeReference<>() {});
    }

    /**
     * Invalide une session specifique.
     */
    public void invalidate(UUID sessionId) {
        http.delete(BASE_PATH + "/" + sessionId);
    }

    /**
     * Revokes all sessions of the current user.
     */
    public void revokeAll() {
        http.delete(BASE_PATH);
    }
}
