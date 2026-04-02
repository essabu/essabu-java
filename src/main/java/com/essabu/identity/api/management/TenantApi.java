package com.essabu.identity.api.management;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.identity.model.management.response.TenantResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing tenant resources in the Essabu Identity module.
 *
 * Provides typed methods to interact with the tenant REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - list: list operation
 * - list: list operation
 * - suspend: suspend operation
 * - activate: activate operation
 *
 * Base path: /api/identity/tenants
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class TenantApi extends BaseApi {

    private static final String BASE_PATH = "/api/identity/tenants";

    public TenantApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Lists tenants with pagination.
     */
    public PageResponse<TenantResponse> list(PageRequest pageRequest) {
        String path = withPagination(BASE_PATH, pageRequest);
        return http.get(path, new TypeReference<>() {});
    }

    /**
     * Lists tenants with pagination.
     */
    public PageResponse<TenantResponse> list(int page, int size) {
        String path = BASE_PATH + "?page=" + page + "&size=" + size;
        return http.get(path, new TypeReference<>() {});
    }

    /**
     * Retrieves a tenant by its identifier.
     */
    public TenantResponse getById(UUID id) {
        return http.get(BASE_PATH + "/" + id, TenantResponse.class);
    }

    /**
     * Suspend un tenant.
     */
    public TenantResponse suspend(UUID id) {
        return http.post(BASE_PATH + "/" + id + "/suspend", null, TenantResponse.class);
    }

    /**
     * Active un tenant.
     */
    public TenantResponse activate(UUID id) {
        return http.post(BASE_PATH + "/" + id + "/activate", null, TenantResponse.class);
    }
}
