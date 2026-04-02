package com.essabu.accounting.model.transactions.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a payment returned by the Essabu Accounting API.
 *
 * Contains all payment information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the payment resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - invoiceId: invoice id
 * - amount: amount
 * - currency: currency
 * - paymentDate: payment date
 * - method: method
 * - methodLabel: method label
 * - methodColor: method color
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - reference: reference
 * - notes: notes
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {
    private UUID id;
    private UUID companyId;
    private UUID invoiceId;
    private long amount;
    private String currency;
    private LocalDate paymentDate;
    private String method;
    private String methodLabel;
    private String methodColor;
    private String status;
    private String statusLabel;
    private String statusColor;
    private String reference;
    private String notes;
    private LocalDateTime createdAt;
}
