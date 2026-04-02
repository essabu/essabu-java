package com.essabu.payment.api.lending;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.payment.model.lending.request.CreateKycProfileRequest;
import com.essabu.payment.model.lending.response.KycProfileResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing kyc profile resources in the Essabu Payment module.
 *
 * Provides typed methods to interact with the kyc profile REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - verify: verify operation
 *
 * Base path: /api/lending/kyc-profiles
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class KycProfileApi extends BaseApi {

    private static final String BASE_PATH = "/api/lending/kyc-profiles";

    public KycProfileApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Creates a new KYC profile.
     */
    public KycProfileResponse create(CreateKycProfileRequest request) {
        return http.post(BASE_PATH, request, KycProfileResponse.class);
    }

    /**
     * Retrieves a KYC profile by its identifier.
     */
    public KycProfileResponse getById(UUID id) {
        return http.get(BASE_PATH + "/" + id, KycProfileResponse.class);
    }

    /**
     * Lists the KYC profiles of a company.
     */
    public PageResponse<KycProfileResponse> getByCompany(UUID companyId, PageRequest page) {
        String path = withParam(BASE_PATH, "companyId", companyId);
        path = withPagination(path, page);
        return http.get(path, new TypeReference<>() {});
    }

    /**
     * Verifies a KYC profile.
     */
    public KycProfileResponse verify(UUID id) {
        return http.post(BASE_PATH + "/" + id + "/verify", null, KycProfileResponse.class);
    }
}
