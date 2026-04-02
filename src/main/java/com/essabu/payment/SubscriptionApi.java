package com.essabu.payment;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for subscription, billing cycle, usage, and SaaS invoice operations.
 * Endpoint bases: /api/payment/subscriptions, /api/payment/billing-cycles, /api/payment/usage, /api/payment/invoices
 */
public final class SubscriptionApi extends BaseApi {

    private static final String SUBS = "/api/payment/subscriptions";
    private static final String CYCLES = "/api/payment/billing-cycles";
    private static final String USAGE = "/api/payment/usage";
    private static final String INVOICES = "/api/payment/invoices";

    public SubscriptionApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(SUBS, pageRequest), pageType(Map.class));
    }

    public Map getById(UUID id) { return http.get(SUBS + "/" + id, Map.class); }
    public Map create(Map<String, Object> request) { return http.post(SUBS, request, Map.class); }
    public Map update(UUID id, Map<String, Object> request) { return http.put(SUBS + "/" + id, request, Map.class); }
    public Map cancel(UUID id) { return http.post(SUBS + "/" + id + "/cancel", null, Map.class); }

    // -- Billing Cycles --
    public PageResponse<Map> listBillingCycles(PageRequest pageRequest) {
        return http.get(withPagination(CYCLES, pageRequest), pageType(Map.class));
    }

    // -- Usage --
    public Map reportUsage(Map<String, Object> request) { return http.post(USAGE, request, Map.class); }
    public Map getUsageSummary(UUID subscriptionId) { return http.get(USAGE + "/summary?subscriptionId=" + subscriptionId, Map.class); }

    // -- SaaS Invoices --
    public PageResponse<Map> listInvoices(PageRequest pageRequest) {
        return http.get(withPagination(INVOICES, pageRequest), pageType(Map.class));
    }
    public Map getInvoiceById(UUID id) { return http.get(INVOICES + "/" + id, Map.class); }
}
