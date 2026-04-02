package com.essabu.hr.model.talent.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a application returned by the Essabu HR API.
 *
 * Contains all application information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the application resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - jobPostingId: job posting id
 * - jobTitle: job title
 * - candidateName: candidate name
 * - candidateEmail: candidate email
 * - candidatePhone: candidate phone
 * - resumeUrl: resume url
 * - coverLetter: cover letter
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - currentStage: current stage
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
public class ApplicationResponse {
    private UUID id;
    private UUID jobPostingId;
    private String jobTitle;
    private String candidateName;
    private String candidateEmail;
    private String candidatePhone;
    private String resumeUrl;
    private String coverLetter;
    private String status;
    private String statusLabel;
    private String statusColor;
    private String currentStage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
