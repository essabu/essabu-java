package com.essabu.hr.model.admin.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Response payload representing a training compliance returned by the Essabu HR API.
 *
 * Contains all training compliance information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the training compliance resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - overallComplianceRate: overall compliance rate
 * - totalRequired: total required
 * - totalCompleted: total completed
 * - totalExpired: total expired
 * - byTraining: by training
 * - trainingTitle: training title
 * - required: required
 * - completed: completed
 * - expired: expired
 * - complianceRate: compliance rate
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingComplianceResponse {
    private double overallComplianceRate;
    private int totalRequired;
    private int totalCompleted;
    private int totalExpired;
    private List<ComplianceByTraining> byTraining;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ComplianceByTraining {
        private String trainingTitle;
        private int required;
        private int completed;
        private int expired;
        private double complianceRate;
    }
}
