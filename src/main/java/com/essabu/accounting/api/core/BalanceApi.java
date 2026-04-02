package com.essabu.accounting.api.core;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.accounting.model.core.request.CreateOpeningBalanceRequest;
import com.essabu.accounting.model.core.response.AccountBalanceResponse;
import com.essabu.accounting.model.core.response.OpeningBalanceResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing balance resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the balance REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - createOpeningBalance: create opening balance operation
 * - carryForward: carry forward operation
 *
 * Base path: /api/accounting/balances
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class BalanceApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/balances";

    public BalanceApi(HttpClientWrapper http) {
        super(http);
    }

    public List<AccountBalanceResponse> getAccountBalances(UUID companyId, UUID periodId) {
        return http.get(BASE_PATH + "/accounts?companyId=" + companyId + "&periodId=" + periodId,
                new TypeReference<>() {});
    }

    public List<OpeningBalanceResponse> getOpeningBalances(UUID companyId, UUID fiscalYearId) {
        return http.get(BASE_PATH + "/opening?companyId=" + companyId + "&fiscalYearId=" + fiscalYearId,
                new TypeReference<>() {});
    }

    public AccountBalanceResponse createOpeningBalance(CreateOpeningBalanceRequest request) {
        return http.post(BASE_PATH + "/opening", request, AccountBalanceResponse.class);
    }

    public void carryForward(UUID companyId, UUID fromFiscalYearId, UUID toFiscalYearId) {
        http.postEmptyVoid(BASE_PATH + "/carry-forward?companyId=" + companyId
                + "&fromFiscalYearId=" + fromFiscalYearId
                + "&toFiscalYearId=" + toFiscalYearId);
    }
}
