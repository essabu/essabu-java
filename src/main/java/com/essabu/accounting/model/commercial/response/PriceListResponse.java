package com.essabu.accounting.model.commercial.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a price list returned by the Essabu Accounting API.
 *
 * Contains all price list information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the price list resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - name: name
 * - effectiveFrom: effective from
 * - effectiveTo: effective to
 * - isDefault: is default
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceListResponse {
    private UUID id;
    private UUID companyId;
    private String name;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
    private Boolean isDefault;
    private LocalDateTime createdAt;
}
