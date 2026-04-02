package com.essabu.hr.model.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for gender in the HR module.
 *
 * This enum defines the complete set of valid gender values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - MALE: male
 * - FEMALE: female
 * - OTHER: other
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum Gender {

    MALE("male"),
    FEMALE("female"),
    OTHER("other");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Gender fromValue(String value) {
        for (Gender g : values()) {
            if (g.value.equals(value)) {
                return g;
            }
        }
        throw new IllegalArgumentException("Unknown Gender: " + value);
    }
}
