package com.essabu.accounting.api.transactions;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.accounting.model.transactions.request.CreateInvoiceRequest;
import com.essabu.accounting.model.transactions.request.CreateRecurringInvoiceRequest;
import com.essabu.accounting.model.transactions.request.UpdateInvoiceRequest;
import com.essabu.accounting.model.transactions.request.UpdateRecurringInvoiceRequest;
import com.essabu.accounting.model.transactions.response.InvoiceResponse;
import com.essabu.accounting.model.transactions.response.RecurringInvoiceResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing invoice resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the invoice REST API endpoints
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
 * - send: send operation
 * - markAsPaid: mark as paid operation
 * - cancel: cancel operation
 * - createRecurring: create recurring operation
 * - listRecurring: list recurring operation
 * - updateRecurring: update recurring operation
 * - deleteRecurring: delete recurring operation
 * - activateRecurring: activate recurring operation
 * - deactivateRecurring: deactivate recurring operation
 *
 * Base path: /api/accounting/invoices
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class InvoiceApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/invoices";

    public InvoiceApi(HttpClientWrapper http) {
        super(http);
    }

    public InvoiceResponse create(CreateInvoiceRequest request) {
        return http.post(BASE_PATH, request, InvoiceResponse.class);
    }

    public InvoiceResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, InvoiceResponse.class);
    }

    public PageResponse<InvoiceResponse> list(UUID companyId, PageRequest page) {
        String path = withPagination(BASE_PATH + "?companyId=" + companyId, page);
        return http.get(path, new TypeReference<>() {});
    }

    public InvoiceResponse update(UUID id, UpdateInvoiceRequest request) {
        return http.put(BASE_PATH + "/" + id, request, InvoiceResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }

    public InvoiceResponse finalize(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/finalize", InvoiceResponse.class);
    }

    public InvoiceResponse send(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/send", InvoiceResponse.class);
    }

    public InvoiceResponse markAsPaid(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/mark-as-paid", InvoiceResponse.class);
    }

    public InvoiceResponse cancel(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/cancel", InvoiceResponse.class);
    }

    public byte[] downloadPdf(UUID id) {
        return http.getBytes(BASE_PATH + "/" + id + "/pdf");
    }

    // Recurring invoices
    public RecurringInvoiceResponse createRecurring(CreateRecurringInvoiceRequest request) {
        return http.post(BASE_PATH + "/recurring", request, RecurringInvoiceResponse.class);
    }

    public PageResponse<RecurringInvoiceResponse> listRecurring(UUID companyId, PageRequest page) {
        String path = withPagination(BASE_PATH + "/recurring?companyId=" + companyId, page);
        return http.get(path, new TypeReference<>() {});
    }

    public RecurringInvoiceResponse updateRecurring(UUID id, UpdateRecurringInvoiceRequest request) {
        return http.put(BASE_PATH + "/recurring/" + id, request, RecurringInvoiceResponse.class);
    }

    public void deleteRecurring(UUID id) {
        http.delete(BASE_PATH + "/recurring/" + id);
    }

    public RecurringInvoiceResponse activateRecurring(UUID id) {
        return http.postEmpty(BASE_PATH + "/recurring/" + id + "/activate", RecurringInvoiceResponse.class);
    }

    public RecurringInvoiceResponse deactivateRecurring(UUID id) {
        return http.postEmpty(BASE_PATH + "/recurring/" + id + "/deactivate", RecurringInvoiceResponse.class);
    }
}
