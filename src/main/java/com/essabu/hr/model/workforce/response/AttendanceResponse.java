package com.essabu.hr.model.workforce.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a attendance returned by the Essabu HR API.
 *
 * Contains all attendance information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the attendance resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - employeeId: employee id
 * - employeeName: employee name
 * - date: date
 * - clockIn: clock in
 * - clockOut: clock out
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - hoursWorked: hours worked
 * - notes: notes
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceResponse {
    private UUID id;
    private UUID employeeId;
    private String employeeName;
    private LocalDate date;
    private LocalDateTime clockIn;
    private LocalDateTime clockOut;
    private String status;
    private String statusLabel;
    private String statusColor;
    private double hoursWorked;
    private String notes;
    private LocalDateTime createdAt;
}
