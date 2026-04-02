package com.essabu.accounting.api.finance;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.accounting.model.finance.request.CreateFiscalYearRequest;
import com.essabu.accounting.model.finance.request.UpdateFiscalYearRequest;
import com.essabu.accounting.model.finance.response.FiscalYearResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing fiscal year resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the fiscal year REST API endpoints
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
 * - close: close operation
 * - reopen: reopen operation
 *
 * Base path: /api/accounting/fiscal-years
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class FiscalYearApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/fiscal-years";

    public FiscalYearApi(HttpClientWrapper http) {
        super(http);
    }

    public FiscalYearResponse create(CreateFiscalYearRequest request) {
        return http.post(BASE_PATH, request, FiscalYearResponse.class);
    }

    public FiscalYearResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, FiscalYearResponse.class);
    }

    public List<FiscalYearResponse> list(UUID companyId) {
        return http.get(BASE_PATH + "?companyId=" + companyId, new TypeReference<>() {});
    }

    public FiscalYearResponse update(UUID id, UpdateFiscalYearRequest request) {
        return http.put(BASE_PATH + "/" + id, request, FiscalYearResponse.class);
    }

    public FiscalYearResponse close(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/close", FiscalYearResponse.class);
    }

    public FiscalYearResponse reopen(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/reopen", FiscalYearResponse.class);
    }

    public FiscalYearResponse getCurrent(UUID companyId) {
        return http.get(BASE_PATH + "/current?companyId=" + companyId, FiscalYearResponse.class);
    }
}
