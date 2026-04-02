package com.essabu.accounting.api.finance;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.accounting.model.finance.request.CreateTaxRateRequest;
import com.essabu.accounting.model.finance.request.UpdateTaxRateRequest;
import com.essabu.accounting.model.finance.response.TaxRateResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing tax rate resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the tax rate REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - list: list operation
 * - update: update operation
 * - deactivate: deactivate operation
 * - delete: delete operation
 *
 * Base path: /api/accounting/tax-rates
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class TaxRateApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/tax-rates";

    public TaxRateApi(HttpClientWrapper http) {
        super(http);
    }

    public TaxRateResponse create(CreateTaxRateRequest request) {
        return http.post(BASE_PATH, request, TaxRateResponse.class);
    }

    public TaxRateResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, TaxRateResponse.class);
    }

    public List<TaxRateResponse> list(UUID companyId) {
        return http.get(BASE_PATH + "?companyId=" + companyId, new TypeReference<>() {});
    }

    public TaxRateResponse update(UUID id, UpdateTaxRateRequest request) {
        return http.put(BASE_PATH + "/" + id, request, TaxRateResponse.class);
    }

    public TaxRateResponse deactivate(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/deactivate", TaxRateResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }
}
