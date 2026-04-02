package com.essabu.hr.model.workforce.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a shift schedule returned by the Essabu HR API.
 *
 * Contains all shift schedule information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the shift schedule resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - name: name
 * - departmentId: department id
 * - departmentName: department name
 * - startDate: start date
 * - endDate: end date
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
public class ShiftScheduleResponse {
    private UUID id;
    private String name;
    private UUID departmentId;
    private String departmentName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private String statusLabel;
    private String statusColor;
    private UUID approvedBy;
    private String approverName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
