package com.essabu.hr.model.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for marital status in the HR module.
 *
 * This enum defines the complete set of valid marital status values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - SINGLE: single
 * - MARRIED: married
 * - DIVORCED: divorced
 * - WIDOWED: widowed
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum MaritalStatus {

    SINGLE("single"),
    MARRIED("married"),
    DIVORCED("divorced"),
    WIDOWED("widowed");

    private final String value;

    MaritalStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static MaritalStatus fromValue(String value) {
        for (MaritalStatus s : values()) {
            if (s.value.equals(value)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown MaritalStatus: " + value);
    }
}
