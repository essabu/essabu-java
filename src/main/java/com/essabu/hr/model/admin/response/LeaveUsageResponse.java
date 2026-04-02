package com.essabu.hr.model.admin.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Response payload representing a leave usage returned by the Essabu HR API.
 *
 * Contains all leave usage information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the leave usage resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - byType: by type
 * - leaveType: leave type
 * - leaveTypeLabel: leave type label
 * - totalDaysTaken: total days taken
 * - totalDaysAvailable: total days available
 * - usageRate: usage rate
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeaveUsageResponse {
    private List<LeaveTypeUsage> byType;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LeaveTypeUsage {
        private String leaveType;
        private String leaveTypeLabel;
        private int totalDaysTaken;
        private int totalDaysAvailable;
        private double usageRate;
    }
}
