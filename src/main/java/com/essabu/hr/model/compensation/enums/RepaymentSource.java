package com.essabu.hr.model.compensation.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for repayment source in the HR module.
 *
 * This enum defines the complete set of valid repayment source values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - PAYROLL_DEDUCTION: payroll deduction
 * - MANUAL: manual
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum RepaymentSource {

    PAYROLL_DEDUCTION("payroll_deduction"),
    MANUAL("manual");

    private final String value;

    RepaymentSource(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static RepaymentSource fromValue(String value) {
        for (RepaymentSource s : values()) {
            if (s.value.equals(value)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown RepaymentSource: " + value);
    }
}
