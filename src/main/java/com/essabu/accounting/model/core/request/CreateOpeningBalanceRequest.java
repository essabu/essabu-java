package com.essabu.accounting.model.core.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Request payload for creating a opening balance via the Essabu Accounting API.
 *
 * This data transfer object carries the parameters required to create
 * a opening balance resource through the Accounting REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - accountId: account id
 * - fiscalYearId: fiscal year id
 * - debitAmount: debit amount
 * - creditAmount: credit amount
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOpeningBalanceRequest {
    private UUID companyId;
    private UUID accountId;
    private UUID fiscalYearId;
    private long debitAmount;
    private long creditAmount;
}
