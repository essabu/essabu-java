package com.essabu.accounting.model.transactions.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a recurring invoice returned by the Essabu Accounting API.
 *
 * Contains all recurring invoice information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the recurring invoice resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - customerId: customer id
 * - customerName: customer name
 * - currency: currency
 * - frequency: frequency
 * - startDate: start date
 * - endDate: end date
 * - dayOfMonth: day of month
 * - active: active
 * - notes: notes
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecurringInvoiceResponse {
    private UUID id;
    private UUID companyId;
    private UUID customerId;
    private String customerName;
    private String currency;
    private String frequency;
    private LocalDate startDate;
    private LocalDate endDate;
    private int dayOfMonth;
    private boolean active;
    private String notes;
    private LocalDateTime createdAt;
}
