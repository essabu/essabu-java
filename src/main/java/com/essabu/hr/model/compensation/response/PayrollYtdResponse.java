package com.essabu.hr.model.compensation.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Response payload representing a payroll ytd returned by the Essabu HR API.
 *
 * Contains all payroll ytd information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the payroll ytd resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - employeeId: employee id
 * - year: year
 * - totalGross: total gross
 * - totalNet: total net
 * - totalDeductions: total deductions
 * - totalTaxes: total taxes
 * - currency: currency
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayrollYtdResponse {
    private UUID employeeId;
    private int year;
    private BigDecimal totalGross;
    private BigDecimal totalNet;
    private BigDecimal totalDeductions;
    private BigDecimal totalTaxes;
    private String currency;
}
