package com.essabu.payment.model.lending.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a loan product returned by the Essabu Payment API.
 *
 * Contains all loan product information returned by the Payment REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the loan product resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - name: name
 * - type: type
 * - typeLabel: type label
 * - typeColor: type color
 * - interestRate: interest rate
 * - minAmount: min amount
 * - maxAmount: max amount
 * - minTerm: min term
 * - maxTerm: max term
 * - currency: currency
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanProductResponse {

    private UUID id;
    private UUID companyId;
    private String name;
    private String type;
    private String typeLabel;
    private String typeColor;
    private BigDecimal interestRate;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private int minTerm;
    private int maxTerm;
    private String currency;
    private LocalDateTime createdAt;
}
