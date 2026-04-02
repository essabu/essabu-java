package com.essabu.payment.model.subscription.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a billing cycle returned by the Essabu Payment API.
 *
 * Contains all billing cycle information returned by the Payment REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the billing cycle resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - subscriptionId: subscription id
 * - periodStart: period start
 * - periodEnd: period end
 * - amount: amount
 * - currency: currency
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillingCycleResponse {

    private UUID id;
    private UUID subscriptionId;
    private LocalDateTime periodStart;
    private LocalDateTime periodEnd;
    private BigDecimal amount;
    private String currency;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDateTime createdAt;
}
