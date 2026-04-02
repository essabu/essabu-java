package com.essabu.accounting.model.transactions.enums;

/**
 * Enumeration of possible values for credit note reason in the Accounting module.
 *
 * This enum defines the complete set of valid credit note reason values
 * that can be returned by or sent to the Essabu Accounting API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - RETURN: return
 * - DISCOUNT: discount
 * - ERROR: error
 * - CANCELLATION: cancellation
 * - OTHER: other
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum CreditNoteReason {
    RETURN, DISCOUNT, ERROR, CANCELLATION, OTHER
}
