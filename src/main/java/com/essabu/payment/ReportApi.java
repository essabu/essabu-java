package com.essabu.payment;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;

import java.util.Map;

/**
 * API client for lending report operations.
 * Endpoint base: /api/lending/reports
 */
public final class ReportApi extends BaseApi {

    private static final String BASE = "/api/lending/reports";

    public ReportApi(HttpClientWrapper http) {
        super(http);
    }

    public Map getLoanPortfolio(Map<String, Object> params) {
        return http.get(withParams(BASE + "/portfolio", params), Map.class);
    }

    public Map getDelinquencyReport(Map<String, Object> params) {
        return http.get(withParams(BASE + "/delinquency", params), Map.class);
    }
}
