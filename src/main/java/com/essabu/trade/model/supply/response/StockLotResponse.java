package com.essabu.trade.model.supply.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a stock lot returned by the Essabu Trade API.
 *
 * Contains all stock lot information returned by the Trade REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the stock lot resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - productId: product id
 * - warehouseId: warehouse id
 * - lotNumber: lot number
 * - quantity: quantity
 * - expirationDate: expiration date
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockLotResponse {
    private UUID id;
    private UUID companyId;
    private UUID productId;
    private UUID warehouseId;
    private String lotNumber;
    private int quantity;
    private LocalDate expirationDate;
    private LocalDateTime createdAt;
}
