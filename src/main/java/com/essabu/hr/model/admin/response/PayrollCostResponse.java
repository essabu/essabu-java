package com.essabu.hr.model.admin.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * Response payload representing a payroll cost returned by the Essabu HR API.
 *
 * Contains all payroll cost information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the payroll cost resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - year: year
 * - totalCost: total cost
 * - currency: currency
 * - monthly: monthly
 * - month: month
 * - gross: gross
 * - net: net
 * - deductions: deductions
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayrollCostResponse {
    private int year;
    private BigDecimal totalCost;
    private String currency;
    private List<MonthlyCost> monthly;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MonthlyCost {
        private String month;
        private BigDecimal gross;
        private BigDecimal net;
        private BigDecimal deductions;
    }
}
