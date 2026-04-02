package com.essabu.accounting.model.transactions.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Response payload representing a journal entry line returned by the Essabu Accounting API.
 *
 * Contains all journal entry line information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the journal entry line resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - accountId: account id
 * - accountCode: account code
 * - accountName: account name
 * - debitAmount: debit amount
 * - creditAmount: credit amount
 * - description: description
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JournalEntryLineResponse {
    private UUID id;
    private UUID accountId;
    private String accountCode;
    private String accountName;
    private long debitAmount;
    private long creditAmount;
    private String description;
}
