package com.essabu.hr.api.admin;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.BaseApi;
import com.essabu.hr.model.admin.response.AbsenteeismResponse;
import com.essabu.hr.model.admin.response.AgePyramidResponse;
import com.essabu.hr.model.admin.response.DashboardResponse;
import com.essabu.hr.model.admin.response.HeadcountResponse;
import com.essabu.hr.model.admin.response.LeaveUsageResponse;
import com.essabu.hr.model.admin.response.PayrollCostResponse;
import com.essabu.hr.model.admin.response.TrainingComplianceResponse;
import com.essabu.hr.model.admin.response.TurnoverResponse;

/**
 * API client for managing report resources in the Essabu HR module.
 *
 * Provides typed methods to interact with the report REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - headcount: headcount operation
 * - turnover: turnover operation
 * - absenteeism: absenteeism operation
 * - payrollCost: payroll cost operation
 * - agePyramid: age pyramid operation
 * - leaveUsage: leave usage operation
 * - trainingCompliance: training compliance operation
 * - dashboard: dashboard operation
 *
 * Base path: /api/hr/reports
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class ReportApi extends BaseApi {

    private static final String BASE_PATH = "/api/hr/reports";

    public ReportApi(HttpClientWrapper http) {
        super(http);
    }

    public HeadcountResponse headcount(String groupBy) {
        return http.get(BASE_PATH + "/headcount?groupBy=" + groupBy, HeadcountResponse.class);
    }

    public TurnoverResponse turnover(int year) {
        return http.get(BASE_PATH + "/turnover?year=" + year, TurnoverResponse.class);
    }

    public AbsenteeismResponse absenteeism(String month) {
        return http.get(BASE_PATH + "/absenteeism?month=" + month, AbsenteeismResponse.class);
    }

    public PayrollCostResponse payrollCost(int year) {
        return http.get(BASE_PATH + "/payroll-cost?year=" + year, PayrollCostResponse.class);
    }

    public AgePyramidResponse agePyramid() {
        return http.get(BASE_PATH + "/age-pyramid", AgePyramidResponse.class);
    }

    public LeaveUsageResponse leaveUsage() {
        return http.get(BASE_PATH + "/leave-usage", LeaveUsageResponse.class);
    }

    public TrainingComplianceResponse trainingCompliance() {
        return http.get(BASE_PATH + "/training-compliance", TrainingComplianceResponse.class);
    }

    public DashboardResponse dashboard() {
        return http.get(BASE_PATH + "/dashboard", DashboardResponse.class);
    }
}
