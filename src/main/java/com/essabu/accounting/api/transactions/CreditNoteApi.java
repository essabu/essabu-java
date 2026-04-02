package com.essabu.accounting.api.transactions;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.accounting.model.transactions.request.CreateCreditNoteRequest;
import com.essabu.accounting.model.transactions.request.UpdateCreditNoteRequest;
import com.essabu.accounting.model.transactions.response.CreditNoteResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing credit note resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the credit note REST API endpoints
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
 * - finalize: finalize operation
 * - apply: apply operation
 *
 * Base path: /api/accounting/credit-notes
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class CreditNoteApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/credit-notes";

    public CreditNoteApi(HttpClientWrapper http) {
        super(http);
    }

    public CreditNoteResponse create(CreateCreditNoteRequest request) {
        return http.post(BASE_PATH, request, CreditNoteResponse.class);
    }

    public CreditNoteResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, CreditNoteResponse.class);
    }

    public PageResponse<CreditNoteResponse> list(UUID companyId, PageRequest page) {
        String path = withPagination(BASE_PATH + "?companyId=" + companyId, page);
        return http.get(path, new TypeReference<>() {});
    }

    public CreditNoteResponse update(UUID id, UpdateCreditNoteRequest request) {
        return http.put(BASE_PATH + "/" + id, request, CreditNoteResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }

    public CreditNoteResponse finalize(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/finalize", CreditNoteResponse.class);
    }

    public CreditNoteResponse apply(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/apply", CreditNoteResponse.class);
    }

    public byte[] downloadPdf(UUID id) {
        return http.getBytes(BASE_PATH + "/" + id + "/pdf");
    }
}
