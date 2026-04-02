package com.essabu.accounting.model.inventory.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a stock count returned by the Essabu Accounting API.
 *
 * Contains all stock count information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the stock count resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - locationId: location id
 * - countDate: count date
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - description: description
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockCountResponse {
    private UUID id;
    private UUID companyId;
    private UUID locationId;
    private LocalDate countDate;
    private String status;
    private String statusLabel;
    private String statusColor;
    private String description;
    private LocalDateTime createdAt;
}
