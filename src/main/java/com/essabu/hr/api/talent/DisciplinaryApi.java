package com.essabu.hr.api.talent;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.BaseApi;
import com.essabu.hr.model.talent.request.CreateDisciplinaryActionRequest;
import com.essabu.hr.model.talent.response.DisciplinaryActionResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing disciplinary resources in the Essabu HR module.
 *
 * Provides typed methods to interact with the disciplinary REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - listByEmployee: list by employee operation
 * - revoke: revoke operation
 *
 * Base path: /api/hr/disciplinary-actions
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class DisciplinaryApi extends BaseApi {

    private static final String BASE_PATH = "/api/hr/disciplinary-actions";

    public DisciplinaryApi(HttpClientWrapper http) {
        super(http);
    }

    public DisciplinaryActionResponse create(CreateDisciplinaryActionRequest request) {
        return http.post(BASE_PATH, request, DisciplinaryActionResponse.class);
    }

    public DisciplinaryActionResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, DisciplinaryActionResponse.class);
    }

    public List<DisciplinaryActionResponse> listByEmployee(UUID employeeId) {
        return http.get(BASE_PATH + "?employeeId=" + employeeId,
                new TypeReference<>() {});
    }

    public DisciplinaryActionResponse revoke(UUID id) {
        return http.put(BASE_PATH + "/" + id + "/revoke", null,
                DisciplinaryActionResponse.class);
    }
}
