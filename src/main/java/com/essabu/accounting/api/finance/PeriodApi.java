package com.essabu.accounting.api.finance;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.accounting.model.finance.request.CreatePeriodRequest;
import com.essabu.accounting.model.finance.response.AccountingPeriodResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing period resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the period REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - listByFiscalYear: list by fiscal year operation
 * - open: open operation
 * - lock: lock operation
 * - close: close operation
 *
 * Base path: /api/accounting/periods
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class PeriodApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/periods";

    public PeriodApi(HttpClientWrapper http) {
        super(http);
    }

    public AccountingPeriodResponse create(CreatePeriodRequest request) {
        return http.post(BASE_PATH, request, AccountingPeriodResponse.class);
    }

    public AccountingPeriodResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, AccountingPeriodResponse.class);
    }

    public List<AccountingPeriodResponse> listByFiscalYear(UUID fiscalYearId) {
        return http.get(BASE_PATH + "?fiscalYearId=" + fiscalYearId, new TypeReference<>() {});
    }

    public AccountingPeriodResponse open(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/open", AccountingPeriodResponse.class);
    }

    public AccountingPeriodResponse lock(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/lock", AccountingPeriodResponse.class);
    }

    public AccountingPeriodResponse close(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/close", AccountingPeriodResponse.class);
    }

    public AccountingPeriodResponse getCurrent(UUID companyId) {
        return http.get(BASE_PATH + "/current?companyId=" + companyId, AccountingPeriodResponse.class);
    }
}
