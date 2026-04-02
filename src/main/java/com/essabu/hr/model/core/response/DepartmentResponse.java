package com.essabu.hr.model.core.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a department returned by the Essabu HR API.
 *
 * Contains all department information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the department resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - name: name
 * - description: description
 * - parentId: parent id
 * - parentName: parent name
 * - managerId: manager id
 * - managerName: manager name
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
public class DepartmentResponse {
    private UUID id;
    private String name;
    private String description;
    private UUID parentId;
    private String parentName;
    private UUID managerId;
    private String managerName;
    private int employeeCount;
    private String slug;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
