package com.essabu.accounting.model.finance.request;

import com.essabu.accounting.model.finance.enums.WalletTransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Request payload for creating a wallet transaction via the Essabu Accounting API.
 *
 * This data transfer object carries the parameters required to create
 * a wallet transaction resource through the Accounting REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - walletId: wallet id
 * - companyId: company id
 * - type: type
 * - amount: amount
 * - reference: reference
 * - description: description
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateWalletTransactionRequest {
    private UUID walletId;
    private UUID companyId;
    private WalletTransactionType type;
    private long amount;
    private String reference;
    private String description;
}
