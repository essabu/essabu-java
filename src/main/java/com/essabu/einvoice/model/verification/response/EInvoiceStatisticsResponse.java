package com.essabu.einvoice.model.verification.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Response payload representing a e invoice statistics returned by the Essabu E-Invoice API.
 *
 * Contains all e invoice statistics information returned by the E-Invoice REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the e invoice statistics resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - totalSubmissions: total submissions
 * - acceptedCount: accepted count
 * - rejectedCount: rejected count
 * - pendingCount: pending count
 * - complianceRate: compliance rate
 * - submissionsByCountry: submissions by country
 * - submissionsByStatus: submissions by status
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EInvoiceStatisticsResponse {

    private int totalSubmissions;
    private int acceptedCount;
    private int rejectedCount;
    private int pendingCount;
    private BigDecimal complianceRate;
    private Map<String, Integer> submissionsByCountry;
    private Map<String, Integer> submissionsByStatus;
}
