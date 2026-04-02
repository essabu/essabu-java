package com.essabu.hr.model.talent.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for application status in the HR module.
 *
 * This enum defines the complete set of valid application status values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - RECEIVED: received
 * - SCREENING: screening
 * - INTERVIEW: interview
 * - OFFER: offer
 * - HIRED: hired
 * - REJECTED: rejected
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum ApplicationStatus {

    RECEIVED("received"),
    SCREENING("screening"),
    INTERVIEW("interview"),
    OFFER("offer"),
    HIRED("hired"),
    REJECTED("rejected");

    private final String value;

    ApplicationStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static ApplicationStatus fromValue(String value) {
        for (ApplicationStatus s : values()) {
            if (s.value.equals(value)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown ApplicationStatus: " + value);
    }
}
