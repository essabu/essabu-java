package com.essabu.trade.model.supply.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a stock level returned by the Essabu Trade API.
 *
 * Contains all stock level information returned by the Trade REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the stock level resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - productId: product id
 * - warehouseId: warehouse id
 * - availableQuantity: available quantity
 * - reservedQuantity: reserved quantity
 * - createdAt: created at
 * - updatedAt: updated at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockLevelResponse {
    private UUID id;
    private UUID companyId;
    private UUID productId;
    private UUID warehouseId;
    private int availableQuantity;
    private int reservedQuantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
