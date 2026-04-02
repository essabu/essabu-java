package com.essabu.hr.model.talent.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a onboarding task returned by the Essabu HR API.
 *
 * Contains all onboarding task information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the onboarding task resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - onboardingPlanId: onboarding plan id
 * - title: title
 * - description: description
 * - category: category
 * - categoryLabel: category label
 * - dueDate: due date
 * - assigneeId: assignee id
 * - assigneeName: assignee name
 * - completed: completed
 * - completedAt: completed at
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OnboardingTaskResponse {
    private UUID id;
    private UUID onboardingPlanId;
    private String title;
    private String description;
    private String category;
    private String categoryLabel;
    private LocalDate dueDate;
    private UUID assigneeId;
    private String assigneeName;
    private boolean completed;
    private LocalDateTime completedAt;
    private LocalDateTime createdAt;
}
