package com.essabu.accounting.model.transactions.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Response payload representing a credit note line returned by the Essabu Accounting API.
 *
 * Contains all credit note line information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the credit note line resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - description: description
 * - quantity: quantity
 * - unitPrice: unit price
 * - taxAmount: tax amount
 * - lineTotal: line total
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditNoteLineResponse {
    private UUID id;
    private String description;
    private BigDecimal quantity;
    private long unitPrice;
    private long taxAmount;
    private long lineTotal;
}
