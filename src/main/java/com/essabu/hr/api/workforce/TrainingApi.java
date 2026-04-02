package com.essabu.hr.api.workforce;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.BaseApi;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.hr.model.workforce.request.CreateTrainingRequest;
import com.essabu.hr.model.workforce.request.UpdateTrainingRequest;
import com.essabu.hr.model.workforce.response.TrainingResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing training resources in the Essabu HR module.
 *
 * Provides typed methods to interact with the training REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - list: list operation
 * - update: update operation
 * - delete: delete operation
 * - complianceReport: compliance report operation
 *
 * Base path: /api/hr/trainings
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class TrainingApi extends BaseApi {

    private static final String BASE_PATH = "/api/hr/trainings";

    public TrainingApi(HttpClientWrapper http) {
        super(http);
    }

    public TrainingResponse create(CreateTrainingRequest request) {
        return http.post(BASE_PATH, request, TrainingResponse.class);
    }

    public TrainingResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, TrainingResponse.class);
    }

    public PageResponse<TrainingResponse> list(PageRequest page) {
        return http.get(withPagination(BASE_PATH, page),
                new TypeReference<PageResponse<TrainingResponse>>() {});
    }

    public TrainingResponse update(UUID id, UpdateTrainingRequest request) {
        return http.put(BASE_PATH + "/" + id, request, TrainingResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }

    public List<TrainingResponse> getExpiring(int withinDays) {
        return http.get(BASE_PATH + "/expiring?withinDays=" + withinDays,
                new TypeReference<>() {});
    }

    public List<TrainingResponse> complianceReport() {
        return http.get(BASE_PATH + "/compliance-report",
                new TypeReference<>() {});
    }
}
