package com.essabu.identity.api.management;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.identity.model.management.response.PermissionResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

/**
 * API client for managing permission resources in the Essabu Identity module.
 *
 * Provides typed methods to interact with the permission REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - list: list operation
 * - listByModule: list by module operation
 *
 * Base path: /api/identity/permissions
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class PermissionApi extends BaseApi {

    private static final String BASE_PATH = "/api/identity/permissions";

    public PermissionApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Liste toutes les permissions disponibles.
     */
    public List<PermissionResponse> list() {
        return http.get(BASE_PATH, new TypeReference<>() {});
    }

    /**
     * Lists permissions filtered by module.
     */
    public List<PermissionResponse> listByModule(String module) {
        String path = withParam(BASE_PATH, "module", module);
        return http.get(path, new TypeReference<>() {});
    }
}
