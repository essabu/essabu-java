package com.essabu.hr.model.talent.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for job posting status in the HR module.
 *
 * This enum defines the complete set of valid job posting status values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - DRAFT: draft
 * - OPEN: open
 * - CLOSED: closed
 * - FILLED: filled
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum JobPostingStatus {

    DRAFT("draft"),
    OPEN("open"),
    CLOSED("closed"),
    FILLED("filled");

    private final String value;

    JobPostingStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static JobPostingStatus fromValue(String value) {
        for (JobPostingStatus s : values()) {
            if (s.value.equals(value)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown JobPostingStatus: " + value);
    }
}
