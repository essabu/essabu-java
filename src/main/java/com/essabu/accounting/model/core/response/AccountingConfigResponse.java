package com.essabu.accounting.model.core.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Response payload representing a accounting config returned by the Essabu Accounting API.
 *
 * Contains all accounting config information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the accounting config resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - accountingStandard: accounting standard
 * - accountingStandardLabel: accounting standard label
 * - accountingStandardColor: accounting standard color
 * - defaultCurrency: default currency
 * - fiscalYearStartMonth: fiscal year start month
 * - autoPostEntries: auto post entries
 * - defaultJournalId: default journal id
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountingConfigResponse {
    private UUID id;
    private UUID companyId;
    private String accountingStandard;
    private String accountingStandardLabel;
    private String accountingStandardColor;
    private String defaultCurrency;
    private int fiscalYearStartMonth;
    private boolean autoPostEntries;
    private UUID defaultJournalId;
}
