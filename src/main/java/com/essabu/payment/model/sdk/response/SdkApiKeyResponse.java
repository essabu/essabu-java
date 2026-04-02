package com.essabu.payment.model.sdk.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a sdk api key returned by the Essabu Payment API.
 *
 * Contains all sdk api key information returned by the Payment REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the sdk api key resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - name: name
 * - keyPrefix: key prefix
 * - environment: environment
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - lastUsedAt: last used at
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SdkApiKeyResponse {

    private UUID id;
    private String name;
    private String keyPrefix;
    private String environment;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDateTime lastUsedAt;
    private LocalDateTime createdAt;
}
