package com.essabu.einvoice.api.verification;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.einvoice.model.verification.response.EInvoiceStatisticsResponse;

import java.util.UUID;

/**
 * API client for managing statistics resources in the Essabu E-Invoice module.
 *
 * Provides typed methods to interact with the statistics REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Base path: /api/einvoice
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class StatisticsApi extends BaseApi {

    private static final String BASE_PATH = "/api/einvoice";

    public StatisticsApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Retrieves e-invoice statistics for a company.
     *
     * @param companyId the UUID of the company
     * @return the statistics including submission counts, compliance rate, and breakdowns
     */
    public EInvoiceStatisticsResponse get(UUID companyId) {
        String path = withParam(BASE_PATH + "/statistics", "companyId", companyId);
        return http.get(path, EInvoiceStatisticsResponse.class);
    }
}
