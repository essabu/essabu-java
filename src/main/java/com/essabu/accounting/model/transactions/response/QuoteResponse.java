package com.essabu.accounting.model.transactions.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a quote returned by the Essabu Accounting API.
 *
 * Contains all quote information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the quote resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - customerId: customer id
 * - customerName: customer name
 * - quoteNumber: quote number
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - issueDate: issue date
 * - validUntil: valid until
 * - subtotal: subtotal
 * - taxAmount: tax amount
 * - totalAmount: total amount
 * - currency: currency
 * - notes: notes
 * - lines: lines
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuoteResponse {
    private UUID id;
    private UUID companyId;
    private UUID customerId;
    private String customerName;
    private String quoteNumber;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDate issueDate;
    private LocalDate validUntil;
    private long subtotal;
    private long taxAmount;
    private long totalAmount;
    private String currency;
    private String notes;
    private List<QuoteLineResponse> lines;
    private LocalDateTime createdAt;
}
