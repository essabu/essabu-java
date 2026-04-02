package com.essabu.hr.model.workforce.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for leave request status in the HR module.
 *
 * This enum defines the complete set of valid leave request status values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - DRAFT: draft
 * - PENDING: pending
 * - APPROVED: approved
 * - REJECTED: rejected
 * - CANCELLED: cancelled
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum LeaveRequestStatus {

    DRAFT("draft"),
    PENDING("pending"),
    APPROVED("approved"),
    REJECTED("rejected"),
    CANCELLED("cancelled");

    private final String value;

    LeaveRequestStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static LeaveRequestStatus fromValue(String value) {
        for (LeaveRequestStatus s : values()) {
            if (s.value.equals(value)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown LeaveRequestStatus: " + value);
    }
}
