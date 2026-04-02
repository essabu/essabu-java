package com.essabu.accounting.model.commercial.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a price list override returned by the Essabu Accounting API.
 *
 * Contains all price list override information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the price list override resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - priceListId: price list id
 * - branchId: branch id
 * - serviceId: service id
 * - overridePrice: override price
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceListOverrideResponse {
    private UUID id;
    private UUID priceListId;
    private UUID branchId;
    private UUID serviceId;
    private long overridePrice;
    private LocalDateTime createdAt;
}
