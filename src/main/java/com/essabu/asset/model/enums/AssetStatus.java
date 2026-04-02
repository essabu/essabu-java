package com.essabu.asset.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for asset status in the Asset module.
 *
 * This enum defines the complete set of valid asset status values
 * that can be returned by or sent to the Essabu Asset API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - ACTIVE: the asset is currently in active use within the organization
 * - IN_MAINTENANCE: the asset is undergoing maintenance or repair work
 * - DISPOSED: the asset has been disposed of or sold
 * - RETIRED: the asset has been retired from service permanently
 * - LOST: the asset has been reported as lost or missing
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum AssetStatus {
    ACTIVE("active"), IN_MAINTENANCE("in_maintenance"), DISPOSED("disposed"),
    RETIRED("retired"), LOST("lost");
    private final String value;
    AssetStatus(String value) { this.value = value; }
    @JsonValue public String getValue() { return value; }
}
