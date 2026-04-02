package com.essabu.hr.model.admin.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Response payload representing a turnover returned by the Essabu HR API.
 *
 * Contains all turnover information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the turnover resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - year: year
 * - annualRate: annual rate
 * - monthly: monthly
 * - month: month
 * - hires: hires
 * - terminations: terminations
 * - rate: rate
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TurnoverResponse {
    private int year;
    private double annualRate;
    private List<MonthlyTurnover> monthly;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MonthlyTurnover {
        private String month;
        private int hires;
        private int terminations;
        private double rate;
    }
}
