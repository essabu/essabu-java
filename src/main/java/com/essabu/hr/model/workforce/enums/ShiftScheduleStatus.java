package com.essabu.hr.model.workforce.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for shift schedule status in the HR module.
 *
 * This enum defines the complete set of valid shift schedule status values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - DRAFT: draft
 * - APPROVED: approved
 * - PUBLISHED: published
 * - CANCELLED: cancelled
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum ShiftScheduleStatus {

    DRAFT("draft"),
    APPROVED("approved"),
    PUBLISHED("published"),
    CANCELLED("cancelled");

    private final String value;

    ShiftScheduleStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static ShiftScheduleStatus fromValue(String value) {
        for (ShiftScheduleStatus s : values()) {
            if (s.value.equals(value)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown ShiftScheduleStatus: " + value);
    }
}
