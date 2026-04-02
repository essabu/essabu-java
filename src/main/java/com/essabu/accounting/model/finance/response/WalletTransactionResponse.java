package com.essabu.accounting.model.finance.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a wallet transaction returned by the Essabu Accounting API.
 *
 * Contains all wallet transaction information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the wallet transaction resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - walletId: wallet id
 * - companyId: company id
 * - type: type
 * - typeLabel: type label
 * - typeColor: type color
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - amount: amount
 * - balanceBefore: balance before
 * - balanceAfter: balance after
 * - reference: reference
 * - description: description
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletTransactionResponse {
    private UUID id;
    private UUID walletId;
    private UUID companyId;
    private String type;
    private String typeLabel;
    private String typeColor;
    private String status;
    private String statusLabel;
    private String statusColor;
    private long amount;
    private long balanceBefore;
    private long balanceAfter;
    private String reference;
    private String description;
    private LocalDateTime createdAt;
}
