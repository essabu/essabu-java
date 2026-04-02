package com.essabu.einvoice.model.invoice.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Response payload representing a normalized invoice item returned by the Essabu E-Invoice API.
 *
 * Contains all normalized invoice item information returned by the E-Invoice REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the normalized invoice item resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
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
public class NormalizedInvoiceItemResponse {

    private String description;
    private BigDecimal quantity;
    private BigDecimal unitPrice;
    private BigDecimal taxRate;
    private BigDecimal taxAmount;
    private BigDecimal lineTotal;
}
