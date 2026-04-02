package com.essabu.hr.model.talent.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for disciplinary type in the HR module.
 *
 * This enum defines the complete set of valid disciplinary type values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - WARNING: warning
 * - WRITTEN_WARNING: written warning
 * - SUSPENSION: suspension
 * - DEMOTION: demotion
 * - TERMINATION: termination
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum DisciplinaryType {

    WARNING("warning"),
    WRITTEN_WARNING("written_warning"),
    SUSPENSION("suspension"),
    DEMOTION("demotion"),
    TERMINATION("termination");

    private final String value;

    DisciplinaryType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static DisciplinaryType fromValue(String value) {
        for (DisciplinaryType t : values()) {
            if (t.value.equals(value)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown DisciplinaryType: " + value);
    }
}
