package com.essabu.hr.model.admin.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Response payload representing a dashboard returned by the Essabu HR API.
 *
 * Contains all dashboard information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the dashboard resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - totalEmployees: total employees
 * - activeEmployees: active employees
 * - newHiresThisMonth: new hires this month
 * - terminationsThisMonth: terminations this month
 * - turnoverRate: turnover rate
 * - pendingLeaveRequests: pending leave requests
 * - pendingExpenseReports: pending expense reports
 * - currentPayrollCost: current payroll cost
 * - averageAttendanceRate: average attendance rate
 * - openPositions: open positions
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {
    private int totalEmployees;
    private int activeEmployees;
    private int newHiresThisMonth;
    private int terminationsThisMonth;
    private double turnoverRate;
    private int pendingLeaveRequests;
    private int pendingExpenseReports;
    private BigDecimal currentPayrollCost;
    private double averageAttendanceRate;
    private int openPositions;
}
