package com.essabu.identity.api.management;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.identity.model.auth.response.LoginResponse;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.identity.model.management.request.CreateUserRequest;
import com.essabu.identity.model.management.response.UserResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing user resources in the Essabu Identity module.
 *
 * Provides typed methods to interact with the user REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - list: list operation
 * - list: list operation
 * - switchTenant: switch tenant operation
 *
 * Base path: /api/identity/users
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class UserApi extends BaseApi {

    private static final String BASE_PATH = "/api/identity/users";

    public UserApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Creates a new user.
     */
    public UserResponse create(CreateUserRequest request) {
        return http.post(BASE_PATH, request, UserResponse.class);
    }

    /**
     * Lists the users of a company with pagination.
     */
    public PageResponse<UserResponse> list(UUID companyId, int page, int size) {
        String path = BASE_PATH + "?companyId=" + companyId + "&page=" + page + "&size=" + size;
        return http.get(path, new TypeReference<>() {});
    }

    /**
     * Lists the users of a company with pagination.
     */
    public PageResponse<UserResponse> list(UUID companyId, PageRequest pageRequest) {
        String path = withParam(BASE_PATH, "companyId", companyId);
        path = withPagination(path, pageRequest);
        return http.get(path, new TypeReference<>() {});
    }

    /**
     * Retrieves a user by their identifier.
     */
    public UserResponse getById(UUID id) {
        return http.get(BASE_PATH + "/" + id, UserResponse.class);
    }

    /**
     * Changes the active tenant of the current user.
     */
    public LoginResponse switchTenant(UUID companyId) {
        return http.post(BASE_PATH + "/switch-tenant/" + companyId, null, LoginResponse.class);
    }
}
