package com.essabu.payment.model.lending.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a kyc document returned by the Essabu Payment API.
 *
 * Contains all kyc document information returned by the Payment REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the kyc document resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - kycProfileId: kyc profile id
 * - type: type
 * - typeLabel: type label
 * - typeColor: type color
 * - documentUrl: document url
 * - verified: verified
 * - verifiedBy: verified by
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KycDocumentResponse {

    private UUID id;
    private UUID kycProfileId;
    private String type;
    private String typeLabel;
    private String typeColor;
    private String documentUrl;
    private boolean verified;
    private UUID verifiedBy;
    private LocalDateTime createdAt;
}
