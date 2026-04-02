package com.essabu.identity.api.management;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.identity.model.management.request.AddGroupMemberRequest;
import com.essabu.identity.model.management.request.CreateCompanyGroupRequest;
import com.essabu.identity.model.management.response.CompanyGroupResponse;

import java.util.UUID;

/**
 * API client for managing company group resources in the Essabu Identity module.
 *
 * Provides typed methods to interact with the company group REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - addMember: add member operation
 *
 * Base path: /api/identity/company-groups
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class CompanyGroupApi extends BaseApi {

    private static final String BASE_PATH = "/api/identity/company-groups";

    public CompanyGroupApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Creates a new company group.
     */
    public CompanyGroupResponse create(CreateCompanyGroupRequest request) {
        return http.post(BASE_PATH, request, CompanyGroupResponse.class);
    }

    /**
     * Adds a member to a company group.
     */
    public void addMember(UUID groupId, AddGroupMemberRequest request) {
        http.postVoid(BASE_PATH + "/" + groupId + "/members", request);
    }
}
