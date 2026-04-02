package com.essabu.hr.model.compensation.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for loan type in the HR module.
 *
 * This enum defines the complete set of valid loan type values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - SALARY_ADVANCE: salary advance
 * - PERSONAL_LOAN: personal loan
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum LoanType {

    SALARY_ADVANCE("salary_advance"),
    PERSONAL_LOAN("personal_loan");

    private final String value;

    LoanType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static LoanType fromValue(String value) {
        for (LoanType t : values()) {
            if (t.value.equals(value)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown LoanType: " + value);
    }
}
