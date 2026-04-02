package com.essabu.accounting.model.inventory.enums;

/**
 * Enumeration of possible values for inventory category in the Accounting module.
 *
 * This enum defines the complete set of valid inventory category values
 * that can be returned by or sent to the Essabu Accounting API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - SUPPLIES: supplies
 * - INSTRUMENTS: instruments
 * - OFFICE: office
 * - CLEANING: cleaning
 * - EQUIPMENT: equipment
 * - FURNITURE: furniture
 * - LINEN: linen
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum InventoryCategory {
    SUPPLIES, INSTRUMENTS, OFFICE, CLEANING, EQUIPMENT, FURNITURE, LINEN
}
