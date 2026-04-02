package com.essabu.hr;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for HR performance management (reviews, review cycles, goals).
 * Endpoint bases: /api/hr/performance-reviews, /api/hr/review-cycles, /api/hr/goals
 */
public final class PerformanceApi extends BaseApi {

    private static final String REVIEWS = "/api/hr/performance-reviews";
    private static final String CYCLES = "/api/hr/review-cycles";
    private static final String GOALS = "/api/hr/goals";

    public PerformanceApi(HttpClientWrapper http) {
        super(http);
    }

    // -- Performance Reviews --

    public PageResponse<Map> listReviews(PageRequest pageRequest) {
        return http.get(withPagination(REVIEWS, pageRequest), pageType(Map.class));
    }

    public Map getReviewById(UUID id) {
        return http.get(REVIEWS + "/" + id, Map.class);
    }

    public Map createReview(Map<String, Object> request) {
        return http.post(REVIEWS, request, Map.class);
    }

    public Map updateReview(UUID id, Map<String, Object> request) {
        return http.put(REVIEWS + "/" + id, request, Map.class);
    }

    public void deleteReview(UUID id) {
        http.delete(REVIEWS + "/" + id);
    }

    // -- Review Cycles --

    public PageResponse<Map> listCycles(PageRequest pageRequest) {
        return http.get(withPagination(CYCLES, pageRequest), pageType(Map.class));
    }

    public Map getCycleById(UUID id) {
        return http.get(CYCLES + "/" + id, Map.class);
    }

    public Map createCycle(Map<String, Object> request) {
        return http.post(CYCLES, request, Map.class);
    }

    public Map updateCycle(UUID id, Map<String, Object> request) {
        return http.put(CYCLES + "/" + id, request, Map.class);
    }

    public void deleteCycle(UUID id) {
        http.delete(CYCLES + "/" + id);
    }

    // -- Goals --

    public PageResponse<Map> listGoals(PageRequest pageRequest) {
        return http.get(withPagination(GOALS, pageRequest), pageType(Map.class));
    }

    public Map getGoalById(UUID id) {
        return http.get(GOALS + "/" + id, Map.class);
    }

    public Map createGoal(Map<String, Object> request) {
        return http.post(GOALS, request, Map.class);
    }

    public Map updateGoal(UUID id, Map<String, Object> request) {
        return http.put(GOALS + "/" + id, request, Map.class);
    }

    public void deleteGoal(UUID id) {
        http.delete(GOALS + "/" + id);
    }
}
