package com.essabu.hr.model.workforce.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a shift swap request returned by the Essabu HR API.
 *
 * Contains all shift swap request information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the shift swap request resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - requesterId: requester id
 * - requesterName: requester name
 * - targetId: target id
 * - targetName: target name
 * - originalShiftId: original shift id
 * - targetShiftId: target shift id
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - reason: reason
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
public class ShiftSwapRequestResponse {
    private UUID id;
    private UUID requesterId;
    private String requesterName;
    private UUID targetId;
    private String targetName;
    private UUID originalShiftId;
    private UUID targetShiftId;
    private String status;
    private String statusLabel;
    private String statusColor;
    private String reason;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
