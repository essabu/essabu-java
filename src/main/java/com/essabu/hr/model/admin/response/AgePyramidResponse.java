package com.essabu.hr.model.admin.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Response payload representing a age pyramid returned by the Essabu HR API.
 *
 * Contains all age pyramid information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the age pyramid resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - groups: groups
 * - range: range
 * - maleCount: male count
 * - femaleCount: female count
 * - total: total
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgePyramidResponse {
    private List<AgeGroup> groups;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AgeGroup {
        private String range;
        private int maleCount;
        private int femaleCount;
        private int total;
    }
}
