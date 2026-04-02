package com.essabu.accounting.model.finance.enums;

/**
 * Enumeration of possible values for wallet transaction type in the Accounting module.
 *
 * This enum defines the complete set of valid wallet transaction type values
 * that can be returned by or sent to the Essabu Accounting API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - CREDIT: credit
 * - DEBIT: debit
 * - REFUND: refund
 * - TRANSFER: transfer
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum WalletTransactionType {
    CREDIT, DEBIT, REFUND, TRANSFER
}
