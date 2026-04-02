package com.essabu.hr.model.compensation.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a loan repayment returned by the Essabu HR API.
 *
 * Contains all loan repayment information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the loan repayment resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - loanId: loan id
 * - amount: amount
 * - paymentDate: payment date
 * - source: source
 * - sourceLabel: source label
 * - remainingBalance: remaining balance
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
    private UUID loanId;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private String source;
    private String sourceLabel;
    private BigDecimal remainingBalance;
    private LocalDateTime createdAt;
}
