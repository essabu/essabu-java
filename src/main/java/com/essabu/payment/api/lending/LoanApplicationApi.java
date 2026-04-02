package com.essabu.payment.api.lending;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.payment.model.lending.request.ApproveLoanRequest;
import com.essabu.payment.model.lending.request.CreateLoanApplicationRequest;
import com.essabu.payment.model.lending.request.RepayLoanRequest;
import com.essabu.payment.model.lending.request.UpdateLoanApplicationRequest;
import com.essabu.payment.model.lending.response.LoanApplicationResponse;
import com.essabu.payment.model.lending.response.LoanRepaymentResponse;
import com.essabu.payment.model.lending.response.LoanScheduleResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing loan application resources in the Essabu Payment module.
 *
 * Provides typed methods to interact with the loan application REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - update: update operation
 * - submit: submit operation
 * - approve: approve operation
 * - reject: reject operation
 * - disburse: disburse operation
 * - repay: repay operation
 *
 * Base path: /api/lending/loan-applications
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class LoanApplicationApi extends BaseApi {

    private static final String BASE_PATH = "/api/lending/loan-applications";

    public LoanApplicationApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Creates a new loan application.
     */
    public LoanApplicationResponse create(CreateLoanApplicationRequest request) {
        return http.post(BASE_PATH, request, LoanApplicationResponse.class);
    }

    /**
     * Retrieves a loan application by its identifier.
     */
    public LoanApplicationResponse getById(UUID id) {
        return http.get(BASE_PATH + "/" + id, LoanApplicationResponse.class);
    }

    /**
     * Lists the loan applications of a company.
     */
    public PageResponse<LoanApplicationResponse> getByCompany(UUID companyId, PageRequest page) {
        String path = withParam(BASE_PATH, "companyId", companyId);
        path = withPagination(path, page);
        return http.get(path, new TypeReference<>() {});
    }

    /**
     * Updates a loan application (draft).
     */
    public LoanApplicationResponse update(UUID id, UpdateLoanApplicationRequest request) {
        return http.put(BASE_PATH + "/" + id, request, LoanApplicationResponse.class);
    }

    /**
     * Submits a loan application.
     */
    public LoanApplicationResponse submit(UUID id) {
        return http.post(BASE_PATH + "/" + id + "/submit", null, LoanApplicationResponse.class);
    }

    /**
     * Approves a loan application.
     */
    public LoanApplicationResponse approve(UUID id, ApproveLoanRequest request) {
        return http.post(BASE_PATH + "/" + id + "/approve", request, LoanApplicationResponse.class);
    }

    /**
     * Rejects a loan application.
     */
    public LoanApplicationResponse reject(UUID id) {
        return http.post(BASE_PATH + "/" + id + "/reject", null, LoanApplicationResponse.class);
    }

    /**
     * Disburses an approved loan.
     */
    public LoanApplicationResponse disburse(UUID id) {
        return http.post(BASE_PATH + "/" + id + "/disburse", null, LoanApplicationResponse.class);
    }

    /**
     * Records a repayment on a loan.
     */
    public LoanRepaymentResponse repay(UUID id, RepayLoanRequest request) {
        return http.post(BASE_PATH + "/" + id + "/repay", request, LoanRepaymentResponse.class);
    }

    /**
     * Retrieves the repayment schedule of a loan.
     */
    public List<LoanScheduleResponse> getSchedule(UUID id) {
        return http.get(BASE_PATH + "/" + id + "/schedule", new TypeReference<>() {});
    }
}
