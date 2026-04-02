package com.essabu.hr.model.talent.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a gap analysis returned by the Essabu HR API.
 *
 * Contains all gap analysis information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the gap analysis resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - positionId: position id
 * - positionName: position name
 * - employeeId: employee id
 * - employeeName: employee name
 * - gaps: gaps
 * - matchPercentage: match percentage
 * - skillId: skill id
 * - skillName: skill name
 * - requiredLevel: required level
 * - currentLevel: current level
 * - gap: gap
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapAnalysisResponse {
    private UUID positionId;
    private String positionName;
    private UUID employeeId;
    private String employeeName;
    private List<SkillGap> gaps;
    private int matchPercentage;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SkillGap {
        private UUID skillId;
        private String skillName;
        private int requiredLevel;
        private int currentLevel;
        private int gap;
    }
}
