package com.essabu.hr.model.talent.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a goal returned by the Essabu HR API.
 *
 * Contains all goal information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the goal resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - employeeId: employee id
 * - employeeName: employee name
 * - title: title
 * - description: description
 * - dueDate: due date
 * - progress: progress
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
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
public class GoalResponse {
    private UUID id;
    private UUID employeeId;
    private String employeeName;
    private String title;
    private String description;
    private LocalDate dueDate;
    private int progress;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
