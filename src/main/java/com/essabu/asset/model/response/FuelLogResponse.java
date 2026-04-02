package com.essabu.asset.model.response;

import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;

/**
 * Response payload representing a fuel log returned by the Essabu Asset API.
 *
 * Contains all fuel log information returned by the Asset REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the fuel log resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - createdAt: created at
 * - updatedAt: updated at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class FuelLogResponse {
    private String id;
    private String createdAt;
    private String updatedAt;
}
