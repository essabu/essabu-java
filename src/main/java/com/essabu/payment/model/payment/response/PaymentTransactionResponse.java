package com.essabu.payment.model.payment.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a payment transaction returned by the Essabu Payment API.
 *
 * Contains all payment transaction information returned by the Payment REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the payment transaction resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - paymentIntentId: payment intent id
 * - amount: amount
 * - fee: fee
 * - netAmount: net amount
 * - currency: currency
 * - type: type
 * - typeLabel: type label
 * - typeColor: type color
 * - status: status
 * - providerTransactionId: provider transaction id
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTransactionResponse {

    private UUID id;
    private UUID companyId;
    private UUID paymentIntentId;
    private BigDecimal amount;
    private BigDecimal fee;
    private BigDecimal netAmount;
    private String currency;
    private String type;
    private String typeLabel;
    private String typeColor;
    private String status;
    private String providerTransactionId;
    private LocalDateTime createdAt;
}
