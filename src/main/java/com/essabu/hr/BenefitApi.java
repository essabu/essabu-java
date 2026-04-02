package com.essabu.hr;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for HR benefit operations (plans and employee benefits).
 * Endpoint bases: /api/hr/benefit-plans, /api/hr/employee-benefits
 */
public final class BenefitApi extends BaseApi {

    private static final String PLANS = "/api/hr/benefit-plans";
    private static final String EMPLOYEE_BENEFITS = "/api/hr/employee-benefits";

    public BenefitApi(HttpClientWrapper http) {
        super(http);
    }

    // -- Benefit Plans --

    public PageResponse<Map> listPlans(PageRequest pageRequest) {
        return http.get(withPagination(PLANS, pageRequest), pageType(Map.class));
    }

    public Map getPlanById(UUID id) {
        return http.get(PLANS + "/" + id, Map.class);
    }

    public Map createPlan(Map<String, Object> request) {
        return http.post(PLANS, request, Map.class);
    }

    public Map updatePlan(UUID id, Map<String, Object> request) {
        return http.put(PLANS + "/" + id, request, Map.class);
    }

    public void deletePlan(UUID id) {
        http.delete(PLANS + "/" + id);
    }

    // -- Employee Benefits --

    public PageResponse<Map> listEmployeeBenefits(PageRequest pageRequest) {
        return http.get(withPagination(EMPLOYEE_BENEFITS, pageRequest), pageType(Map.class));
    }

    public Map getEmployeeBenefitById(UUID id) {
        return http.get(EMPLOYEE_BENEFITS + "/" + id, Map.class);
    }

    public Map enrollEmployee(Map<String, Object> request) {
        return http.post(EMPLOYEE_BENEFITS, request, Map.class);
    }

    public Map updateEmployeeBenefit(UUID id, Map<String, Object> request) {
        return http.put(EMPLOYEE_BENEFITS + "/" + id, request, Map.class);
    }

    public void removeEmployeeBenefit(UUID id) {
        http.delete(EMPLOYEE_BENEFITS + "/" + id);
    }
}
