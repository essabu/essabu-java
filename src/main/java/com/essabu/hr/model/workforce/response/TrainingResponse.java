package com.essabu.hr.model.workforce.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a training returned by the Essabu HR API.
 *
 * Contains all training information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the training resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - employeeId: employee id
 * - employeeName: employee name
 * - title: title
 * - description: description
 * - trainingType: training type
 * - trainingTypeLabel: training type label
 * - trainingTypeColor: training type color
 * - provider: provider
 * - startDate: start date
 * - endDate: end date
 * - expiryDate: expiry date
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - certificateUrl: certificate url
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
public class TrainingResponse {
    private UUID id;
    private UUID employeeId;
    private String employeeName;
    private String title;
    private String description;
    private String trainingType;
    private String trainingTypeLabel;
    private String trainingTypeColor;
    private String provider;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate expiryDate;
    private String status;
    private String statusLabel;
    private String statusColor;
    private String certificateUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
