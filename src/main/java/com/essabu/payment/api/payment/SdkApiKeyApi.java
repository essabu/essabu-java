package com.essabu.payment.api.payment;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.payment.model.sdk.request.CreateSdkApiKeyRequest;
import com.essabu.payment.model.sdk.response.SdkApiKeyCreatedResponse;
import com.essabu.payment.model.sdk.response.SdkApiKeyResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing sdk key resources in the Essabu Payment module.
 *
 * Provides typed methods to interact with the sdk key REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - revoke: revoke operation
 *
 * Base path: /api/payment/sdk-keys
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class SdkApiKeyApi extends BaseApi {

    private static final String BASE_PATH = "/api/payment/sdk-keys";

    public SdkApiKeyApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Creates a new SDK API key.
     */
    public SdkApiKeyCreatedResponse create(CreateSdkApiKeyRequest request) {
        return http.post(BASE_PATH, request, SdkApiKeyCreatedResponse.class);
    }

    /**
     * Lists the SDK API keys of a company.
     */
    public List<SdkApiKeyResponse> getByCompany(UUID companyId) {
        String path = withParam(BASE_PATH, "companyId", companyId);
        return http.get(path, new TypeReference<>() {});
    }

    /**
     * Revokes an SDK API key.
     */
    public void revoke(UUID id) {
        http.delete(BASE_PATH + "/" + id + "/revoke");
    }
}
