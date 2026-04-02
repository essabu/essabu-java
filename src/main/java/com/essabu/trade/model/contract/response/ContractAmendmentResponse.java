package com.essabu.trade.model.contract.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a contract amendment returned by the Essabu Trade API.
 *
 * Contains all contract amendment information returned by the Trade REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the contract amendment resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - contractId: contract id
 * - title: title
 * - description: description
 * - changes: changes
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
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
public class ContractAmendmentResponse {
    private UUID id;
    private UUID contractId;
    private String title;
    private String description;
    private String changes;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
