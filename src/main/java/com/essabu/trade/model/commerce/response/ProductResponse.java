package com.essabu.trade.model.commerce.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a product returned by the Essabu Trade API.
 *
 * Contains all product information returned by the Trade REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the product resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - name: name
 * - sku: sku
 * - description: description
 * - unitPrice: unit price
 * - unit: unit
 * - categoryId: category id
 * - type: type
 * - trackInventory: track inventory
 * - slug: slug
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
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
public class ProductResponse {
    private UUID id;
    private UUID companyId;
    private String name;
    private String sku;
    private String description;
    private BigDecimal unitPrice;
    private String unit;
    private UUID categoryId;
    private String type;
    private boolean trackInventory;
    private String slug;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
