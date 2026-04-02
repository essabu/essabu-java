package com.essabu.einvoice.model.invoice.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Request payload for performing an operation on a normalize invoice item via the Essabu E-Invoice API.
 *
 * This data transfer object carries the parameters required to process
 * a normalize invoice item resource through the E-Invoice REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - description: description
 * - quantity: quantity
 * - unitPrice: unit price
 * - taxRate: tax rate
 * - taxAmount: tax amount
 * - lineTotal: line total
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NormalizeInvoiceItemRequest {

    private String description;
    private BigDecimal quantity;
    private BigDecimal unitPrice;
    private BigDecimal taxRate;
    private BigDecimal taxAmount;
    private BigDecimal lineTotal;
}
