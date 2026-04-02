package com.essabu.hr.model.admin.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Response payload representing a leave policy returned by the Essabu HR API.
 *
 * Contains all leave policy information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the leave policy resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - leaveType: leave type
 * - leaveTypeLabel: leave type label
 * - leaveTypeColor: leave type color
 * - annualAllowance: annual allowance
 * - carryOverAllowed: carry over allowed
 * - maxCarryOverDays: max carry over days
 * - requiresApproval: requires approval
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeavePolicyResponse {
    private UUID id;
    private String leaveType;
    private String leaveTypeLabel;
    private String leaveTypeColor;
    private int annualAllowance;
    private boolean carryOverAllowed;
    private int maxCarryOverDays;
    private boolean requiresApproval;
}
