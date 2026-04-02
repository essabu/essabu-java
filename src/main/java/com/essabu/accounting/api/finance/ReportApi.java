package com.essabu.accounting.api.finance;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.accounting.model.finance.response.BalanceSheetResponse;
import com.essabu.accounting.model.finance.response.GeneralLedgerResponse;
import com.essabu.accounting.model.finance.response.IncomeStatementResponse;
import com.essabu.accounting.model.finance.response.TrialBalanceResponse;

import java.util.UUID;

/**
 * API client for managing report resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the report REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - trialBalance: trial balance operation
 * - balanceSheet: balance sheet operation
 * - incomeStatement: income statement operation
 * - generalLedger: general ledger operation
 *
 * Base path: /api/accounting/reports
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class ReportApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/reports";

    public ReportApi(HttpClientWrapper http) {
        super(http);
    }

    public TrialBalanceResponse trialBalance(UUID companyId, UUID periodId) {
        return http.get(BASE_PATH + "/trial-balance?companyId=" + companyId + "&periodId=" + periodId,
                TrialBalanceResponse.class);
    }

    public BalanceSheetResponse balanceSheet(UUID companyId, UUID periodId) {
        return http.get(BASE_PATH + "/balance-sheet?companyId=" + companyId + "&periodId=" + periodId,
                BalanceSheetResponse.class);
    }

    public IncomeStatementResponse incomeStatement(UUID companyId, UUID periodId) {
        return http.get(BASE_PATH + "/income-statement?companyId=" + companyId + "&periodId=" + periodId,
                IncomeStatementResponse.class);
    }

    public GeneralLedgerResponse generalLedger(UUID companyId, UUID periodId) {
        return http.get(BASE_PATH + "/general-ledger?companyId=" + companyId + "&periodId=" + periodId,
                GeneralLedgerResponse.class);
    }
}
