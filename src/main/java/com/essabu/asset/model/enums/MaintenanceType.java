package com.essabu.asset.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for maintenance type in the Asset module.
 *
 * This enum defines the complete set of valid maintenance type values
 * that can be returned by or sent to the Essabu Asset API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - PREVENTIVE: scheduled maintenance performed to prevent failures before they occur
 * - CORRECTIVE: maintenance performed to fix an existing fault or malfunction
 * - PREDICTIVE: maintenance triggered by condition monitoring and data analysis
 * - EMERGENCY: unplanned urgent maintenance required due to critical failure
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum MaintenanceType {
    PREVENTIVE("preventive"), CORRECTIVE("corrective"), PREDICTIVE("predictive"),
    EMERGENCY("emergency");
    private final String value;
    MaintenanceType(String value) { this.value = value; }
    @JsonValue public String getValue() { return value; }
}
