package com.essabu.hr.api.admin;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.BaseApi;
import com.essabu.hr.model.admin.request.CreateHolidayRequest;
import com.essabu.hr.model.admin.request.UpdateLeavePolicyRequest;
import com.essabu.hr.model.admin.request.UpdateTenantConfigRequest;
import com.essabu.hr.model.admin.response.LeavePolicyResponse;
import com.essabu.hr.model.admin.response.PayrollRuleResponse;
import com.essabu.hr.model.admin.response.PublicHolidayResponse;
import com.essabu.hr.model.admin.response.TenantConfigResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing config resources in the Essabu HR module.
 *
 * Provides typed methods to interact with the config REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - updateConfig: update config operation
 * - updateLeavePolicy: update leave policy operation
 * - addHoliday: add holiday operation
 *
 * Base path: /api/hr/config
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class ConfigApi extends BaseApi {

    private static final String BASE_PATH = "/api/hr/config";

    public ConfigApi(HttpClientWrapper http) {
        super(http);
    }

    public TenantConfigResponse getConfig() {
        return http.get(BASE_PATH, TenantConfigResponse.class);
    }

    public TenantConfigResponse updateConfig(UpdateTenantConfigRequest request) {
        return http.put(BASE_PATH, request, TenantConfigResponse.class);
    }

    public List<LeavePolicyResponse> getLeavePolicies() {
        return http.get(BASE_PATH + "/leave-policies",
                new TypeReference<>() {});
    }

    public LeavePolicyResponse updateLeavePolicy(UUID id, UpdateLeavePolicyRequest request) {
        return http.put(BASE_PATH + "/leave-policies/" + id, request, LeavePolicyResponse.class);
    }

    public List<PayrollRuleResponse> getPayrollRules() {
        return http.get(BASE_PATH + "/payroll-rules",
                new TypeReference<>() {});
    }

    public List<PublicHolidayResponse> getHolidays() {
        return http.get(BASE_PATH + "/holidays",
                new TypeReference<>() {});
    }

    public PublicHolidayResponse addHoliday(CreateHolidayRequest request) {
        return http.post(BASE_PATH + "/holidays", request, PublicHolidayResponse.class);
    }
}
