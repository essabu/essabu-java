package com.essabu.accounting.model.finance.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a general ledger returned by the Essabu Accounting API.
 *
 * Contains all general ledger information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the general ledger resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - companyId: company id
 * - periodId: period id
 * - accounts: accounts
 * - accountId: account id
 * - accountCode: account code
 * - accountName: account name
 * - openingBalance: opening balance
 * - closingBalance: closing balance
 * - entries: entries
 * - entryId: entry id
 * - entryNumber: entry number
 * - entryDate: entry date
 * - description: description
 * - debitAmount: debit amount
 * - creditAmount: credit amount
 * - runningBalance: running balance
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneralLedgerResponse {
    private UUID companyId;
    private UUID periodId;
    private List<GeneralLedgerAccountResponse> accounts;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GeneralLedgerAccountResponse {
        private UUID accountId;
        private String accountCode;
        private String accountName;
        private long openingBalance;
        private long closingBalance;
        private List<GeneralLedgerEntryResponse> entries;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GeneralLedgerEntryResponse {
        private UUID entryId;
        private String entryNumber;
        private LocalDate entryDate;
        private String description;
        private long debitAmount;
        private long creditAmount;
        private long runningBalance;
    }
}
