package com.essabu.accounting.model.inventory.enums;

/**
 * Enumeration of possible values for purchase order status in the Accounting module.
 *
 * This enum defines the complete set of valid purchase order status values
 * that can be returned by or sent to the Essabu Accounting API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - DRAFT: draft
 * - SUBMITTED: submitted
 * - APPROVED: approved
 * - ORDERED: ordered
 * - PARTIALLY_RECEIVED: partially received
 * - RECEIVED: received
 * - CANCELLED: cancelled
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum PurchaseOrderStatus {
    DRAFT, SUBMITTED, APPROVED, ORDERED, PARTIALLY_RECEIVED, RECEIVED, CANCELLED
}
