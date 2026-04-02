package com.essabu.accounting.model.finance.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a balance sheet returned by the Essabu Accounting API.
 *
 * Contains all balance sheet information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the balance sheet resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - companyId: company id
 * - periodId: period id
 * - totalAssets: total assets
 * - totalLiabilities: total liabilities
 * - totalEquity: total equity
 * - assets: assets
 * - liabilities: liabilities
 * - equity: equity
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
public class BalanceSheetResponse {
    private UUID companyId;
    private UUID periodId;
    private long totalAssets;
    private long totalLiabilities;
    private long totalEquity;
    private List<BalanceSheetLineResponse> assets;
    private List<BalanceSheetLineResponse> liabilities;
    private List<BalanceSheetLineResponse> equity;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BalanceSheetLineResponse {
        private UUID accountId;
        private String accountCode;
        private String accountName;
        private long balance;
    }
}
