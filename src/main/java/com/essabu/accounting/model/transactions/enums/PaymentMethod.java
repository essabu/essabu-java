package com.essabu.accounting.model.transactions.enums;

/**
 * Enumeration of possible values for payment method in the Accounting module.
 *
 * This enum defines the complete set of valid payment method values
 * that can be returned by or sent to the Essabu Accounting API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - CASH: cash
 * - CHECK: check
 * - BANK_TRANSFER: bank transfer
 * - CARD: card
 * - MOBILE_MONEY: mobile money
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum PaymentMethod {
    CASH, CHECK, BANK_TRANSFER, CARD, MOBILE_MONEY
}
