package com.essabu.accounting.model.transactions.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Request payload for updating a invoice via the Essabu Accounting API.
 *
 * This data transfer object carries the parameters required to update
 * a invoice resource through the Accounting REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - customerId: customer id
 * - customerName: customer name
 * - issueDate: issue date
 * - dueDate: due date
 * - currency: currency
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
public class UpdateInvoiceRequest {
    private UUID customerId;
    private String customerName;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private String currency;
    private String notes;
    private List<CreateInvoiceRequest.InvoiceLineRequest> lines;
}
