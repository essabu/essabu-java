package com.essabu.accounting.model.finance.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a income statement returned by the Essabu Accounting API.
 *
 * Contains all income statement information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the income statement resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - companyId: company id
 * - periodId: period id
 * - totalIncome: total income
 * - totalExpenses: total expenses
 * - netResult: net result
 * - incomeLines: income lines
 * - expenseLines: expense lines
 * - accountId: account id
 * - accountCode: account code
 * - accountName: account name
 * - balance: balance
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncomeStatementResponse {
    private UUID companyId;
    private UUID periodId;
    private long totalIncome;
    private long totalExpenses;
    private long netResult;
    private List<IncomeStatementLineResponse> incomeLines;
    private List<IncomeStatementLineResponse> expenseLines;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IncomeStatementLineResponse {
        private UUID accountId;
        private String accountCode;
        private String accountName;
        private long balance;
    }
}
