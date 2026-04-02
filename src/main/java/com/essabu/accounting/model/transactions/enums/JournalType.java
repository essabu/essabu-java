package com.essabu.accounting.model.transactions.enums;

/**
 * Enumeration of possible values for journal type in the Accounting module.
 *
 * This enum defines the complete set of valid journal type values
 * that can be returned by or sent to the Essabu Accounting API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - GENERAL: general
 * - SALES: sales
 * - PURCHASE: purchase
 * - BANK: bank
 * - CASH: cash
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum JournalType {
    GENERAL, SALES, PURCHASE, BANK, CASH
}
