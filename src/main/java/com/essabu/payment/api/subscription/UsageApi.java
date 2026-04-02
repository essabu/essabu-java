package com.essabu.payment.api.subscription;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.payment.model.subscription.request.RecordUsageRequest;
import com.essabu.payment.model.subscription.response.UsageRecordResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing usage resources in the Essabu Payment module.
 *
 * Provides typed methods to interact with the usage REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - record: record operation
 *
 * Base path: /api/payment/usage
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class UsageApi extends BaseApi {

    private static final String BASE_PATH = "/api/payment/usage";

    public UsageApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Records a usage entry.
     */
    public UsageRecordResponse record(RecordUsageRequest request) {
        return http.post(BASE_PATH, request, UsageRecordResponse.class);
    }

    /**
     * Lists the usage records of a company.
     */
    public List<UsageRecordResponse> getByCompany(UUID companyId) {
        String path = withParam(BASE_PATH, "companyId", companyId);
        return http.get(path, new TypeReference<>() {});
    }
}
