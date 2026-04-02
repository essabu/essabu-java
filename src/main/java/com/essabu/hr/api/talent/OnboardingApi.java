package com.essabu.hr.api.talent;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.BaseApi;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.hr.model.talent.request.CreateOnboardingPlanRequest;
import com.essabu.hr.model.talent.response.OnboardingPlanResponse;
import com.essabu.hr.model.talent.response.OnboardingTaskResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing onboarding resources in the Essabu HR module.
 *
 * Provides typed methods to interact with the onboarding REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - list: list operation
 * - completeTask: complete task operation
 *
 * Base path: /api/hr/onboarding-plans
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class OnboardingApi extends BaseApi {

    private static final String BASE_PATH = "/api/hr/onboarding-plans";

    public OnboardingApi(HttpClientWrapper http) {
        super(http);
    }

    public OnboardingPlanResponse create(CreateOnboardingPlanRequest request) {
        return http.post(BASE_PATH, request, OnboardingPlanResponse.class);
    }

    public OnboardingPlanResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, OnboardingPlanResponse.class);
    }

    public PageResponse<OnboardingPlanResponse> list(PageRequest page) {
        return http.get(withPagination(BASE_PATH, page),
                new TypeReference<PageResponse<OnboardingPlanResponse>>() {});
    }

    public OnboardingTaskResponse completeTask(UUID taskId) {
        return http.put("/api/hr/onboarding-tasks/" + taskId + "/complete", null,
                OnboardingTaskResponse.class);
    }

    public int getProgress(UUID planId) {
        return http.get(BASE_PATH + "/" + planId + "/progress", Integer.class);
    }
}
