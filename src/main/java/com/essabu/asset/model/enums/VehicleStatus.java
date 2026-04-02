package com.essabu.asset.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for vehicle status in the Asset module.
 *
 * This enum defines the complete set of valid vehicle status values
 * that can be returned by or sent to the Essabu Asset API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - AVAILABLE: the vehicle is available and ready for assignment
 * - IN_USE: the vehicle is currently assigned and being used
 * - IN_MAINTENANCE: the vehicle is undergoing maintenance or repair
 * - OUT_OF_SERVICE: the vehicle is permanently or temporarily removed from the fleet
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum VehicleStatus {
    AVAILABLE("available"), IN_USE("in_use"), IN_MAINTENANCE("in_maintenance"),
    OUT_OF_SERVICE("out_of_service");
    private final String value;
    VehicleStatus(String value) { this.value = value; }
    @JsonValue public String getValue() { return value; }
}
