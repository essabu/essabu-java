package com.essabu.accounting.api.transactions;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.accounting.model.transactions.request.CreateJournalRequest;
import com.essabu.accounting.model.transactions.request.UpdateJournalRequest;
import com.essabu.accounting.model.transactions.response.JournalResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing journal resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the journal REST API endpoints
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
 * - delete: delete operation
 *
 * Base path: /api/accounting/journals
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class JournalApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/journals";

    public JournalApi(HttpClientWrapper http) {
        super(http);
    }

    public JournalResponse create(CreateJournalRequest request) {
        return http.post(BASE_PATH, request, JournalResponse.class);
    }

    public JournalResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, JournalResponse.class);
    }

    public PageResponse<JournalResponse> list(UUID companyId, PageRequest page) {
        String path = withPagination(BASE_PATH + "?companyId=" + companyId, page);
        return http.get(path, new TypeReference<>() {});
    }

    public JournalResponse update(UUID id, UpdateJournalRequest request) {
        return http.put(BASE_PATH + "/" + id, request, JournalResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }
}
