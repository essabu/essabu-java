package com.essabu.accounting.model.finance.enums;

/**
 * Enumeration of possible values for wallet status in the Accounting module.
 *
 * This enum defines the complete set of valid wallet status values
 * that can be returned by or sent to the Essabu Accounting API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - ACTIVE: active
 * - FROZEN: frozen
 * - CLOSED: closed
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum WalletStatus {
    ACTIVE, FROZEN, CLOSED
}
