package com.essabu.accounting.model.finance.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a wallet returned by the Essabu Accounting API.
 *
 * Contains all wallet information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the wallet resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - name: name
 * - type: type
 * - typeLabel: type label
 * - typeColor: type color
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - balance: balance
 * - currency: currency
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletResponse {
    private UUID id;
    private UUID companyId;
    private String name;
    private String type;
    private String typeLabel;
    private String typeColor;
    private String status;
    private String statusLabel;
    private String statusColor;
    private long balance;
    private String currency;
    private LocalDateTime createdAt;
}
