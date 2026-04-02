package com.essabu.payment.model.subscription.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a usage record returned by the Essabu Payment API.
 *
 * Contains all usage record information returned by the Payment REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the usage record resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - metric: metric
 * - metricLabel: metric label
 * - quantity: quantity
 * - recordedAt: recorded at
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsageRecordResponse {

    private UUID id;
    private UUID companyId;
    private String metric;
    private String metricLabel;
    private Long quantity;
    private LocalDateTime recordedAt;
    private LocalDateTime createdAt;
}
