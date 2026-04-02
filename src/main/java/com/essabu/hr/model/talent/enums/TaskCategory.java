package com.essabu.hr.model.talent.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for task category in the HR module.
 *
 * This enum defines the complete set of valid task category values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - IT_SETUP: it setup
 * - DOCUMENTS: documents
 * - TRAINING: training
 * - ACCESS: access
 * - EQUIPMENT: equipment
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum TaskCategory {

    IT_SETUP("it_setup"),
    DOCUMENTS("documents"),
    TRAINING("training"),
    ACCESS("access"),
    EQUIPMENT("equipment");

    private final String value;

    TaskCategory(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static TaskCategory fromValue(String value) {
        for (TaskCategory c : values()) {
            if (c.value.equals(value)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Unknown TaskCategory: " + value);
    }
}
