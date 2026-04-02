package com.essabu.einvoice.api.invoice;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.einvoice.model.invoice.request.NormalizeInvoiceRequest;
import com.essabu.einvoice.model.invoice.response.NormalizedInvoiceResponse;

/**
 * API client for managing invoice resources in the Essabu E-Invoice module.
 *
 * Provides typed methods to interact with the invoice REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - normalize: normalize operation
 *
 * Base path: /api/einvoice
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class InvoiceApi extends BaseApi {

    private static final String BASE_PATH = "/api/einvoice";

    public InvoiceApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Normalizes an invoice for e-invoicing compliance with a government system.
     *
     * @param request the normalization request containing invoice details
     * @return the normalized invoice with QR code, digital signature, and verification code
     */
    public NormalizedInvoiceResponse normalize(NormalizeInvoiceRequest request) {
        return http.post(BASE_PATH + "/normalize", request, NormalizedInvoiceResponse.class);
    }
}
