package com.essabu.accounting;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for usage-based billing operations.
 * Endpoint bases: /api/accounting/usage-billing-configs, /api/accounting/usage-meters, /api/accounting/usage-records, /api/accounting/usage-billing
 */
public final class BillingApi extends BaseApi {

    private static final String CONFIGS = "/api/accounting/usage-billing-configs";
    private static final String METERS = "/api/accounting/usage-meters";
    private static final String RECORDS = "/api/accounting/usage-records";
    private static final String BILLING = "/api/accounting/usage-billing";

    public BillingApi(HttpClientWrapper http) {
        super(http);
    }

    // -- Billing Configs --
    public PageResponse<Map> listConfigs(PageRequest pageRequest) {
        return http.get(withPagination(CONFIGS, pageRequest), pageType(Map.class));
    }
    public Map getConfigById(UUID id) { return http.get(CONFIGS + "/" + id, Map.class); }
    public Map createConfig(Map<String, Object> request) { return http.post(CONFIGS, request, Map.class); }
    public Map updateConfig(UUID id, Map<String, Object> request) { return http.put(CONFIGS + "/" + id, request, Map.class); }

    // -- Usage Meters --
    public PageResponse<Map> listMeters(PageRequest pageRequest) {
        return http.get(withPagination(METERS, pageRequest), pageType(Map.class));
    }
    public Map getMeterById(UUID id) { return http.get(METERS + "/" + id, Map.class); }
    public Map createMeter(Map<String, Object> request) { return http.post(METERS, request, Map.class); }

    // -- Usage Records --
    public PageResponse<Map> listRecords(PageRequest pageRequest) {
        return http.get(withPagination(RECORDS, pageRequest), pageType(Map.class));
    }
    public Map createRecord(Map<String, Object> request) { return http.post(RECORDS, request, Map.class); }

    // -- Generate Bill --
    public Map generateBill(Map<String, Object> request) {
        return http.post(BILLING + "/generate", request, Map.class);
    }
}
