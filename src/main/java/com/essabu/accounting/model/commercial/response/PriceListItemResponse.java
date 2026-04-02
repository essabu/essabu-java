package com.essabu.accounting.model.commercial.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a price list item returned by the Essabu Accounting API.
 *
 * Contains all price list item information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the price list item resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - priceListId: price list id
 * - serviceId: service id
 * - serviceName: service name
 * - unitPrice: unit price
 * - currency: currency
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceListItemResponse {
    private UUID id;
    private UUID priceListId;
    private UUID serviceId;
    private String serviceName;
    private long unitPrice;
    private String currency;
    private LocalDateTime createdAt;
}
