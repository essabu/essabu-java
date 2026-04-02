package com.essabu.hr.model.talent.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a onboarding plan returned by the Essabu HR API.
 *
 * Contains all onboarding plan information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the onboarding plan resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - employeeId: employee id
 * - employeeName: employee name
 * - onboardingType: onboarding type
 * - onboardingTypeLabel: onboarding type label
 * - onboardingTypeColor: onboarding type color
 * - startDate: start date
 * - endDate: end date
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - progress: progress
 * - tasks: tasks
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
public class OnboardingPlanResponse {
    private UUID id;
    private UUID employeeId;
    private String employeeName;
    private String onboardingType;
    private String onboardingTypeLabel;
    private String onboardingTypeColor;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private String statusLabel;
    private String statusColor;
    private int progress;
    private List<OnboardingTaskResponse> tasks;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
