package com.essabu.payment.model.lending.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a financial account returned by the Essabu Payment API.
 *
 * Contains all financial account information returned by the Payment REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the financial account resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - customerId: customer id
 * - accountNumber: account number
 * - type: type
 * - typeLabel: type label
 * - typeColor: type color
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - balance: balance
 * - currency: currency
 * - interestRate: interest rate
 * - openedAt: opened at
 * - closedAt: closed at
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinancialAccountResponse {

    private UUID id;
    private UUID companyId;
    private UUID customerId;
    private String accountNumber;
    private String type;
    private String typeLabel;
    private String typeColor;
    private String status;
    private String statusLabel;
    private String statusColor;
    private BigDecimal balance;
    private String currency;
    private BigDecimal interestRate;
    private LocalDateTime openedAt;
    private LocalDateTime closedAt;
    private LocalDateTime createdAt;
}
