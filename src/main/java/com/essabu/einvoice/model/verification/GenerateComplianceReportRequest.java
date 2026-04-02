package com.essabu.einvoice.model.verification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Generate Compliance Report Request class in the Essabu E-Invoice SDK.
 *
 * This class is part of the Essabu E-Invoice SDK and provides
 * functionality related to generate compliance report request operations. It is used internally
 * by the SDK to support the E-Invoice API integration and may also be
 * referenced by consuming applications when working with E-Invoice
 * resources and operations.
 *
 * Fields:
 * - companyId: company id
 * - periodStart: period start
 * - periodEnd: period end
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenerateComplianceReportRequest {

    private UUID companyId;
    private LocalDate periodStart;
    private LocalDate periodEnd;
}
