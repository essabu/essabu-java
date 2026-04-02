package com.essabu.accounting.model.finance.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Response payload representing a tax rate returned by the Essabu Accounting API.
 *
 * Contains all tax rate information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the tax rate resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - name: name
 * - rate: rate
 * - description: description
 * - isActive: is active
 * - isDefault: is default
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxRateResponse {
    private UUID id;
    private UUID companyId;
    private String name;
    private BigDecimal rate;
    private String description;
    private boolean isActive;
    private boolean isDefault;
}
