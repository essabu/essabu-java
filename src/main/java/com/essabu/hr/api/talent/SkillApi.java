package com.essabu.hr.api.talent;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.BaseApi;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.hr.model.talent.request.CreateEmployeeSkillRequest;
import com.essabu.hr.model.talent.request.CreateSkillRequest;
import com.essabu.hr.model.talent.response.EmployeeSkillResponse;
import com.essabu.hr.model.talent.response.GapAnalysisResponse;
import com.essabu.hr.model.talent.response.SkillMatrixResponse;
import com.essabu.hr.model.talent.response.SkillResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing skill resources in the Essabu HR module.
 *
 * Provides typed methods to interact with the skill REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - list: list operation
 * - addToEmployee: add to employee operation
 * - listByEmployee: list by employee operation
 * - gapAnalysis: gap analysis operation
 * - matrix: matrix operation
 *
 * Base path: /api/hr/skills
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class SkillApi extends BaseApi {

    private static final String BASE_PATH = "/api/hr/skills";

    public SkillApi(HttpClientWrapper http) {
        super(http);
    }

    public SkillResponse create(CreateSkillRequest request) {
        return http.post(BASE_PATH, request, SkillResponse.class);
    }

    public PageResponse<SkillResponse> list(PageRequest page) {
        return http.get(withPagination(BASE_PATH, page),
                new TypeReference<PageResponse<SkillResponse>>() {});
    }

    public EmployeeSkillResponse addToEmployee(CreateEmployeeSkillRequest request) {
        return http.post("/api/hr/employee-skills", request, EmployeeSkillResponse.class);
    }

    public List<EmployeeSkillResponse> listByEmployee(UUID employeeId) {
        return http.get("/api/hr/employee-skills?employeeId=" + employeeId,
                new TypeReference<>() {});
    }

    public GapAnalysisResponse gapAnalysis(UUID positionId, UUID employeeId) {
        return http.get(BASE_PATH + "/gap-analysis?positionId=" + positionId + "&employeeId=" + employeeId,
                GapAnalysisResponse.class);
    }

    public SkillMatrixResponse matrix(UUID departmentId) {
        return http.get(BASE_PATH + "/matrix?departmentId=" + departmentId,
                SkillMatrixResponse.class);
    }
}
