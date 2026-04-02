package com.essabu.hr.model.talent.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a employee skill returned by the Essabu HR API.
 *
 * Contains all employee skill information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the employee skill resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - employeeId: employee id
 * - employeeName: employee name
 * - skillId: skill id
 * - skillName: skill name
 * - proficiencyLevel: proficiency level
 * - certificationUrl: certification url
 * - acquiredAt: acquired at
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSkillResponse {
    private UUID id;
    private UUID employeeId;
    private String employeeName;
    private UUID skillId;
    private String skillName;
    private int proficiencyLevel;
    private String certificationUrl;
    private LocalDateTime acquiredAt;
    private LocalDateTime createdAt;
}
