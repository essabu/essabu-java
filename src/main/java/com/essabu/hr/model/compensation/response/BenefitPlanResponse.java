package com.essabu.hr.model.compensation.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a benefit plan returned by the Essabu HR API.
 *
 * Contains all benefit plan information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the benefit plan resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - name: name
 * - description: description
 * - benefitType: benefit type
 * - benefitTypeLabel: benefit type label
 * - benefitTypeColor: benefit type color
 * - employerContribution: employer contribution
 * - employeeContribution: employee contribution
 * - currency: currency
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - enrolledCount: enrolled count
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
public class BenefitPlanResponse {
    private UUID id;
    private String name;
    private String description;
    private String benefitType;
    private String benefitTypeLabel;
    private String benefitTypeColor;
    private BigDecimal employerContribution;
    private BigDecimal employeeContribution;
    private String currency;
    private String status;
    private String statusLabel;
    private String statusColor;
    private int enrolledCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
