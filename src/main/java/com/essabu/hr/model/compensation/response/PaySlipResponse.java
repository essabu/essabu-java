package com.essabu.hr.model.compensation.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a pay slip returned by the Essabu HR API.
 *
 * Contains all pay slip information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the pay slip resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - payrollId: payroll id
 * - employeeId: employee id
 * - employeeName: employee name
 * - period: period
 * - grossSalary: gross salary
 * - netSalary: net salary
 * - totalDeductions: total deductions
 * - currency: currency
 * - lines: lines
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaySlipResponse {
    private UUID id;
    private UUID payrollId;
    private UUID employeeId;
    private String employeeName;
    private String period;
    private BigDecimal grossSalary;
    private BigDecimal netSalary;
    private BigDecimal totalDeductions;
    private String currency;
    private List<PayrollLineResponse> lines;
}
