package com.essabu.hr.model.talent.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for onboarding status in the HR module.
 *
 * This enum defines the complete set of valid onboarding status values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - PENDING: pending
 * - IN_PROGRESS: in progress
 * - COMPLETED: completed
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum OnboardingStatus {

    PENDING("pending"),
    IN_PROGRESS("in_progress"),
    COMPLETED("completed");

    private final String value;

    OnboardingStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static OnboardingStatus fromValue(String value) {
        for (OnboardingStatus s : values()) {
            if (s.value.equals(value)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown OnboardingStatus: " + value);
    }
}
