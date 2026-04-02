package com.essabu.hr.model.compensation.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a payroll returned by the Essabu HR API.
 *
 * Contains all payroll information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the payroll resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - period: period
 * - startDate: start date
 * - endDate: end date
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - totalGross: total gross
 * - totalDeductions: total deductions
 * - totalNet: total net
 * - currency: currency
 * - approvedBy: approved by
 * - approverName: approver name
 * - lines: lines
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
public class PayrollResponse {
    private UUID id;
    private String period;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private String statusLabel;
    private String statusColor;
    private BigDecimal totalGross;
    private BigDecimal totalDeductions;
    private BigDecimal totalNet;
    private String currency;
    private UUID approvedBy;
    private String approverName;
    private List<PayrollLineResponse> lines;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
