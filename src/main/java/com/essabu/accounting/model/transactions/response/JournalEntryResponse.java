package com.essabu.accounting.model.transactions.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a journal entry returned by the Essabu Accounting API.
 *
 * Contains all journal entry information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the journal entry resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - journalId: journal id
 * - entryNumber: entry number
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - entryDate: entry date
 * - description: description
 * - source: source
 * - reference: reference
 * - totalDebit: total debit
 * - totalCredit: total credit
 * - lines: lines
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JournalEntryResponse {
    private UUID id;
    private UUID companyId;
    private UUID journalId;
    private String entryNumber;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDate entryDate;
    private String description;
    private String source;
    private String reference;
    private long totalDebit;
    private long totalCredit;
    private List<JournalEntryLineResponse> lines;
    private LocalDateTime createdAt;
}
