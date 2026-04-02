package com.essabu.identity.api.management;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.identity.model.auth.response.MessageResponse;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.identity.model.management.request.CreateCompanyRequest;
import com.essabu.identity.model.management.request.InviteUserRequest;
import com.essabu.identity.model.management.request.UpdateCompanyRequest;
import com.essabu.identity.model.management.response.CompanyResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing company resources in the Essabu Identity module.
 *
 * Provides typed methods to interact with the company REST API endpoints
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
 * - update: update operation
 * - inviteUser: invite user operation
 *
 * Base path: /api/identity/companies
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class CompanyApi extends BaseApi {

    private static final String BASE_PATH = "/api/identity/companies";

    public CompanyApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Creates a new company.
     */
    public CompanyResponse create(CreateCompanyRequest request) {
        return http.post(BASE_PATH, request, CompanyResponse.class);
    }

    /**
     * Lists companies with pagination.
     */
    public PageResponse<CompanyResponse> list(int page, int size) {
        String path = BASE_PATH + "?page=" + page + "&size=" + size;
        return http.get(path, new TypeReference<>() {});
    }

    /**
     * Lists companies with pagination.
     */
    public PageResponse<CompanyResponse> list(PageRequest pageRequest) {
        String path = withPagination(BASE_PATH, pageRequest);
        return http.get(path, new TypeReference<>() {});
    }

    /**
     * Retrieves a company by its identifier.
     */
    public CompanyResponse getById(UUID id) {
        return http.get(BASE_PATH + "/" + id, CompanyResponse.class);
    }

    /**
     * Updates a company.
     */
    public CompanyResponse update(UUID id, UpdateCompanyRequest request) {
        return http.put(BASE_PATH + "/" + id, request, CompanyResponse.class);
    }

    /**
     * Invites a user into a company.
     */
    public MessageResponse inviteUser(UUID companyId, InviteUserRequest request) {
        return http.post(BASE_PATH + "/" + companyId + "/invite-user", request, MessageResponse.class);
    }
}
