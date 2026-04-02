package com.essabu.payment.model.lending.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a account transaction returned by the Essabu Payment API.
 *
 * Contains all account transaction information returned by the Payment REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the account transaction resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - accountId: account id
 * - type: type
 * - typeLabel: type label
 * - typeColor: type color
 * - amount: amount
 * - balanceBefore: balance before
 * - balanceAfter: balance after
 * - reference: reference
 * - description: description
 * - transactionDate: transaction date
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransactionResponse {

    private UUID id;
    private UUID accountId;
    private String type;
    private String typeLabel;
    private String typeColor;
    private BigDecimal amount;
    private BigDecimal balanceBefore;
    private BigDecimal balanceAfter;
    private String reference;
    private String description;
    private LocalDateTime transactionDate;
    private LocalDateTime createdAt;
}
