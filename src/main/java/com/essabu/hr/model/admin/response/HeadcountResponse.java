package com.essabu.hr.model.admin.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Response payload representing a headcount returned by the Essabu HR API.
 *
 * Contains all headcount information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the headcount resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - total: total
 * - groupBy: group by
 * - groups: groups
 * - label: label
 * - count: count
 * - percentage: percentage
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeadcountResponse {
    private int total;
    private String groupBy;
    private List<HeadcountGroup> groups;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HeadcountGroup {
        private String label;
        private int count;
        private double percentage;
    }
}
