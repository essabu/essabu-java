package com.essabu.hr.api.talent;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.BaseApi;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.hr.model.talent.request.CreateGoalRequest;
import com.essabu.hr.model.talent.request.CreatePerformanceReviewRequest;
import com.essabu.hr.model.talent.request.CreateReviewCycleRequest;
import com.essabu.hr.model.talent.response.GoalResponse;
import com.essabu.hr.model.talent.response.PerformanceReviewResponse;
import com.essabu.hr.model.talent.response.ReviewCycleResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Map;
import java.util.UUID;

/**
 * API client for managing performance resources in the Essabu HR module.
 *
 * Provides typed methods to interact with the performance REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - createCycle: create cycle operation
 * - listCycles: list cycles operation
 * - createReview: create review operation
 * - submitReview: submit review operation
 * - acknowledgeReview: acknowledge review operation
 * - createGoal: create goal operation
 * - listGoals: list goals operation
 * - updateProgress: update progress operation
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class PerformanceApi extends BaseApi {

    private static final String CYCLES_PATH = "/api/hr/review-cycles";
    private static final String REVIEWS_PATH = "/api/hr/performance-reviews";
    private static final String GOALS_PATH = "/api/hr/goals";

    public PerformanceApi(HttpClientWrapper http) {
        super(http);
    }

    // --- Review Cycles ---

    public ReviewCycleResponse createCycle(CreateReviewCycleRequest request) {
        return http.post(CYCLES_PATH, request, ReviewCycleResponse.class);
    }

    public PageResponse<ReviewCycleResponse> listCycles(PageRequest page) {
        return http.get(withPagination(CYCLES_PATH, page),
                new TypeReference<PageResponse<ReviewCycleResponse>>() {});
    }

    // --- Reviews ---

    public PerformanceReviewResponse createReview(CreatePerformanceReviewRequest request) {
        return http.post(REVIEWS_PATH, request, PerformanceReviewResponse.class);
    }

    public PerformanceReviewResponse getReview(UUID id) {
        return http.get(REVIEWS_PATH + "/" + id, PerformanceReviewResponse.class);
    }

    public PerformanceReviewResponse submitReview(UUID id) {
        return http.put(REVIEWS_PATH + "/" + id + "/submit", null,
                PerformanceReviewResponse.class);
    }

    public PerformanceReviewResponse acknowledgeReview(UUID id) {
        return http.put(REVIEWS_PATH + "/" + id + "/acknowledge", null,
                PerformanceReviewResponse.class);
    }

    // --- Goals ---

    public GoalResponse createGoal(CreateGoalRequest request) {
        return http.post(GOALS_PATH, request, GoalResponse.class);
    }

    public PageResponse<GoalResponse> listGoals(UUID employeeId, PageRequest page) {
        String path = withPagination(GOALS_PATH + "?employeeId=" + employeeId, page);
        return http.get(path, new TypeReference<PageResponse<GoalResponse>>() {});
    }

    public GoalResponse updateProgress(UUID id, int progress) {
        return http.put(GOALS_PATH + "/" + id + "/progress",
                Map.of("progress", progress),
                GoalResponse.class);
    }
}
