package com.essabu.accounting.model.inventory.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Response payload representing a purchase order item returned by the Essabu Accounting API.
 *
 * Contains all purchase order item information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the purchase order item resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - inventoryItemId: inventory item id
 * - quantity: quantity
 * - receivedQuantity: received quantity
 * - unitPrice: unit price
 * - lineTotal: line total
 * - description: description
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderItemResponse {
    private UUID id;
    private UUID inventoryItemId;
    private BigDecimal quantity;
    private BigDecimal receivedQuantity;
    private long unitPrice;
    private long lineTotal;
    private String description;
}
