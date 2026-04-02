package com.essabu.accounting;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for quote operations.
 * Endpoint base: /api/accounting/quotes
 */
public final class QuoteApi extends BaseApi {

    private static final String BASE = "/api/accounting/quotes";

    public QuoteApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(BASE, pageRequest), pageType(Map.class));
    }

    public Map getById(UUID id) {
        return http.get(BASE + "/" + id, Map.class);
    }

    public Map create(Map<String, Object> request) {
        return http.post(BASE, request, Map.class);
    }

    public Map update(UUID id, Map<String, Object> request) {
        return http.put(BASE + "/" + id, request, Map.class);
    }

    public void delete(UUID id) {
        http.delete(BASE + "/" + id);
    }

    public Map convertToInvoice(UUID id) {
        return http.post(BASE + "/" + id + "/convert-to-invoice", null, Map.class);
    }

    public byte[] downloadPdf(UUID id) {
        return http.getBytes(BASE + "/" + id + "/pdf");
    }
}
