package com.essabu.accounting.model.commercial.enums;

/**
 * Enumeration of possible values for claim status in the Accounting module.
 *
 * This enum defines the complete set of valid claim status values
 * that can be returned by or sent to the Essabu Accounting API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - DRAFT: draft
 * - SUBMITTED: submitted
 * - UNDER_REVIEW: under review
 * - APPROVED: approved
 * - PARTIALLY_APPROVED: partially approved
 * - DENIED: denied
 * - APPEALED: appealed
 * - CLOSED: closed
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum ClaimStatus {
    DRAFT, SUBMITTED, UNDER_REVIEW, APPROVED, PARTIALLY_APPROVED, DENIED, APPEALED, CLOSED
}
