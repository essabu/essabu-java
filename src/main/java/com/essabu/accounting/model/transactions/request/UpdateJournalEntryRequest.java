package com.essabu.accounting.model.transactions.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * Request payload for updating a journal entry via the Essabu Accounting API.
 *
 * This data transfer object carries the parameters required to update
 * a journal entry resource through the Accounting REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - entryDate: entry date
 * - description: description
 * - reference: reference
 * - lines: lines
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateJournalEntryRequest {
    private LocalDate entryDate;
    private String description;
    private String reference;
    private List<CreateJournalEntryRequest.JournalEntryLineRequest> lines;
}
