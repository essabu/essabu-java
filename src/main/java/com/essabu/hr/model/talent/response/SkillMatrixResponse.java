package com.essabu.hr.model.talent.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a skill matrix returned by the Essabu HR API.
 *
 * Contains all skill matrix information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the skill matrix resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - departmentId: department id
 * - departmentName: department name
 * - skills: skills
 * - employees: employees
 * - employeeId: employee id
 * - employeeName: employee name
 * - proficiencyLevels: proficiency levels
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillMatrixResponse {
    private UUID departmentId;
    private String departmentName;
    private List<String> skills;
    private List<EmployeeSkillRow> employees;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EmployeeSkillRow {
        private UUID employeeId;
        private String employeeName;
        private List<Integer> proficiencyLevels;
    }
}
