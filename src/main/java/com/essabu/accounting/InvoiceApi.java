package com.essabu.accounting;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for invoice operations (invoices, branding, payment links, dunning).
 * Endpoint base: /api/accounting/invoices
 */
public final class InvoiceApi extends BaseApi {

    private static final String BASE = "/api/accounting/invoices";
    private static final String BRANDING = "/api/accounting/invoice-branding";
    private static final String LOCALES = "/api/accounting/invoice-locales";

    public InvoiceApi(HttpClientWrapper http) {
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

    public Map finalize(UUID id) {
        return http.post(BASE + "/" + id + "/finalize", null, Map.class);
    }

    public byte[] downloadPdf(UUID id) {
        return http.getBytes(BASE + "/" + id + "/pdf");
    }

    public Map sendByEmail(UUID id, Map<String, Object> request) {
        return http.post(BASE + "/" + id + "/send", request, Map.class);
    }

    public Map applyCoupon(UUID id, Map<String, Object> request) {
        return http.post(BASE + "/" + id + "/apply-coupon", request, Map.class);
    }

    public Map getPaymentLink(UUID id) {
        return http.get(BASE + "/" + id + "/payment-link", Map.class);
    }

    // -- Branding --

    public PageResponse<Map> listBrandings(PageRequest pageRequest) {
        return http.get(withPagination(BRANDING, pageRequest), pageType(Map.class));
    }

    public Map createBranding(Map<String, Object> request) {
        return http.post(BRANDING, request, Map.class);
    }

    public Map updateBranding(UUID id, Map<String, Object> request) {
        return http.put(BRANDING + "/" + id, request, Map.class);
    }

    // -- Locales --

    public PageResponse<Map> listLocales(PageRequest pageRequest) {
        return http.get(withPagination(LOCALES, pageRequest), pageType(Map.class));
    }

    public Map createLocale(Map<String, Object> request) {
        return http.post(LOCALES, request, Map.class);
    }
}
