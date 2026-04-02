package com.essabu.trade.model.crm.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a campaign contact returned by the Essabu Trade API.
 *
 * Contains all campaign contact information returned by the Trade REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the campaign contact resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - campaignId: campaign id
 * - contactId: contact id
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CampaignContactResponse {
    private UUID id;
    private UUID campaignId;
    private UUID contactId;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDateTime createdAt;
}
