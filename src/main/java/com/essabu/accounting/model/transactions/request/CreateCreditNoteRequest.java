package com.essabu.accounting.model.transactions.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Request payload for creating a credit note via the Essabu Accounting API.
 *
 * This data transfer object carries the parameters required to create
 * a credit note resource through the Accounting REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - invoiceId: invoice id
 * - issueDate: issue date
 * - currency: currency
 * - reason: reason
 * - lines: lines
 * - description: description
 * - quantity: quantity
 * - unitPrice: unit price
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCreditNoteRequest {
    private UUID companyId;
    private UUID invoiceId;
    private LocalDate issueDate;
    private String currency;
    private String reason;
    private List<CreditNoteLineRequest> lines;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreditNoteLineRequest {
        private String description;
        private BigDecimal quantity;
        private long unitPrice;
    }
}
