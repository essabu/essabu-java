package com.essabu.accounting.model.commercial.enums;

/**
 * Enumeration of possible values for insurance contract status in the Accounting module.
 *
 * This enum defines the complete set of valid insurance contract status values
 * that can be returned by or sent to the Essabu Accounting API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - ACTIVE: active
 * - EXPIRED: expired
 * - SUSPENDED: suspended
 * - CANCELLED: cancelled
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum InsuranceContractStatus {
    ACTIVE, EXPIRED, SUSPENDED, CANCELLED
}
