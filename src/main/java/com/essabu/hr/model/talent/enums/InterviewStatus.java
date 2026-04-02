package com.essabu.hr.model.talent.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for interview status in the HR module.
 *
 * This enum defines the complete set of valid interview status values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - SCHEDULED: scheduled
 * - COMPLETED: completed
 * - CANCELLED: cancelled
 * - NO_SHOW: no show
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum InterviewStatus {

    SCHEDULED("scheduled"),
    COMPLETED("completed"),
    CANCELLED("cancelled"),
    NO_SHOW("no_show");

    private final String value;

    InterviewStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static InterviewStatus fromValue(String value) {
        for (InterviewStatus s : values()) {
            if (s.value.equals(value)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown InterviewStatus: " + value);
    }
}
