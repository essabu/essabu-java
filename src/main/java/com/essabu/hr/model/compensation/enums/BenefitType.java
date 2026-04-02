package com.essabu.hr.model.compensation.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for benefit type in the HR module.
 *
 * This enum defines the complete set of valid benefit type values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - HEALTH_INSURANCE: health insurance
 * - MEAL_VOUCHER: meal voucher
 * - TRANSPORT: transport
 * - RETIREMENT: retirement
 * - OTHER: other
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum BenefitType {

    HEALTH_INSURANCE("health_insurance"),
    MEAL_VOUCHER("meal_voucher"),
    TRANSPORT("transport"),
    RETIREMENT("retirement"),
    OTHER("other");

    private final String value;

    BenefitType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static BenefitType fromValue(String value) {
        for (BenefitType t : values()) {
            if (t.value.equals(value)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown BenefitType: " + value);
    }
}
