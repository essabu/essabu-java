package com.essabu.accounting.model.transactions.enums;

/**
 * Enumeration of possible values for invoice type in the Accounting module.
 *
 * This enum defines the complete set of valid invoice type values
 * that can be returned by or sent to the Essabu Accounting API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - STANDARD: standard
 * - PROFORMA: proforma
 * - RECURRING: recurring
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum InvoiceType {
    STANDARD, PROFORMA, RECURRING
}
