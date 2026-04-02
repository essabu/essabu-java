package com.essabu.hr.model.workforce.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a timesheet returned by the Essabu HR API.
 *
 * Contains all timesheet information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the timesheet resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - employeeId: employee id
 * - employeeName: employee name
 * - weekStartDate: week start date
 * - weekEndDate: week end date
 * - totalHours: total hours
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - approvedBy: approved by
 * - approverName: approver name
 * - entries: entries
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
public class TimesheetResponse {
    private UUID id;
    private UUID employeeId;
    private String employeeName;
    private LocalDate weekStartDate;
    private LocalDate weekEndDate;
    private double totalHours;
    private String status;
    private String statusLabel;
    private String statusColor;
    private UUID approvedBy;
    private String approverName;
    private List<TimesheetEntryResponse> entries;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
