package com.essabu.identity.model.management.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a api key created returned by the Essabu Identity API.
 *
 * Contains all api key created information returned by the Identity REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the api key created resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - name: name
 * - key: key
 * - prefix: prefix
 * - companyId: company id
 * - scopes: scopes
 * - expiresAt: expires at
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiKeyCreatedResponse {

    private UUID id;
    private String name;
    private String key;
    private String prefix;
    private UUID companyId;
    private List<String> scopes;
    private LocalDateTime expiresAt;
    private LocalDateTime createdAt;
}
