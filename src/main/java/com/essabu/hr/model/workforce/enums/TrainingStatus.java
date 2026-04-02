package com.essabu.hr.model.workforce.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for training status in the HR module.
 *
 * This enum defines the complete set of valid training status values
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
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum TrainingStatus {

    SCHEDULED("scheduled"),
    IN_PROGRESS("in_progress"),
    COMPLETED("completed"),
    CANCELLED("cancelled");

    private final String value;

    TrainingStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static TrainingStatus fromValue(String value) {
        for (TrainingStatus s : values()) {
            if (s.value.equals(value)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown TrainingStatus: " + value);
    }
}
