package com.essabu.payment.model.subscription.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Response payload representing a subscription plan returned by the Essabu Payment API.
 *
 * Contains all subscription plan information returned by the Payment REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the subscription plan resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - name: name
 * - tier: tier
 * - tierLabel: tier label
 * - tierColor: tier color
 * - monthlyPrice: monthly price
 * - annualPrice: annual price
 * - currency: currency
 * - billingInterval: billing interval
 * - billingIntervalLabel: billing interval label
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionPlanResponse {

    private UUID id;
    private String name;
    private String tier;
    private String tierLabel;
    private String tierColor;
    private BigDecimal monthlyPrice;
    private BigDecimal annualPrice;
    private String currency;
    private String billingInterval;
    private String billingIntervalLabel;
}
