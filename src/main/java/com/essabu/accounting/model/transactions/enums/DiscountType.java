package com.essabu.accounting.model.transactions.enums;

/**
 * Enumeration of possible values for discount type in the Accounting module.
 *
 * This enum defines the complete set of valid discount type values
 * that can be returned by or sent to the Essabu Accounting API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - NONE: none
 * - PERCENTAGE: percentage
 * - FIXED_AMOUNT: fixed amount
 * - INSURANCE_COVERED: insurance covered
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum DiscountType {
    NONE, PERCENTAGE, FIXED_AMOUNT, INSURANCE_COVERED
}
