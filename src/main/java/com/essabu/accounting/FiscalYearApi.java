package com.essabu.accounting;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for fiscal year and accounting period operations.
 * Endpoint bases: /api/accounting/fiscal-years, /api/accounting/periods
 */
public final class FiscalYearApi extends BaseApi {

    private static final String FISCAL_YEARS = "/api/accounting/fiscal-years";
    private static final String PERIODS = "/api/accounting/periods";

    public FiscalYearApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(FISCAL_YEARS, pageRequest), pageType(Map.class));
    }

    public Map getById(UUID id) {
        return http.get(FISCAL_YEARS + "/" + id, Map.class);
    }

    public Map create(Map<String, Object> request) {
        return http.post(FISCAL_YEARS, request, Map.class);
    }

    public Map update(UUID id, Map<String, Object> request) {
        return http.put(FISCAL_YEARS + "/" + id, request, Map.class);
    }

    public void delete(UUID id) {
        http.delete(FISCAL_YEARS + "/" + id);
    }

    // -- Accounting Periods --

    public PageResponse<Map> listPeriods(PageRequest pageRequest) {
        return http.get(withPagination(PERIODS, pageRequest), pageType(Map.class));
    }

    public Map getPeriodById(UUID id) {
        return http.get(PERIODS + "/" + id, Map.class);
    }

    public Map createPeriod(Map<String, Object> request) {
        return http.post(PERIODS, request, Map.class);
    }

    public Map closePeriod(UUID id) {
        return http.post(PERIODS + "/" + id + "/close", null, Map.class);
    }
}
