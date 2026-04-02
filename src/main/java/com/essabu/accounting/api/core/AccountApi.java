package com.essabu.accounting.api.core;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.accounting.model.core.request.CreateAccountRequest;
import com.essabu.accounting.model.core.request.UpdateAccountRequest;
import com.essabu.accounting.model.core.response.AccountResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing account resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the account REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - list: list operation
 * - update: update operation
 * - deactivate: deactivate operation
 * - initializeChart: initialize chart operation
 *
 * Base path: /api/accounting/accounts
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class AccountApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/accounts";

    public AccountApi(HttpClientWrapper http) {
        super(http);
    }

    public AccountResponse create(CreateAccountRequest request) {
        return http.post(BASE_PATH, request, AccountResponse.class);
    }

    public AccountResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, AccountResponse.class);
    }

    public PageResponse<AccountResponse> list(UUID companyId, PageRequest page) {
        String path = withPagination(BASE_PATH + "?companyId=" + companyId, page);
        return http.get(path, new TypeReference<>() {});
    }

    public AccountResponse update(UUID id, UpdateAccountRequest request) {
        return http.put(BASE_PATH + "/" + id, request, AccountResponse.class);
    }

    public AccountResponse deactivate(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/deactivate", AccountResponse.class);
    }

    public void initializeChart(UUID companyId) {
        http.postEmptyVoid(BASE_PATH + "/initialize-chart?companyId=" + companyId);
    }
}
