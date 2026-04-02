package com.essabu.hr.model.workforce.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

/**
 * Response payload representing a shift returned by the Essabu HR API.
 *
 * Contains all shift information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the shift resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - employeeId: employee id
 * - employeeName: employee name
 * - shiftType: shift type
 * - shiftTypeLabel: shift type label
 * - shiftTypeColor: shift type color
 * - date: date
 * - startTime: start time
 * - endTime: end time
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - notes: notes
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
public class ShiftResponse {
    private UUID id;
    private UUID employeeId;
    private String employeeName;
    private String shiftType;
    private String shiftTypeLabel;
    private String shiftTypeColor;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String status;
    private String statusLabel;
    private String statusColor;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
