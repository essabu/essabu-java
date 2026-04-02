package com.essabu.einvoice.api.verification;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.einvoice.model.verification.VerifyInvoiceRequest;
import com.essabu.einvoice.model.verification.response.VerificationResponse;

/**
 * API client for managing verification resources in the Essabu E-Invoice module.
 *
 * Provides typed methods to interact with the verification REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - verify: verify operation
 *
 * Base path: /api/public/einvoice
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class VerificationApi extends BaseApi {

    private static final String BASE_PATH = "/api/public/einvoice";

    public VerificationApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Verifies an e-invoice using its verification code or QR data.
     *
     * @param request the verification request containing the code or QR data
     * @return the verification result with invoice details if found
     */
    public VerificationResponse verify(VerifyInvoiceRequest request) {
        return http.post(BASE_PATH + "/verify", request, VerificationResponse.class);
    }
}
