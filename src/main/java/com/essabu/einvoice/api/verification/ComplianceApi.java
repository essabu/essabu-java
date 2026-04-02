package com.essabu.einvoice.api.verification;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.einvoice.model.verification.GenerateComplianceReportRequest;
import com.essabu.einvoice.model.verification.response.ComplianceReportResponse;

/**
 * API client for managing compliance resources in the Essabu E-Invoice module.
 *
 * Provides typed methods to interact with the compliance REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - generateReport: generate report operation
 *
 * Base path: /api/einvoice
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class ComplianceApi extends BaseApi {

    private static final String BASE_PATH = "/api/einvoice";

    public ComplianceApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Generates a compliance report for a company over a specified period.
     *
     * @param request the report request containing company ID and date range
     * @return the compliance report with submission statistics and compliance rate
     */
    public ComplianceReportResponse generateReport(GenerateComplianceReportRequest request) {
        return http.post(BASE_PATH + "/compliance-report", request, ComplianceReportResponse.class);
    }
}
