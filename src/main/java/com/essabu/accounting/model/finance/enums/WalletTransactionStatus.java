package com.essabu.accounting.model.finance.enums;

/**
 * Enumeration of possible values for wallet transaction status in the Accounting module.
 *
 * This enum defines the complete set of valid wallet transaction status values
 * that can be returned by or sent to the Essabu Accounting API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - PENDING: pending
 * - COMPLETED: completed
 * - FAILED: failed
 * - REVERSED: reversed
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum WalletTransactionStatus {
    PENDING, COMPLETED, FAILED, REVERSED
}
