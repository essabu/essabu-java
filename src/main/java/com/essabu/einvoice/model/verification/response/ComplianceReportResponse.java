package com.essabu.einvoice.model.verification.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a compliance report returned by the Essabu E-Invoice API.
 *
 * Contains all compliance report information returned by the E-Invoice REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the compliance report resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - periodStart: period start
 * - periodEnd: period end
 * - submittedCount: submitted count
 * - acceptedCount: accepted count
 * - rejectedCount: rejected count
 * - pendingCount: pending count
 * - complianceRate: compliance rate
 * - generatedAt: generated at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComplianceReportResponse {

    private UUID id;
    private UUID companyId;
    private LocalDate periodStart;
    private LocalDate periodEnd;
    private int submittedCount;
    private int acceptedCount;
    private int rejectedCount;
    private int pendingCount;
    private BigDecimal complianceRate;
    private LocalDateTime generatedAt;
}
