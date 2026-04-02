package com.essabu.identity;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for company and company group operations.
 * Endpoint bases: /api/identity/companies, /api/identity/company-groups
 */
public final class CompanyApi extends BaseApi {

    private static final String COMPANIES = "/api/identity/companies";
    private static final String GROUPS = "/api/identity/company-groups";

    public CompanyApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(COMPANIES, pageRequest), pageType(Map.class));
    }

    public Map getById(UUID id) {
        return http.get(COMPANIES + "/" + id, Map.class);
    }

    public Map create(Map<String, Object> request) {
        return http.post(COMPANIES, request, Map.class);
    }

    public Map update(UUID id, Map<String, Object> request) {
        return http.put(COMPANIES + "/" + id, request, Map.class);
    }

    public void delete(UUID id) {
        http.delete(COMPANIES + "/" + id);
    }

    // -- Company Groups --

    public PageResponse<Map> listGroups(PageRequest pageRequest) {
        return http.get(withPagination(GROUPS, pageRequest), pageType(Map.class));
    }

    public Map getGroupById(UUID id) {
        return http.get(GROUPS + "/" + id, Map.class);
    }

    public Map createGroup(Map<String, Object> request) {
        return http.post(GROUPS, request, Map.class);
    }

    public Map updateGroup(UUID id, Map<String, Object> request) {
        return http.put(GROUPS + "/" + id, request, Map.class);
    }

    public void deleteGroup(UUID id) {
        http.delete(GROUPS + "/" + id);
    }
}
