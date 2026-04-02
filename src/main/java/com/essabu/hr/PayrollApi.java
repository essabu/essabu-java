package com.essabu.hr;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for HR payroll operations.
 * Endpoint base: /api/hr/payroll-runs, /api/hr/payslips
 */
public final class PayrollApi extends BaseApi {

    private static final String RUNS_BASE = "/api/hr/payroll-runs";
    private static final String PAYSLIPS_BASE = "/api/hr/payslips";

    public PayrollApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> listRuns(PageRequest pageRequest) {
        return http.get(withPagination(RUNS_BASE, pageRequest), pageType(Map.class));
    }

    public Map getRunById(UUID id) {
        return http.get(RUNS_BASE + "/" + id, Map.class);
    }

    public Map createRun(Map<String, Object> request) {
        return http.post(RUNS_BASE, request, Map.class);
    }

    public Map approveRun(UUID id) {
        return http.post(RUNS_BASE + "/" + id + "/approve", null, Map.class);
    }

    public PageResponse<Map> listPayslips(UUID payrollRunId, PageRequest pageRequest) {
        String path = withParam(PAYSLIPS_BASE, "payrollRunId", payrollRunId);
        return http.get(withPagination(path, pageRequest), pageType(Map.class));
    }

    public Map getPayslipById(UUID id) {
        return http.get(PAYSLIPS_BASE + "/" + id, Map.class);
    }

    public byte[] downloadPayslip(UUID id) {
        return http.getBytes(PAYSLIPS_BASE + "/" + id + "/download");
    }
}
