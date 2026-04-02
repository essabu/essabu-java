package com.essabu.hr.model.talent.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for review status in the HR module.
 *
 * This enum defines the complete set of valid review status values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - DRAFT: draft
 * - SUBMITTED: submitted
 * - ACKNOWLEDGED: acknowledged
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum ReviewStatus {

    DRAFT("draft"),
    SUBMITTED("submitted"),
    ACKNOWLEDGED("acknowledged");

    private final String value;

    ReviewStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static ReviewStatus fromValue(String value) {
        for (ReviewStatus s : values()) {
            if (s.value.equals(value)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown ReviewStatus: " + value);
    }
}
