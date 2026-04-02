package com.essabu.accounting.api.transactions;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.accounting.model.transactions.request.CreateJournalEntryRequest;
import com.essabu.accounting.model.transactions.request.UpdateJournalEntryRequest;
import com.essabu.accounting.model.transactions.response.JournalEntryResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing journal entry resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the journal entry REST API endpoints
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
 * - validate: validate operation
 * - reverse: reverse operation
 *
 * Base path: /api/accounting/journal-entries
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class JournalEntryApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/journal-entries";

    public JournalEntryApi(HttpClientWrapper http) {
        super(http);
    }

    public JournalEntryResponse create(CreateJournalEntryRequest request) {
        return http.post(BASE_PATH, request, JournalEntryResponse.class);
    }

    public JournalEntryResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, JournalEntryResponse.class);
    }

    public PageResponse<JournalEntryResponse> list(UUID companyId, PageRequest page) {
        String path = withPagination(BASE_PATH + "?companyId=" + companyId, page);
        return http.get(path, new TypeReference<>() {});
    }

    public JournalEntryResponse update(UUID id, UpdateJournalEntryRequest request) {
        return http.put(BASE_PATH + "/" + id, request, JournalEntryResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }

    public JournalEntryResponse validate(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/post", JournalEntryResponse.class);
    }

    public JournalEntryResponse reverse(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/reverse", JournalEntryResponse.class);
    }
}
