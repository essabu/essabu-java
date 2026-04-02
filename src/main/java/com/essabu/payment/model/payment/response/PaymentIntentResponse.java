package com.essabu.payment.model.payment.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

/**
 * Response payload representing a payment intent returned by the Essabu Payment API.
 *
 * Contains all payment intent information returned by the Payment REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the payment intent resource.
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
 * - paymentMethodType: payment method type
 * - paymentMethodTypeLabel: payment method type label
 * - paymentMethodTypeColor: payment method type color
 * - idempotencyKey: idempotency key
 * - description: description
 * - metadata: metadata
 * - expiresAt: expires at
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentIntentResponse {

    private UUID id;
    private UUID companyId;
    private BigDecimal amount;
    private String currency;
    private String status;
    private String statusLabel;
    private String statusColor;
    private String paymentMethodType;
    private String paymentMethodTypeLabel;
    private String paymentMethodTypeColor;
    private String idempotencyKey;
    private String description;
    private Map<String, String> metadata;
    private LocalDateTime expiresAt;
    private LocalDateTime createdAt;
}
