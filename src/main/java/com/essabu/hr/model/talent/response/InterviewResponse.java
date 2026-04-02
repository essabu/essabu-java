package com.essabu.hr.model.talent.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a interview returned by the Essabu HR API.
 *
 * Contains all interview information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the interview resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - applicationId: application id
 * - candidateName: candidate name
 * - interviewType: interview type
 * - interviewTypeLabel: interview type label
 * - interviewTypeColor: interview type color
 * - scheduledAt: scheduled at
 * - location: location
 * - interviewerId: interviewer id
 * - interviewerName: interviewer name
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - rating: rating
 * - feedback: feedback
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
public class InterviewResponse {
    private UUID id;
    private UUID applicationId;
    private String candidateName;
    private String interviewType;
    private String interviewTypeLabel;
    private String interviewTypeColor;
    private LocalDateTime scheduledAt;
    private String location;
    private UUID interviewerId;
    private String interviewerName;
    private String status;
    private String statusLabel;
    private String statusColor;
    private Integer rating;
    private String feedback;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
