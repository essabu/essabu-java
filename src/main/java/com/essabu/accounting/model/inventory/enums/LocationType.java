package com.essabu.accounting.model.inventory.enums;

/**
 * Enumeration of possible values for location type in the Accounting module.
 *
 * This enum defines the complete set of valid location type values
 * that can be returned by or sent to the Essabu Accounting API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - WAREHOUSE: warehouse
 * - PHARMACY: pharmacy
 * - DEPARTMENT: department
 * - OPERATING_ROOM: operating room
 * - EMERGENCY: emergency
 * - LABORATORY: laboratory
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum LocationType {
    WAREHOUSE, PHARMACY, DEPARTMENT, OPERATING_ROOM, EMERGENCY, LABORATORY
}
