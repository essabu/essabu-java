package com.essabu.hr.model.compensation.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for loan status in the HR module.
 *
 * This enum defines the complete set of valid loan status values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - PENDING: pending
 * - APPROVED: approved
 * - ACTIVE: active
 * - REPAID: repaid
 * - DEFAULTED: defaulted
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum LoanStatus {

    PENDING("pending"),
    APPROVED("approved"),
    ACTIVE("active"),
    REPAID("repaid"),
    DEFAULTED("defaulted");

    private final String value;

    LoanStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static LoanStatus fromValue(String value) {
        for (LoanStatus s : values()) {
            if (s.value.equals(value)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown LoanStatus: " + value);
    }
}
