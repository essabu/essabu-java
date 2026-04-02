package com.essabu.accounting.model.transactions.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * Request payload for updating a recurring invoice via the Essabu Accounting API.
 *
 * This data transfer object carries the parameters required to update
 * a recurring invoice resource through the Accounting REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - currency: currency
 * - frequency: frequency
 * - endDate: end date
 * - dayOfMonth: day of month
 * - notes: notes
 * - lines: lines
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRecurringInvoiceRequest {
    private String currency;
    private String frequency;
    private LocalDate endDate;
    private int dayOfMonth;
    private String notes;
    private List<CreateInvoiceRequest.InvoiceLineRequest> lines;
}
