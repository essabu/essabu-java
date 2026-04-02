package com.essabu.einvoice;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for e-invoice operations (submit, list, get, cancel).
 * Endpoint base: /api/einvoice
 */
public final class EInvoiceApi extends BaseApi {

    private static final String BASE = "/api/einvoice";

    public EInvoiceApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(BASE + "/invoices", pageRequest), pageType(Map.class));
    }

    public Map getById(UUID id) {
        return http.get(BASE + "/invoices/" + id, Map.class);
    }

    public Map submit(Map<String, Object> request) {
        return http.post(BASE + "/invoices", request, Map.class);
    }

    public Map cancel(UUID id) {
        return http.post(BASE + "/invoices/" + id + "/cancel", null, Map.class);
    }

    public Map getSubmissionStatus(UUID id) {
        return http.get(BASE + "/invoices/" + id + "/status", Map.class);
    }

    public byte[] downloadPdf(UUID id) {
        return http.getBytes(BASE + "/invoices/" + id + "/pdf");
    }

    public byte[] downloadXml(UUID id) {
        return http.getBytes(BASE + "/invoices/" + id + "/xml");
    }
}
