package com.essabu.einvoice.model.invoice.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a government submission returned by the Essabu E-Invoice API.
 *
 * Contains all government submission information returned by the E-Invoice REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the government submission resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - normalizedInvoiceId: normalized invoice id
 * - governmentSystem: government system
 * - governmentSystemLabel: government system label
 * - governmentSystemColor: government system color
 * - submissionId: submission id
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - submittedAt: submitted at
 * - responseData: response data
 * - errorMessage: error message
 * - retryCount: retry count
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GovernmentSubmissionResponse {

    private UUID id;
    private UUID companyId;
    private UUID normalizedInvoiceId;
    private String governmentSystem;
    private String governmentSystemLabel;
    private String governmentSystemColor;
    private String submissionId;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDateTime submittedAt;
    private String responseData;
    private String errorMessage;
    private int retryCount;
}
