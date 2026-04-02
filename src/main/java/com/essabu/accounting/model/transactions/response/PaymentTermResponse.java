package com.essabu.accounting.model.transactions.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Response payload representing a payment term returned by the Essabu Accounting API.
 *
 * Contains all payment term information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the payment term resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - name: name
 * - dueDays: due days
 * - discountPercentage: discount percentage
 * - discountDays: discount days
 * - description: description
 * - isDefault: is default
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTermResponse {
    private UUID id;
    private UUID companyId;
    private String name;
    private int dueDays;
    private BigDecimal discountPercentage;
    private int discountDays;
    private String description;
    private boolean isDefault;
}
