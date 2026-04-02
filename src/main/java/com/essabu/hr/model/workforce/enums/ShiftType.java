package com.essabu.hr.model.workforce.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for shift type in the HR module.
 *
 * This enum defines the complete set of valid shift type values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - MORNING: morning
 * - AFTERNOON: afternoon
 * - NIGHT: night
 * - ON_CALL: on call
 * - SPLIT: split
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum ShiftType {

    MORNING("morning"),
    AFTERNOON("afternoon"),
    NIGHT("night"),
    ON_CALL("on_call"),
    SPLIT("split");

    private final String value;

    ShiftType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static ShiftType fromValue(String value) {
        for (ShiftType t : values()) {
            if (t.value.equals(value)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown ShiftType: " + value);
    }
}
