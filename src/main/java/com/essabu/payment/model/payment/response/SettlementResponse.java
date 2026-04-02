package com.essabu.payment.model.payment.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a settlement returned by the Essabu Payment API.
 *
 * Contains all settlement information returned by the Payment REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the settlement resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - reference: reference
 * - grossAmount: gross amount
 * - feesAmount: fees amount
 * - refundsAmount: refunds amount
 * - netAmount: net amount
 * - currency: currency
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - transactionCount: transaction count
 * - periodStart: period start
 * - periodEnd: period end
 * - settledAt: settled at
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SettlementResponse {

    private UUID id;
    private UUID companyId;
    private String reference;
    private BigDecimal grossAmount;
    private BigDecimal feesAmount;
    private BigDecimal refundsAmount;
    private BigDecimal netAmount;
    private String currency;
    private String status;
    private String statusLabel;
    private String statusColor;
    private int transactionCount;
    private LocalDateTime periodStart;
    private LocalDateTime periodEnd;
    private LocalDateTime settledAt;
    private LocalDateTime createdAt;
}
