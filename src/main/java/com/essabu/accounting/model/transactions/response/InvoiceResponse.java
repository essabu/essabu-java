package com.essabu.accounting.model.transactions.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a invoice returned by the Essabu Accounting API.
 *
 * Contains all invoice information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the invoice resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - customerId: customer id
 * - customerName: customer name
 * - invoiceNumber: invoice number
 * - type: type
 * - typeLabel: type label
 * - typeColor: type color
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - issueDate: issue date
 * - dueDate: due date
 * - subtotal: subtotal
 * - taxAmount: tax amount
 * - totalAmount: total amount
 * - paidAmount: paid amount
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
public class InvoiceResponse {
    private UUID id;
    private UUID companyId;
    private UUID customerId;
    private String customerName;
    private String invoiceNumber;
    private String type;
    private String typeLabel;
    private String typeColor;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private long subtotal;
    private long taxAmount;
    private long totalAmount;
    private long paidAmount;
    private String currency;
    private String notes;
    private List<InvoiceLineResponse> lines;
    private LocalDateTime createdAt;
}
