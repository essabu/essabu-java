package com.essabu.hr.model.workforce.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a leave request returned by the Essabu HR API.
 *
 * Contains all leave request information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the leave request resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - employeeId: employee id
 * - employeeName: employee name
 * - leaveType: leave type
 * - leaveTypeLabel: leave type label
 * - leaveTypeColor: leave type color
 * - startDate: start date
 * - endDate: end date
 * - days: days
 * - reason: reason
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
public class LeaveRequestResponse {
    private UUID id;
    private UUID employeeId;
    private String employeeName;
    private String leaveType;
    private String leaveTypeLabel;
    private String leaveTypeColor;
    private LocalDate startDate;
    private LocalDate endDate;
    private int days;
    private String reason;
    private String status;
    private String statusLabel;
    private String statusColor;
    private UUID approvedBy;
    private String approverName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
