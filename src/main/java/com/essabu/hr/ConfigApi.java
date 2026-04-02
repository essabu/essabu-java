package com.essabu.hr;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for HR configuration (tenant config, leave policies, holidays, approval workflows).
 * Endpoint bases: /api/hr/config, /api/hr/config/leave-policies, /api/hr/config/holidays, /api/hr/config/approval-workflows
 */
public final class ConfigApi extends BaseApi {

    private static final String CONFIG = "/api/hr/config";
    private static final String LEAVE_POLICIES = "/api/hr/config/leave-policies";
    private static final String HOLIDAYS = "/api/hr/config/holidays";
    private static final String APPROVAL_WORKFLOWS = "/api/hr/config/approval-workflows";

    public ConfigApi(HttpClientWrapper http) {
        super(http);
    }

    // -- Tenant Config --

    public Map getConfig() {
        return http.get(CONFIG, Map.class);
    }

    public Map updateConfig(Map<String, Object> request) {
        return http.put(CONFIG, request, Map.class);
    }

    // -- Leave Policies --

    public PageResponse<Map> listLeavePolicies(PageRequest pageRequest) {
        return http.get(withPagination(LEAVE_POLICIES, pageRequest), pageType(Map.class));
    }

    public Map getLeavePolicyById(UUID id) {
        return http.get(LEAVE_POLICIES + "/" + id, Map.class);
    }

    public Map createLeavePolicy(Map<String, Object> request) {
        return http.post(LEAVE_POLICIES, request, Map.class);
    }

    public Map updateLeavePolicy(UUID id, Map<String, Object> request) {
        return http.put(LEAVE_POLICIES + "/" + id, request, Map.class);
    }

    public void deleteLeavePolicy(UUID id) {
        http.delete(LEAVE_POLICIES + "/" + id);
    }

    // -- Public Holidays --

    public PageResponse<Map> listHolidays(PageRequest pageRequest) {
        return http.get(withPagination(HOLIDAYS, pageRequest), pageType(Map.class));
    }

    public Map getHolidayById(UUID id) {
        return http.get(HOLIDAYS + "/" + id, Map.class);
    }

    public Map createHoliday(Map<String, Object> request) {
        return http.post(HOLIDAYS, request, Map.class);
    }

    public Map updateHoliday(UUID id, Map<String, Object> request) {
        return http.put(HOLIDAYS + "/" + id, request, Map.class);
    }

    public void deleteHoliday(UUID id) {
        http.delete(HOLIDAYS + "/" + id);
    }

    // -- Approval Workflows --

    public PageResponse<Map> listApprovalWorkflows(PageRequest pageRequest) {
        return http.get(withPagination(APPROVAL_WORKFLOWS, pageRequest), pageType(Map.class));
    }

    public Map getApprovalWorkflowById(UUID id) {
        return http.get(APPROVAL_WORKFLOWS + "/" + id, Map.class);
    }

    public Map createApprovalWorkflow(Map<String, Object> request) {
        return http.post(APPROVAL_WORKFLOWS, request, Map.class);
    }

    public Map updateApprovalWorkflow(UUID id, Map<String, Object> request) {
        return http.put(APPROVAL_WORKFLOWS + "/" + id, request, Map.class);
    }

    public void deleteApprovalWorkflow(UUID id) {
        http.delete(APPROVAL_WORKFLOWS + "/" + id);
    }
}
