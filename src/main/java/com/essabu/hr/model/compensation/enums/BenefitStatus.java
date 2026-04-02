package com.essabu.hr.model.compensation.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for benefit status in the HR module.
 *
 * This enum defines the complete set of valid benefit status values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - ACTIVE: active
 * - SUSPENDED: suspended
 * - TERMINATED: terminated
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum BenefitStatus {

    ACTIVE("active"),
    SUSPENDED("suspended"),
    TERMINATED("terminated");

    private final String value;

    BenefitStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static BenefitStatus fromValue(String value) {
        for (BenefitStatus s : values()) {
            if (s.value.equals(value)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown BenefitStatus: " + value);
    }
}
