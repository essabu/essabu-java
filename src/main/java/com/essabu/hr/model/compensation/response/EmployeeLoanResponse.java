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
 * Response payload representing a employee loan returned by the Essabu HR API.
 *
 * Contains all employee loan information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the employee loan resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - employeeId: employee id
 * - employeeName: employee name
 * - loanType: loan type
 * - loanTypeLabel: loan type label
 * - loanTypeColor: loan type color
 * - amount: amount
 * - interestRate: interest rate
 * - monthlyRepayment: monthly repayment
 * - outstandingBalance: outstanding balance
 * - currency: currency
 * - startDate: start date
 * - endDate: end date
 * - totalInstallments: total installments
 * - paidInstallments: paid installments
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - approvedBy: approved by
 * - approverName: approver name
 * - createdAt: created at
 * - updatedAt: updated at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeLoanResponse {
    private UUID id;
    private UUID employeeId;
    private String employeeName;
    private String loanType;
    private String loanTypeLabel;
    private String loanTypeColor;
    private BigDecimal amount;
    private BigDecimal interestRate;
    private BigDecimal monthlyRepayment;
    private BigDecimal outstandingBalance;
    private String currency;
    private LocalDate startDate;
    private LocalDate endDate;
    private int totalInstallments;
    private int paidInstallments;
    private String status;
    private String statusLabel;
    private String statusColor;
    private UUID approvedBy;
    private String approverName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
