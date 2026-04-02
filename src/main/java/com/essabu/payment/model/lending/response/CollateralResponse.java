package com.essabu.payment.model.lending.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a collateral returned by the Essabu Payment API.
 *
 * Contains all collateral information returned by the Payment REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the collateral resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - loanApplicationId: loan application id
 * - type: type
 * - typeLabel: type label
 * - typeColor: type color
 * - description: description
 * - estimatedValue: estimated value
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
public class CollateralResponse {

    private UUID id;
    private UUID companyId;
    private UUID loanApplicationId;
    private String type;
    private String typeLabel;
    private String typeColor;
    private String description;
    private BigDecimal estimatedValue;
    private String currency;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDateTime createdAt;
}
