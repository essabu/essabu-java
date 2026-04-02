package com.essabu.payment.model.webhook.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a payment webhook returned by the Essabu Payment API.
 *
 * Contains all payment webhook information returned by the Payment REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the payment webhook resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - url: url
 * - events: events
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
public class PaymentWebhookResponse {

    private UUID id;
    private UUID companyId;
    private String url;
    private List<String> events;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDateTime createdAt;
}
