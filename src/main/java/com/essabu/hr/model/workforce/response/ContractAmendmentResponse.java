package com.essabu.hr.model.workforce.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a contract amendment returned by the Essabu HR API.
 *
 * Contains all contract amendment information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the contract amendment resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - contractId: contract id
 * - description: description
 * - effectiveDate: effective date
 * - changes: changes
 * - createdAt: created at
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
    private String description;
    private LocalDate effectiveDate;
    private String changes;
    private LocalDateTime createdAt;
}
