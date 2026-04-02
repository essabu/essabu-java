package com.essabu.accounting.model.core.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Response payload representing a opening balance returned by the Essabu Accounting API.
 *
 * Contains all opening balance information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the opening balance resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - accountId: account id
 * - fiscalYearId: fiscal year id
 * - debitAmount: debit amount
 * - creditAmount: credit amount
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpeningBalanceResponse {
    private UUID id;
    private UUID companyId;
    private UUID accountId;
    private UUID fiscalYearId;
    private long debitAmount;
    private long creditAmount;
}
