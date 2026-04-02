package com.essabu.hr.model.talent.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a job posting returned by the Essabu HR API.
 *
 * Contains all job posting information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the job posting resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - title: title
 * - description: description
 * - departmentId: department id
 * - departmentName: department name
 * - positionId: position id
 * - positionName: position name
 * - location: location
 * - employmentType: employment type
 * - closingDate: closing date
 * - applicationCount: application count
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
public class JobPostingResponse {
    private UUID id;
    private String title;
    private String description;
    private UUID departmentId;
    private String departmentName;
    private UUID positionId;
    private String positionName;
    private String location;
    private String employmentType;
    private LocalDate closingDate;
    private int applicationCount;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
