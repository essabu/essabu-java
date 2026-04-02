package com.essabu.accounting.model.core.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Response payload representing a account balance returned by the Essabu Accounting API.
 *
 * Contains all account balance information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the account balance resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - accountId: account id
 * - periodId: period id
 * - debitBalance: debit balance
 * - creditBalance: credit balance
 * - netBalance: net balance
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountBalanceResponse {
    private UUID id;
    private UUID companyId;
    private UUID accountId;
    private UUID periodId;
    private long debitBalance;
    private long creditBalance;
    private long netBalance;
}
