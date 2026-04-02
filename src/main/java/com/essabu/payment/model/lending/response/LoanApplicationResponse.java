package com.essabu.payment.model.lending.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a loan application returned by the Essabu Payment API.
 *
 * Contains all loan application information returned by the Payment REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the loan application resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - customerId: customer id
 * - loanProductId: loan product id
 * - requestedAmount: requested amount
 * - requestedTerm: requested term
 * - purpose: purpose
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - approvedAmount: approved amount
 * - approvedBy: approved by
 * - submittedAt: submitted at
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanApplicationResponse {

    private UUID id;
    private UUID companyId;
    private UUID customerId;
    private UUID loanProductId;
    private BigDecimal requestedAmount;
    private int requestedTerm;
    private String purpose;
    private String status;
    private String statusLabel;
    private String statusColor;
    private BigDecimal approvedAmount;
    private UUID approvedBy;
    private LocalDateTime submittedAt;
    private LocalDateTime createdAt;
}
