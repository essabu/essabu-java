package com.essabu.hr.model.workforce.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Response payload representing a attendance summary returned by the Essabu HR API.
 *
 * Contains all attendance summary information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the attendance summary resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - employeeId: employee id
 * - month: month
 * - totalDays: total days
 * - presentDays: present days
 * - absentDays: absent days
 * - lateDays: late days
 * - totalHoursWorked: total hours worked
 * - averageHoursPerDay: average hours per day
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceSummaryResponse {
    private UUID employeeId;
    private String month;
    private int totalDays;
    private int presentDays;
    private int absentDays;
    private int lateDays;
    private double totalHoursWorked;
    private double averageHoursPerDay;
}
