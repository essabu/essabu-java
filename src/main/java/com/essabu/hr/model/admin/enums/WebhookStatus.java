package com.essabu.hr.model.admin.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for webhook status in the HR module.
 *
 * This enum defines the complete set of valid webhook status values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - ACTIVE: active
 * - INACTIVE: inactive
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum WebhookStatus {

    ACTIVE("active"),
    INACTIVE("inactive");

    private final String value;

    WebhookStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static WebhookStatus fromValue(String value) {
        for (WebhookStatus s : values()) {
            if (s.value.equals(value)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown WebhookStatus: " + value);
    }
}
