package com.essabu.identity.model.management.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a tenant returned by the Essabu Identity API.
 *
 * Contains all tenant information returned by the Identity REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the tenant resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - name: name
 * - slug: slug
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - plan: plan
 * - createdAt: created at
 * - updatedAt: updated at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TenantResponse {

    private UUID id;
    private String name;
    private String slug;
    private String status;
    private String statusLabel;
    private String statusColor;
    private String plan;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
