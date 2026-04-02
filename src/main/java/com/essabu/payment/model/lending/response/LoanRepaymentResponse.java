package com.essabu.payment.model.lending.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a loan repayment returned by the Essabu Payment API.
 *
 * Contains all loan repayment information returned by the Payment REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the loan repayment resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - loanApplicationId: loan application id
 * - amount: amount
 * - principal: principal
 * - interest: interest
 * - penalty: penalty
 * - paidAt: paid at
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
public class LoanRepaymentResponse {

    private UUID id;
    private UUID loanApplicationId;
    private BigDecimal amount;
    private BigDecimal principal;
    private BigDecimal interest;
    private BigDecimal penalty;
    private LocalDateTime paidAt;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDateTime createdAt;
}
