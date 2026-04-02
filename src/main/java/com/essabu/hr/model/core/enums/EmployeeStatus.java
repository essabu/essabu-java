package com.essabu.hr.model.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for employee status in the HR module.
 *
 * This enum defines the complete set of valid employee status values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - ACTIVE: active
 * - INACTIVE: inactive
 * - TERMINATED: terminated
 * - ON_LEAVE: on leave
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum EmployeeStatus {

    ACTIVE("active"),
    INACTIVE("inactive"),
    TERMINATED("terminated"),
    ON_LEAVE("on_leave");

    private final String value;

    EmployeeStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static EmployeeStatus fromValue(String value) {
        for (EmployeeStatus status : values()) {
            if (status.value.equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown EmployeeStatus: " + value);
    }
}
