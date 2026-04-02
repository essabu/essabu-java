package com.essabu.accounting.model.core.enums;

/**
 * Enumeration of possible values for account nature in the Accounting module.
 *
 * This enum defines the complete set of valid account nature values
 * that can be returned by or sent to the Essabu Accounting API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - DEBIT: debit
 * - CREDIT: credit
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum AccountNature {
    DEBIT, CREDIT
}
