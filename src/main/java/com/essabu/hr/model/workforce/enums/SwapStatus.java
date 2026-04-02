package com.essabu.hr.model.workforce.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for swap status in the HR module.
 *
 * This enum defines the complete set of valid swap status values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - PENDING: pending
 * - APPROVED: approved
 * - REJECTED: rejected
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum SwapStatus {

    PENDING("pending"),
    APPROVED("approved"),
    REJECTED("rejected");

    private final String value;

    SwapStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static SwapStatus fromValue(String value) {
        for (SwapStatus s : values()) {
            if (s.value.equals(value)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown SwapStatus: " + value);
    }
}
