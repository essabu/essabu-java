package com.essabu.accounting.model.inventory.enums;

/**
 * Enumeration of possible values for movement type in the Accounting module.
 *
 * This enum defines the complete set of valid movement type values
 * that can be returned by or sent to the Essabu Accounting API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - RECEIPT: receipt
 * - ISSUE: issue
 * - RETURN: return
 * - ADJUSTMENT: adjustment
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum MovementType {
    RECEIPT, ISSUE, RETURN, ADJUSTMENT
}
