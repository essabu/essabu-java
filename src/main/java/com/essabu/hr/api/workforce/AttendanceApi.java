package com.essabu.hr.api.workforce;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.BaseApi;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.hr.model.workforce.request.ClockInRequest;
import com.essabu.hr.model.workforce.request.ClockOutRequest;
import com.essabu.hr.model.workforce.request.RecordAttendanceRequest;
import com.essabu.hr.model.workforce.response.AttendanceResponse;
import com.essabu.hr.model.workforce.response.AttendanceSummaryResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing attendance resources in the Essabu HR module.
 *
 * Provides typed methods to interact with the attendance REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - record: record operation
 * - clockIn: clock in operation
 * - clockOut: clock out operation
 * - list: list operation
 * - summary: summary operation
 *
 * Base path: /api/hr/attendances
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class AttendanceApi extends BaseApi {

    private static final String BASE_PATH = "/api/hr/attendances";

    public AttendanceApi(HttpClientWrapper http) {
        super(http);
    }

    public AttendanceResponse record(RecordAttendanceRequest request) {
        return http.post(BASE_PATH, request, AttendanceResponse.class);
    }

    public AttendanceResponse clockIn(ClockInRequest request) {
        return http.post(BASE_PATH + "/clock-in", request, AttendanceResponse.class);
    }

    public AttendanceResponse clockOut(ClockOutRequest request) {
        return http.post(BASE_PATH + "/clock-out", request, AttendanceResponse.class);
    }

    public PageResponse<AttendanceResponse> list(PageRequest page) {
        return http.get(withPagination(BASE_PATH, page),
                new TypeReference<PageResponse<AttendanceResponse>>() {});
    }

    public AttendanceSummaryResponse summary(UUID employeeId, String month) {
        String path = withParam(BASE_PATH + "/summary", "employeeId", employeeId);
        path = withParam(path, "month", month);
        return http.get(path, AttendanceSummaryResponse.class);
    }
}
