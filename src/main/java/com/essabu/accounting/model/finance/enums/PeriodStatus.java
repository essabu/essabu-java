package com.essabu.accounting.model.finance.enums;

/**
 * Enumeration of possible values for period status in the Accounting module.
 *
 * This enum defines the complete set of valid period status values
 * that can be returned by or sent to the Essabu Accounting API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - OPEN: open
 * - LOCKED: locked
 * - CLOSED: closed
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum PeriodStatus {
    OPEN, LOCKED, CLOSED
}
