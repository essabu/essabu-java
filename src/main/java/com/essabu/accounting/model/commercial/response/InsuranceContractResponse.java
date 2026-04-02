package com.essabu.accounting.model.commercial.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a insurance contract returned by the Essabu Accounting API.
 *
 * Contains all insurance contract information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the insurance contract resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - partnerId: partner id
 * - customerId: customer id
 * - policyNumber: policy number
 * - coveragePercentage: coverage percentage
 * - startDate: start date
 * - endDate: end date
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceContractResponse {
    private UUID id;
    private UUID companyId;
    private UUID partnerId;
    private UUID customerId;
    private String policyNumber;
    private BigDecimal coveragePercentage;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDateTime createdAt;
}
