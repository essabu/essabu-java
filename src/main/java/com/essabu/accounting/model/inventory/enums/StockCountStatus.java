package com.essabu.accounting.model.inventory.enums;

/**
 * Enumeration of possible values for stock count status in the Accounting module.
 *
 * This enum defines the complete set of valid stock count status values
 * that can be returned by or sent to the Essabu Accounting API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - PLANNED: planned
 * - IN_PROGRESS: in progress
 * - COMPLETED: completed
 * - CANCELLED: cancelled
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum StockCountStatus {
    PLANNED, IN_PROGRESS, COMPLETED, CANCELLED
}
