package com.essabu.hr.api.workforce;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.BaseApi;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.hr.model.workforce.request.CreateTimesheetRequest;
import com.essabu.hr.model.workforce.response.TimesheetResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Map;
import java.util.UUID;

/**
 * API client for managing timesheet resources in the Essabu HR module.
 *
 * Provides typed methods to interact with the timesheet REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - list: list operation
 * - submit: submit operation
 * - approve: approve operation
 *
 * Base path: /api/hr/timesheets
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class TimesheetApi extends BaseApi {

    private static final String BASE_PATH = "/api/hr/timesheets";

    public TimesheetApi(HttpClientWrapper http) {
        super(http);
    }

    public TimesheetResponse create(CreateTimesheetRequest request) {
        return http.post(BASE_PATH, request, TimesheetResponse.class);
    }

    public TimesheetResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, TimesheetResponse.class);
    }

    public PageResponse<TimesheetResponse> list(PageRequest page) {
        return http.get(withPagination(BASE_PATH, page),
                new TypeReference<PageResponse<TimesheetResponse>>() {});
    }

    public TimesheetResponse submit(UUID id) {
        return http.put(BASE_PATH + "/" + id + "/submit", null, TimesheetResponse.class);
    }

    public TimesheetResponse approve(UUID id, UUID approvedBy) {
        return http.put(BASE_PATH + "/" + id + "/approve",
                Map.of("approvedBy", approvedBy.toString()),
                TimesheetResponse.class);
    }
}
