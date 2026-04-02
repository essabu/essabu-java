package com.essabu.payment.model.subscription.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a subscription returned by the Essabu Payment API.
 *
 * Contains all subscription information returned by the Payment REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the subscription resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - planId: plan id
 * - planName: plan name
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - monthlyPrice: monthly price
 * - currency: currency
 * - startDate: start date
 * - endDate: end date
 * - cancelledAt: cancelled at
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionResponse {

    private UUID id;
    private UUID companyId;
    private UUID planId;
    private String planName;
    private String status;
    private String statusLabel;
    private String statusColor;
    private BigDecimal monthlyPrice;
    private String currency;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime cancelledAt;
    private LocalDateTime createdAt;
}
