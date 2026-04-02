package com.essabu.hr.model.workforce.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a contract returned by the Essabu HR API.
 *
 * Contains all contract information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the contract resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - employeeId: employee id
 * - employeeName: employee name
 * - contractType: contract type
 * - contractTypeLabel: contract type label
 * - contractTypeColor: contract type color
 * - startDate: start date
 * - endDate: end date
 * - salary: salary
 * - currency: currency
 * - terms: terms
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
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
public class ContractResponse {
    private UUID id;
    private UUID employeeId;
    private String employeeName;
    private String contractType;
    private String contractTypeLabel;
    private String contractTypeColor;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal salary;
    private String currency;
    private String terms;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
