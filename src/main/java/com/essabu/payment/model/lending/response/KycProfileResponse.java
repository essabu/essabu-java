package com.essabu.payment.model.lending.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a kyc profile returned by the Essabu Payment API.
 *
 * Contains all kyc profile information returned by the Payment REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the kyc profile resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - customerId: customer id
 * - level: level
 * - levelLabel: level label
 * - levelColor: level color
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - verifiedAt: verified at
 * - expiresAt: expires at
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KycProfileResponse {

    private UUID id;
    private UUID companyId;
    private UUID customerId;
    private String level;
    private String levelLabel;
    private String levelColor;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDateTime verifiedAt;
    private LocalDateTime expiresAt;
    private LocalDateTime createdAt;
}
