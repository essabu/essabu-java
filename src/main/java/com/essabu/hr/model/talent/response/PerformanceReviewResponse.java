package com.essabu.hr.model.talent.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a performance review returned by the Essabu HR API.
 *
 * Contains all performance review information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the performance review resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - reviewCycleId: review cycle id
 * - employeeId: employee id
 * - employeeName: employee name
 * - reviewerId: reviewer id
 * - reviewerName: reviewer name
 * - overallRating: overall rating
 * - strengths: strengths
 * - areasForImprovement: areas for improvement
 * - comments: comments
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - submittedAt: submitted at
 * - acknowledgedAt: acknowledged at
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
public class PerformanceReviewResponse {
    private UUID id;
    private UUID reviewCycleId;
    private UUID employeeId;
    private String employeeName;
    private UUID reviewerId;
    private String reviewerName;
    private Integer overallRating;
    private String strengths;
    private String areasForImprovement;
    private String comments;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDateTime submittedAt;
    private LocalDateTime acknowledgedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
