package com.essabu.project;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;

import java.util.Map;

/**
 * API client for project report operations.
 * Endpoint base: /api/project/reports
 */
public final class ReportApi extends BaseApi {

    private static final String BASE = "/api/project/reports";

    public ReportApi(HttpClientWrapper http) {
        super(http);
    }

    public Map getProjectSummary(Map<String, Object> params) {
        return http.get(withParams(BASE + "/summary", params), Map.class);
    }

    public Map getResourceUtilization(Map<String, Object> params) {
        return http.get(withParams(BASE + "/resource-utilization", params), Map.class);
    }
}
