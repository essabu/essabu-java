package com.essabu.identity.api.management;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.identity.model.management.request.CreateRoleRequest;
import com.essabu.identity.model.management.response.RoleResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing role resources in the Essabu Identity module.
 *
 * Provides typed methods to interact with the role REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - list: list operation
 *
 * Base path: /api/identity/roles
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class RoleApi extends BaseApi {

    private static final String BASE_PATH = "/api/identity/roles";

    public RoleApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Creates a new role.
     */
    public RoleResponse create(CreateRoleRequest request) {
        return http.post(BASE_PATH, request, RoleResponse.class);
    }

    /**
     * Lists the roles of a company.
     */
    public List<RoleResponse> list(UUID companyId) {
        String path = withParam(BASE_PATH, "companyId", companyId);
        return http.get(path, new TypeReference<>() {});
    }
}
