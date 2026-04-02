package com.essabu.project.model.response;

import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;

/**
 * Response payload representing a project returned by the Essabu Project API.
 *
 * Contains all project information returned by the Project REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the project resource.
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
public class ProjectResponse {
    private String id;
    private String createdAt;
    private String updatedAt;
}
