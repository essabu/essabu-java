package com.essabu.hr.model.compensation.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Response payload representing a expense line returned by the Essabu HR API.
 *
 * Contains all expense line information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the expense line resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - expenseReportId: expense report id
 * - category: category
 * - description: description
 * - amount: amount
 * - currency: currency
 * - date: date
 * - receiptUrl: receipt url
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseLineResponse {
    private UUID id;
    private UUID expenseReportId;
    private String category;
    private String description;
    private BigDecimal amount;
    private String currency;
    private LocalDate date;
    private String receiptUrl;
}
