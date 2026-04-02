package com.essabu.hr.model.workforce.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for leave type in the HR module.
 *
 * This enum defines the complete set of valid leave type values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - ANNUAL: annual
 * - SICK: sick
 * - UNPAID: unpaid
 * - MATERNITY: maternity
 * - PATERNITY: paternity
 * - STUDY: study
 * - PERSONAL: personal
 * - BEREAVEMENT: bereavement
 * - MARRIAGE: marriage
 * - COMPENSATORY: compensatory
 * - OTHER: other
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum LeaveType {

    ANNUAL("annual"),
    SICK("sick"),
    UNPAID("unpaid"),
    MATERNITY("maternity"),
    PATERNITY("paternity"),
    STUDY("study"),
    PERSONAL("personal"),
    BEREAVEMENT("bereavement"),
    MARRIAGE("marriage"),
    COMPENSATORY("compensatory"),
    OTHER("other");

    private final String value;

    LeaveType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static LeaveType fromValue(String value) {
        for (LeaveType t : values()) {
            if (t.value.equals(value)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown LeaveType: " + value);
    }
}
