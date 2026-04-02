package com.essabu.accounting.model.inventory.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a inventory item returned by the Essabu Accounting API.
 *
 * Contains all inventory item information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the inventory item resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - code: code
 * - name: name
 * - category: category
 * - categoryLabel: category label
 * - categoryColor: category color
 * - unit: unit
 * - unitPrice: unit price
 * - currentStock: current stock
 * - minimumStock: minimum stock
 * - reorderPoint: reorder point
 * - defaultLocationId: default location id
 * - description: description
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItemResponse {
    private UUID id;
    private UUID companyId;
    private String code;
    private String name;
    private String category;
    private String categoryLabel;
    private String categoryColor;
    private String unit;
    private long unitPrice;
    private int currentStock;
    private int minimumStock;
    private int reorderPoint;
    private UUID defaultLocationId;
    private String description;
    private LocalDateTime createdAt;
}
