package com.essabu.payment.model.lending.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Response payload representing a loan schedule returned by the Essabu Payment API.
 *
 * Contains all loan schedule information returned by the Payment REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the loan schedule resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - loanApplicationId: loan application id
 * - installmentNumber: installment number
 * - dueDate: due date
 * - principal: principal
 * - interest: interest
 * - totalDue: total due
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanScheduleResponse {

    private UUID id;
    private UUID loanApplicationId;
    private int installmentNumber;
    private LocalDate dueDate;
    private BigDecimal principal;
    private BigDecimal interest;
    private BigDecimal totalDue;
    private String status;
    private String statusLabel;
    private String statusColor;
}
