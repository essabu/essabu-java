package com.essabu.hr.model.core.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a org chart returned by the Essabu HR API.
 *
 * Contains all org chart information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the org chart resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - employeeId: employee id
 * - employeeName: employee name
 * - positionName: position name
 * - departmentName: department name
 * - photoUrl: photo url
 * - children: children
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrgChartResponse {
    private UUID employeeId;
    private String employeeName;
    private String positionName;
    private String departmentName;
    private String photoUrl;
    private List<OrgChartResponse> children;
}
