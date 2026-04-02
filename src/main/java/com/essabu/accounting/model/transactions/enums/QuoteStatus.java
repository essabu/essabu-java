package com.essabu.accounting.model.transactions.enums;

/**
 * Enumeration of possible values for quote status in the Accounting module.
 *
 * This enum defines the complete set of valid quote status values
 * that can be returned by or sent to the Essabu Accounting API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - DRAFT: draft
 * - SENT: sent
 * - ACCEPTED: accepted
 * - REJECTED: rejected
 * - CONVERTED: converted
 * - EXPIRED: expired
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum QuoteStatus {
    DRAFT, SENT, ACCEPTED, REJECTED, CONVERTED, EXPIRED
}
