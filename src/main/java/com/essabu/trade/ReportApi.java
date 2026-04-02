package com.essabu.trade;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;

import java.util.Map;

/**
 * API client for CRM pipeline report operations.
 * Endpoint base: /api/crm/reports
 */
public final class ReportApi extends BaseApi {

    private static final String BASE = "/api/crm/reports";

    public ReportApi(HttpClientWrapper http) {
        super(http);
    }

    public Map getPipelineReport(Map<String, Object> params) {
        return http.get(withParams(BASE + "/pipeline", params), Map.class);
    }

    public Map getSalesReport(Map<String, Object> params) {
        return http.get(withParams(BASE + "/sales", params), Map.class);
    }
}
