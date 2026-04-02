package com.essabu.accounting.model.transactions.enums;

/**
 * Enumeration of possible values for invoice status in the Accounting module.
 *
 * This enum defines the complete set of valid invoice status values
 * that can be returned by or sent to the Essabu Accounting API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - DRAFT: draft
 * - FINALIZED: finalized
 * - SENT: sent
 * - PARTIALLY_PAID: partially paid
 * - PAID: paid
 * - OVERDUE: overdue
 * - CANCELLED: cancelled
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum InvoiceStatus {
    DRAFT, FINALIZED, SENT, PARTIALLY_PAID, PAID, OVERDUE, CANCELLED
}
