package com.essabu.accounting.model.inventory.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a stock movement returned by the Essabu Accounting API.
 *
 * Contains all stock movement information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the stock movement resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - inventoryItemId: inventory item id
 * - fromLocationId: from location id
 * - toLocationId: to location id
 * - type: type
 * - typeLabel: type label
 * - typeColor: type color
 * - quantity: quantity
 * - reference: reference
 * - reason: reason
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockMovementResponse {
    private UUID id;
    private UUID companyId;
    private UUID inventoryItemId;
    private UUID fromLocationId;
    private UUID toLocationId;
    private String type;
    private String typeLabel;
    private String typeColor;
    private BigDecimal quantity;
    private String reference;
    private String reason;
    private LocalDateTime createdAt;
}
