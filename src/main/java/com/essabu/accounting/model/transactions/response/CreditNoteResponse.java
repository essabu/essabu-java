package com.essabu.accounting.model.transactions.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a credit note returned by the Essabu Accounting API.
 *
 * Contains all credit note information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the credit note resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - invoiceId: invoice id
 * - creditNoteNumber: credit note number
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - issueDate: issue date
 * - subtotal: subtotal
 * - taxAmount: tax amount
 * - totalAmount: total amount
 * - currency: currency
 * - reason: reason
 * - lines: lines
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditNoteResponse {
    private UUID id;
    private UUID companyId;
    private UUID invoiceId;
    private String creditNoteNumber;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDate issueDate;
    private long subtotal;
    private long taxAmount;
    private long totalAmount;
    private String currency;
    private String reason;
    private List<CreditNoteLineResponse> lines;
    private LocalDateTime createdAt;
}
