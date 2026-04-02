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
 * Request payload for creating a quote via the Essabu Accounting API.
 *
 * This data transfer object carries the parameters required to create
 * a quote resource through the Accounting REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - customerId: customer id
 * - customerName: customer name
 * - issueDate: issue date
 * - validUntil: valid until
 * - currency: currency
 * - notes: notes
 * - lines: lines
 * - description: description
 * - quantity: quantity
 * - unitPrice: unit price
 * - taxRateId: tax rate id
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateQuoteRequest {
    private UUID companyId;
    private UUID customerId;
    private String customerName;
    private LocalDate issueDate;
    private LocalDate validUntil;
    private String currency;
    private String notes;
    private List<QuoteLineRequest> lines;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QuoteLineRequest {
        private String description;
        private BigDecimal quantity;
        private long unitPrice;
        private UUID taxRateId;
    }
}
