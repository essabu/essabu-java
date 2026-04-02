package com.essabu.accounting.model.transactions.request;

import com.essabu.accounting.model.transactions.enums.EntrySource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Request payload for creating a journal entry via the Essabu Accounting API.
 *
 * This data transfer object carries the parameters required to create
 * a journal entry resource through the Accounting REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - journalId: journal id
 * - entryDate: entry date
 * - description: description
 * - source: source
 * - reference: reference
 * - lines: lines
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateJournalEntryRequest {
    private UUID companyId;
    private UUID journalId;
    private LocalDate entryDate;
    private String description;
    private EntrySource source;
    private String reference;
    private List<JournalEntryLineRequest> lines;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JournalEntryLineRequest {
        private UUID accountId;
        private String accountCode;
        private String accountName;
        private long debitAmount;
        private long creditAmount;
        private String description;
    }
}
