package com.essabu.accounting;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;

import java.util.Map;

/**
 * API client for accounting report operations.
 * Endpoint base: /api/accounting/reports
 */
public final class ReportApi extends BaseApi {

    private static final String BASE = "/api/accounting/reports";

    public ReportApi(HttpClientWrapper http) {
        super(http);
    }

    public Map getTrialBalance(Map<String, Object> params) {
        return http.get(withParams(BASE + "/trial-balance", params), Map.class);
    }

    public Map getBalanceSheet(Map<String, Object> params) {
        return http.get(withParams(BASE + "/balance-sheet", params), Map.class);
    }

    public Map getIncomeStatement(Map<String, Object> params) {
        return http.get(withParams(BASE + "/income-statement", params), Map.class);
    }

    public Map getCashFlow(Map<String, Object> params) {
        return http.get(withParams(BASE + "/cash-flow", params), Map.class);
    }

    public Map getGeneralLedger(Map<String, Object> params) {
        return http.get(withParams(BASE + "/general-ledger", params), Map.class);
    }

    public Map getAgedReceivables(Map<String, Object> params) {
        return http.get(withParams(BASE + "/aged-receivables", params), Map.class);
    }

    public Map getAgedPayables(Map<String, Object> params) {
        return http.get(withParams(BASE + "/aged-payables", params), Map.class);
    }
}
