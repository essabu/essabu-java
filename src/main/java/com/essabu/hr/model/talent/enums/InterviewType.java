package com.essabu.hr.model.talent.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for interview type in the HR module.
 *
 * This enum defines the complete set of valid interview type values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - PHONE: phone
 * - VIDEO: video
 * - ONSITE: onsite
 * - TECHNICAL: technical
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum InterviewType {

    PHONE("phone"),
    VIDEO("video"),
    ONSITE("onsite"),
    TECHNICAL("technical");

    private final String value;

    InterviewType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static InterviewType fromValue(String value) {
        for (InterviewType t : values()) {
            if (t.value.equals(value)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown InterviewType: " + value);
    }
}
