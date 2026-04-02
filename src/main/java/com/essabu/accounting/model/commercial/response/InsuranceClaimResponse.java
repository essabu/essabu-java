package com.essabu.accounting.model.commercial.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a insurance claim returned by the Essabu Accounting API.
 *
 * Contains all insurance claim information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the insurance claim resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - contractId: contract id
 * - invoiceId: invoice id
 * - amount: amount
 * - approvedAmount: approved amount
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - denialReason: denial reason
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceClaimResponse {
    private UUID id;
    private UUID companyId;
    private UUID contractId;
    private UUID invoiceId;
    private long amount;
    private long approvedAmount;
    private String status;
    private String statusLabel;
    private String statusColor;
    private String denialReason;
    private LocalDateTime createdAt;
}
