package com.essabu.hr.model.admin.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Response payload representing a absenteeism returned by the Essabu HR API.
 *
 * Contains all absenteeism information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the absenteeism resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - month: month
 * - rate: rate
 * - totalAbsentDays: total absent days
 * - byDepartment: by department
 * - departmentName: department name
 * - rate: rate
 * - absentDays: absent days
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbsenteeismResponse {
    private String month;
    private double rate;
    private int totalAbsentDays;
    private List<AbsenteeismByDepartment> byDepartment;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AbsenteeismByDepartment {
        private String departmentName;
        private double rate;
        private int absentDays;
    }
}
