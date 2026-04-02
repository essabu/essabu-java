package com.essabu.hr.api.compensation;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.BaseApi;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.hr.model.compensation.request.CreateBenefitPlanRequest;
import com.essabu.hr.model.compensation.request.CreateEmployeeBenefitRequest;
import com.essabu.hr.model.compensation.response.BenefitPlanResponse;
import com.essabu.hr.model.compensation.response.EmployeeBenefitResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing benefit resources in the Essabu HR module.
 *
 * Provides typed methods to interact with the benefit REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - createPlan: create plan operation
 * - listPlans: list plans operation
 * - enroll: enroll operation
 * - listByEmployee: list by employee operation
 * - terminate: terminate operation
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class BenefitApi extends BaseApi {

    private static final String PLANS_PATH = "/api/hr/benefit-plans";
    private static final String BENEFITS_PATH = "/api/hr/employee-benefits";

    public BenefitApi(HttpClientWrapper http) {
        super(http);
    }

    // --- Plans ---

    public BenefitPlanResponse createPlan(CreateBenefitPlanRequest request) {
        return http.post(PLANS_PATH, request, BenefitPlanResponse.class);
    }

    public PageResponse<BenefitPlanResponse> listPlans(PageRequest page) {
        return http.get(withPagination(PLANS_PATH, page),
                new TypeReference<PageResponse<BenefitPlanResponse>>() {});
    }

    // --- Employee Benefits ---

    public EmployeeBenefitResponse enroll(CreateEmployeeBenefitRequest request) {
        return http.post(BENEFITS_PATH, request, EmployeeBenefitResponse.class);
    }

    public List<EmployeeBenefitResponse> listByEmployee(UUID employeeId) {
        return http.get(BENEFITS_PATH + "?employeeId=" + employeeId,
                new TypeReference<>() {});
    }

    public EmployeeBenefitResponse terminate(UUID id) {
        return http.put(BENEFITS_PATH + "/" + id + "/terminate", null,
                EmployeeBenefitResponse.class);
    }
}
