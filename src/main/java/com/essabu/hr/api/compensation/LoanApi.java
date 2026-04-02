package com.essabu.hr.api.compensation;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.BaseApi;
import com.essabu.hr.model.compensation.request.CreateLoanRequest;
import com.essabu.hr.model.compensation.request.CreateRepaymentRequest;
import com.essabu.hr.model.compensation.response.EmployeeLoanResponse;
import com.essabu.hr.model.compensation.response.LoanRepaymentResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * API client for managing loan resources in the Essabu HR module.
 *
 * Provides typed methods to interact with the loan REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - listByEmployee: list by employee operation
 * - approve: approve operation
 * - addRepayment: add repayment operation
 *
 * Base path: /api/hr/loans
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class LoanApi extends BaseApi {

    private static final String BASE_PATH = "/api/hr/loans";

    public LoanApi(HttpClientWrapper http) {
        super(http);
    }

    public EmployeeLoanResponse create(CreateLoanRequest request) {
        return http.post(BASE_PATH, request, EmployeeLoanResponse.class);
    }

    public List<EmployeeLoanResponse> listByEmployee(UUID employeeId) {
        return http.get(BASE_PATH + "?employeeId=" + employeeId,
                new TypeReference<>() {});
    }

    public EmployeeLoanResponse approve(UUID id, UUID approvedBy) {
        return http.put(BASE_PATH + "/" + id + "/approve",
                Map.of("approvedBy", approvedBy.toString()),
                EmployeeLoanResponse.class);
    }

    public List<LoanRepaymentResponse> getRepayments(UUID loanId) {
        return http.get(BASE_PATH + "/" + loanId + "/repayments",
                new TypeReference<>() {});
    }

    public LoanRepaymentResponse addRepayment(UUID loanId, CreateRepaymentRequest request) {
        return http.post(BASE_PATH + "/" + loanId + "/repayments",
                request, LoanRepaymentResponse.class);
    }
}
