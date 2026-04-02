package com.essabu.hr.model.workforce.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Response payload representing a leave balance returned by the Essabu HR API.
 *
 * Contains all leave balance information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the leave balance resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - employeeId: employee id
 * - leaveType: leave type
 * - leaveTypeLabel: leave type label
 * - leaveTypeColor: leave type color
 * - totalDays: total days
 * - usedDays: used days
 * - remainingDays: remaining days
 * - year: year
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeaveBalanceResponse {
    private UUID employeeId;
    private String leaveType;
    private String leaveTypeLabel;
    private String leaveTypeColor;
    private int totalDays;
    private int usedDays;
    private int remainingDays;
    private int year;
}
