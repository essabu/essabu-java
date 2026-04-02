package com.essabu.hr.model.admin.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for audit action in the HR module.
 *
 * This enum defines the complete set of valid audit action values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - CREATED: created
 * - UPDATED: updated
 * - DELETED: deleted
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum AuditAction {

    CREATED("created"),
    UPDATED("updated"),
    DELETED("deleted");

    private final String value;

    AuditAction(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static AuditAction fromValue(String value) {
        for (AuditAction a : values()) {
            if (a.value.equals(value)) {
                return a;
            }
        }
        throw new IllegalArgumentException("Unknown AuditAction: " + value);
    }
}
