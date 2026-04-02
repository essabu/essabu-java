package com.essabu.payment.model.payment.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a payout returned by the Essabu Payment API.
 *
 * Contains all payout information returned by the Payment REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the payout resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - amount: amount
 * - currency: currency
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - bankAccountNumber: bank account number
 * - reference: reference
 * - scheduledAt: scheduled at
 * - processedAt: processed at
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayoutResponse {

    private UUID id;
    private UUID companyId;
    private BigDecimal amount;
    private String currency;
    private String status;
    private String statusLabel;
    private String statusColor;
    private String bankAccountNumber;
    private String reference;
    private LocalDateTime scheduledAt;
    private LocalDateTime processedAt;
    private LocalDateTime createdAt;
}
