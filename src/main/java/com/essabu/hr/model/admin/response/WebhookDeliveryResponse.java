package com.essabu.hr.model.admin.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a webhook delivery returned by the Essabu HR API.
 *
 * Contains all webhook delivery information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the webhook delivery resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - webhookId: webhook id
 * - eventType: event type
 * - httpStatus: http status
 * - success: success
 * - requestBody: request body
 * - responseBody: response body
 * - attempt: attempt
 * - deliveredAt: delivered at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebhookDeliveryResponse {
    private UUID id;
    private UUID webhookId;
    private String eventType;
    private int httpStatus;
    private boolean success;
    private String requestBody;
    private String responseBody;
    private int attempt;
    private LocalDateTime deliveredAt;
}
