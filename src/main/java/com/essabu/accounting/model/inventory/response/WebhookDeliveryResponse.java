package com.essabu.accounting.model.inventory.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a webhook delivery returned by the Essabu Accounting API.
 *
 * Contains all webhook delivery information returned by the Accounting REST API
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
 * - statusCode: status code
 * - success: success
 * - deliveredAt: delivered at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebhookDeliveryResponse {
    private UUID id;
    private UUID webhookId;
    private String eventType;
    private int statusCode;
    private boolean success;
    private LocalDateTime deliveredAt;
}
