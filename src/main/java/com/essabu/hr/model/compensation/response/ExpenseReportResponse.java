package com.essabu.hr.model.compensation.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a expense report returned by the Essabu HR API.
 *
 * Contains all expense report information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the expense report resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - employeeId: employee id
 * - employeeName: employee name
 * - title: title
 * - description: description
 * - totalAmount: total amount
 * - currency: currency
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
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
public class ExpenseReportResponse {
    private UUID id;
    private UUID employeeId;
    private String employeeName;
    private String title;
    private String description;
    private BigDecimal totalAmount;
    private String currency;
    private String status;
    private String statusLabel;
    private String statusColor;
    private UUID approvedBy;
    private String approverName;
    private List<ExpenseLineResponse> lines;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
