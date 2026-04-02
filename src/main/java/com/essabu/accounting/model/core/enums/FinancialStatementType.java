package com.essabu.accounting.model.core.enums;

/**
 * Enumeration of possible values for financial statement type in the Accounting module.
 *
 * This enum defines the complete set of valid financial statement type values
 * that can be returned by or sent to the Essabu Accounting API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - TRIAL_BALANCE: trial balance
 * - BALANCE_SHEET: balance sheet
 * - INCOME_STATEMENT: income statement
 * - GENERAL_LEDGER: general ledger
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum FinancialStatementType {
    TRIAL_BALANCE, BALANCE_SHEET, INCOME_STATEMENT, GENERAL_LEDGER
}
