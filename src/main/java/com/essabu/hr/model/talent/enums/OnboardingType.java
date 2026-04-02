package com.essabu.hr.model.talent.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for onboarding type in the HR module.
 *
 * This enum defines the complete set of valid onboarding type values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - ONBOARDING: onboarding
 * - OFFBOARDING: offboarding
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum OnboardingType {

    ONBOARDING("onboarding"),
    OFFBOARDING("offboarding");

    private final String value;

    OnboardingType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static OnboardingType fromValue(String value) {
        for (OnboardingType t : values()) {
            if (t.value.equals(value)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown OnboardingType: " + value);
    }
}
