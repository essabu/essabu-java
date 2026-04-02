package com.essabu.hr;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for HR skill and employee-skill operations.
 * Endpoint bases: /api/hr/skills, /api/hr/employee-skills
 */
public final class SkillApi extends BaseApi {

    private static final String SKILLS = "/api/hr/skills";
    private static final String EMPLOYEE_SKILLS = "/api/hr/employee-skills";

    public SkillApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(SKILLS, pageRequest), pageType(Map.class));
    }

    public Map getById(UUID id) {
        return http.get(SKILLS + "/" + id, Map.class);
    }

    public Map create(Map<String, Object> request) {
        return http.post(SKILLS, request, Map.class);
    }

    public Map update(UUID id, Map<String, Object> request) {
        return http.put(SKILLS + "/" + id, request, Map.class);
    }

    public void delete(UUID id) {
        http.delete(SKILLS + "/" + id);
    }

    // -- Employee Skills --

    public PageResponse<Map> listEmployeeSkills(PageRequest pageRequest) {
        return http.get(withPagination(EMPLOYEE_SKILLS, pageRequest), pageType(Map.class));
    }

    public Map assignSkill(Map<String, Object> request) {
        return http.post(EMPLOYEE_SKILLS, request, Map.class);
    }

    public void removeEmployeeSkill(UUID id) {
        http.delete(EMPLOYEE_SKILLS + "/" + id);
    }
}
