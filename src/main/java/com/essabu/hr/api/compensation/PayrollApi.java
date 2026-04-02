package com.essabu.hr.api.compensation;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.BaseApi;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.hr.model.compensation.request.CreatePayrollRequest;
import com.essabu.hr.model.compensation.response.PaySlipResponse;
import com.essabu.hr.model.compensation.response.PayrollResponse;
import com.essabu.hr.model.compensation.response.PayrollYtdResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * API client for managing payroll resources in the Essabu HR module.
 *
 * Provides typed methods to interact with the payroll REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - list: list operation
 * - calculate: calculate operation
 * - approve: approve operation
 *
 * Base path: /api/hr/payrolls
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class PayrollApi extends BaseApi {

    private static final String BASE_PATH = "/api/hr/payrolls";

    public PayrollApi(HttpClientWrapper http) {
        super(http);
    }

    public PayrollResponse create(CreatePayrollRequest request) {
        return http.post(BASE_PATH, request, PayrollResponse.class);
    }

    public PayrollResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, PayrollResponse.class);
    }

    public PageResponse<PayrollResponse> list(PageRequest page) {
        return http.get(withPagination(BASE_PATH, page),
                new TypeReference<PageResponse<PayrollResponse>>() {});
    }

    public PayrollResponse calculate(UUID id) {
        return http.put(BASE_PATH + "/" + id + "/calculate", null, PayrollResponse.class);
    }

    public PayrollResponse approve(UUID id, UUID approvedBy) {
        return http.put(BASE_PATH + "/" + id + "/approve",
                Map.of("approvedBy", approvedBy),
                PayrollResponse.class);
    }

    public byte[] downloadPdf(UUID id) {
        return http.getBytes(BASE_PATH + "/" + id + "/pdf");
    }

    public List<PaySlipResponse> getPayslips(UUID payrollId) {
        return http.get(BASE_PATH + "/" + payrollId + "/payslips",
                new TypeReference<>() {});
    }

    public byte[] downloadPayslipPdf(UUID payrollId, UUID employeeId) {
        return http.getBytes(BASE_PATH + "/" + payrollId + "/payslips/" + employeeId + "/pdf");
    }

    public PayrollYtdResponse getYearToDate(UUID employeeId, int year) {
        String path = withParam("/api/hr/payroll-ytd", "employeeId", employeeId);
        path = withParam(path, "year", year);
        return http.get(path, PayrollYtdResponse.class);
    }
}
