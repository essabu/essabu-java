package com.essabu.accounting.model.finance.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a trial balance returned by the Essabu Accounting API.
 *
 * Contains all trial balance information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the trial balance resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - companyId: company id
 * - periodId: period id
 * - totalDebit: total debit
 * - totalCredit: total credit
 * - lines: lines
 * - accountId: account id
 * - accountCode: account code
 * - accountName: account name
 * - debitBalance: debit balance
 * - creditBalance: credit balance
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrialBalanceResponse {
    private UUID companyId;
    private UUID periodId;
    private long totalDebit;
    private long totalCredit;
    private List<TrialBalanceLineResponse> lines;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TrialBalanceLineResponse {
        private UUID accountId;
        private String accountCode;
        private String accountName;
        private long debitBalance;
        private long creditBalance;
    }
}
