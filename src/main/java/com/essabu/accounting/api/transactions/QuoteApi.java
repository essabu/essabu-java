package com.essabu.accounting.api.transactions;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.accounting.model.transactions.request.CreateQuoteRequest;
import com.essabu.accounting.model.transactions.request.UpdateQuoteRequest;
import com.essabu.accounting.model.transactions.response.InvoiceResponse;
import com.essabu.accounting.model.transactions.response.QuoteResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing quote resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the quote REST API endpoints
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
 * - send: send operation
 * - accept: accept operation
 * - reject: reject operation
 * - convertToInvoice: convert to invoice operation
 *
 * Base path: /api/accounting/quotes
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class QuoteApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/quotes";

    public QuoteApi(HttpClientWrapper http) {
        super(http);
    }

    public QuoteResponse create(CreateQuoteRequest request) {
        return http.post(BASE_PATH, request, QuoteResponse.class);
    }

    public QuoteResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, QuoteResponse.class);
    }

    public PageResponse<QuoteResponse> list(UUID companyId, PageRequest page) {
        String path = withPagination(BASE_PATH + "?companyId=" + companyId, page);
        return http.get(path, new TypeReference<>() {});
    }

    public QuoteResponse update(UUID id, UpdateQuoteRequest request) {
        return http.put(BASE_PATH + "/" + id, request, QuoteResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }

    public QuoteResponse send(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/send", QuoteResponse.class);
    }

    public QuoteResponse accept(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/accept", QuoteResponse.class);
    }

    public QuoteResponse reject(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/reject", QuoteResponse.class);
    }

    public InvoiceResponse convertToInvoice(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/convert-to-invoice", InvoiceResponse.class);
    }

    public byte[] downloadPdf(UUID id) {
        return http.getBytes(BASE_PATH + "/" + id + "/pdf");
    }
}
