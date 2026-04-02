package com.essabu.hr.model.compensation.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for payroll status in the HR module.
 *
 * This enum defines the complete set of valid payroll status values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - DRAFT: draft
 * - CALCULATED: calculated
 * - APPROVED: approved
 * - PAID: paid
 * - CANCELLED: cancelled
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum PayrollStatus {

    DRAFT("draft"),
    CALCULATED("calculated"),
    APPROVED("approved"),
    PAID("paid"),
    CANCELLED("cancelled");

    private final String value;

    PayrollStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static PayrollStatus fromValue(String value) {
        for (PayrollStatus s : values()) {
            if (s.value.equals(value)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown PayrollStatus: " + value);
    }
}
