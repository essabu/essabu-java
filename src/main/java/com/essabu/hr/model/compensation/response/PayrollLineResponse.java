package com.essabu.hr.model.compensation.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Response payload representing a payroll line returned by the Essabu HR API.
 *
 * Contains all payroll line information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the payroll line resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - payrollId: payroll id
 * - employeeId: employee id
 * - employeeName: employee name
 * - lineType: line type
 * - lineTypeLabel: line type label
 * - lineTypeColor: line type color
 * - description: description
 * - amount: amount
 * - grossSalary: gross salary
 * - netSalary: net salary
 * - deductions: deductions
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayrollLineResponse {
    private UUID id;
    private UUID payrollId;
    private UUID employeeId;
    private String employeeName;
    private String lineType;
    private String lineTypeLabel;
    private String lineTypeColor;
    private String description;
    private BigDecimal amount;
    private BigDecimal grossSalary;
    private BigDecimal netSalary;
    private BigDecimal deductions;
}
