package com.essabu.trade;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for customer and customer group operations.
 * Endpoint bases: /api/trade/customers, /api/trade/customer-groups
 */
public final class CustomerApi extends BaseApi {

    private static final String CUSTOMERS = "/api/trade/customers";
    private static final String GROUPS = "/api/trade/customer-groups";

    public CustomerApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(CUSTOMERS, pageRequest), pageType(Map.class));
    }

    public Map getById(UUID id) {
        return http.get(CUSTOMERS + "/" + id, Map.class);
    }

    public Map create(Map<String, Object> request) {
        return http.post(CUSTOMERS, request, Map.class);
    }

    public Map update(UUID id, Map<String, Object> request) {
        return http.put(CUSTOMERS + "/" + id, request, Map.class);
    }

    public void delete(UUID id) {
        http.delete(CUSTOMERS + "/" + id);
    }

    // -- Customer Groups --

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
