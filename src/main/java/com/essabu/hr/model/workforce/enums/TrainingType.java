package com.essabu.hr.model.workforce.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for training type in the HR module.
 *
 * This enum defines the complete set of valid training type values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - MANDATORY: mandatory
 * - OPTIONAL: optional
 * - CERTIFICATION: certification
 * - CONTINUING_EDUCATION: continuing education
 * - ORIENTATION: orientation
 * - SKILLS_DEVELOPMENT: skills development
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum TrainingType {

    MANDATORY("mandatory"),
    OPTIONAL("optional"),
    CERTIFICATION("certification"),
    CONTINUING_EDUCATION("continuing_education"),
    ORIENTATION("orientation"),
    SKILLS_DEVELOPMENT("skills_development");

    private final String value;

    TrainingType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static TrainingType fromValue(String value) {
        for (TrainingType t : values()) {
            if (t.value.equals(value)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown TrainingType: " + value);
    }
}
