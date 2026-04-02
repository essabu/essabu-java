package com.essabu.hr.model.compensation.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for payroll line type in the HR module.
 *
 * This enum defines the complete set of valid payroll line type values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - BASIC_SALARY: basic salary
 * - ALLOWANCE: allowance
 * - BONUS: bonus
 * - DEDUCTION: deduction
 * - TAX: tax
 * - SOCIAL_CONTRIBUTION: social contribution
 * - OVERTIME: overtime
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum PayrollLineType {

    BASIC_SALARY("basic_salary"),
    ALLOWANCE("allowance"),
    BONUS("bonus"),
    DEDUCTION("deduction"),
    TAX("tax"),
    SOCIAL_CONTRIBUTION("social_contribution"),
    OVERTIME("overtime");

    private final String value;

    PayrollLineType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static PayrollLineType fromValue(String value) {
        for (PayrollLineType t : values()) {
            if (t.value.equals(value)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown PayrollLineType: " + value);
    }
}
