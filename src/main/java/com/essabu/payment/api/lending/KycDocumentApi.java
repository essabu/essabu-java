package com.essabu.payment.api.lending;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.payment.model.lending.request.CreateKycDocumentRequest;
import com.essabu.payment.model.lending.response.KycDocumentResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing kyc document resources in the Essabu Payment module.
 *
 * Provides typed methods to interact with the kyc document REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 *
 * Base path: /api/lending/kyc-documents
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class KycDocumentApi extends BaseApi {

    private static final String BASE_PATH = "/api/lending/kyc-documents";

    public KycDocumentApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Creates a new KYC document.
     */
    public KycDocumentResponse create(CreateKycDocumentRequest request) {
        return http.post(BASE_PATH, request, KycDocumentResponse.class);
    }

    /**
     * Lists the KYC documents of a profile.
     */
    public List<KycDocumentResponse> getByProfile(UUID kycProfileId) {
        String path = withParam(BASE_PATH, "kycProfileId", kycProfileId);
        return http.get(path, new TypeReference<>() {});
    }
}
