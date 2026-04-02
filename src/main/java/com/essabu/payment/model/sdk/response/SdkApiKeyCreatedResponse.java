package com.essabu.payment.model.sdk.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a sdk api key created returned by the Essabu Payment API.
 *
 * Contains all sdk api key created information returned by the Payment REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the sdk api key created resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - name: name
 * - rawKey: raw key
 * - keyPrefix: key prefix
 * - environment: environment
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SdkApiKeyCreatedResponse {

    private UUID id;
    private String name;
    private String rawKey;
    private String keyPrefix;
    private String environment;
    private LocalDateTime createdAt;
}
