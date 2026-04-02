package com.essabu.identity.api.management;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.identity.model.management.request.CreateApiKeyRequest;
import com.essabu.identity.model.management.response.ApiKeyCreatedResponse;
import com.essabu.identity.model.management.response.ApiKeyResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing key resources in the Essabu Identity module.
 *
 * Provides typed methods to interact with the key REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - list: list operation
 * - revoke: revoke operation
 * - rotate: rotate operation
 *
 * Base path: /api/identity/api-keys
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class ApiKeyApi extends BaseApi {

    private static final String BASE_PATH = "/api/identity/api-keys";

    public ApiKeyApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Creates a new API key.
     */
    public ApiKeyCreatedResponse create(CreateApiKeyRequest request) {
        return http.post(BASE_PATH, request, ApiKeyCreatedResponse.class);
    }

    /**
     * Lists the API keys of a company.
     */
    public List<ApiKeyResponse> list(UUID companyId) {
        String path = withParam(BASE_PATH, "companyId", companyId);
        return http.get(path, new TypeReference<>() {});
    }

    /**
     * Revokes an API key.
     */
    public void revoke(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }

    /**
     * Generates a new API key to replace the old one (rotation).
     */
    public ApiKeyCreatedResponse rotate(UUID id) {
        return http.post(BASE_PATH + "/" + id + "/rotate", null, ApiKeyCreatedResponse.class);
    }
}
