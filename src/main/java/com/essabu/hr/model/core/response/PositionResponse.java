package com.essabu.hr.model.core.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a position returned by the Essabu HR API.
 *
 * Contains all position information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the position resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - title: title
 * - description: description
 * - departmentId: department id
 * - departmentName: department name
 * - level: level
 * - employeeCount: employee count
 * - slug: slug
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
public class PositionResponse {
    private UUID id;
    private String title;
    private String description;
    private UUID departmentId;
    private String departmentName;
    private String level;
    private int employeeCount;
    private String slug;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
