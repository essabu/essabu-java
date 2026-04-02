package com.essabu.accounting.model.core.request;

import com.essabu.accounting.model.core.enums.AccountingStandard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Request payload for creating a accounting config via the Essabu Accounting API.
 *
 * This data transfer object carries the parameters required to create
 * a accounting config resource through the Accounting REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - accountingStandard: accounting standard
 * - defaultCurrency: default currency
 * - fiscalYearStartMonth: fiscal year start month
 * - autoPostEntries: auto post entries
 * - defaultJournalId: default journal id
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountingConfigRequest {
    private UUID companyId;
    private AccountingStandard accountingStandard;
    private String defaultCurrency;
    private int fiscalYearStartMonth;
    private boolean autoPostEntries;
    private UUID defaultJournalId;
}
