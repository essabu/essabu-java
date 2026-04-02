package com.essabu.hr.model.workforce.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for shift status in the HR module.
 *
 * This enum defines the complete set of valid shift status values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - SCHEDULED: scheduled
 * - IN_PROGRESS: in progress
 * - COMPLETED: completed
 * - CANCELLED: cancelled
 * - SWAPPED: swapped
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum ShiftStatus {

    SCHEDULED("scheduled"),
    IN_PROGRESS("in_progress"),
    COMPLETED("completed"),
    CANCELLED("cancelled"),
    SWAPPED("swapped");

    private final String value;

    ShiftStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static ShiftStatus fromValue(String value) {
        for (ShiftStatus s : values()) {
            if (s.value.equals(value)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown ShiftStatus: " + value);
    }
}
