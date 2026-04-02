package com.essabu.hr.model.compensation.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for expense report status in the HR module.
 *
 * This enum defines the complete set of valid expense report status values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - DRAFT: draft
 * - SUBMITTED: submitted
 * - APPROVED: approved
 * - REJECTED: rejected
 * - PAID: paid
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum ExpenseReportStatus {

    DRAFT("draft"),
    SUBMITTED("submitted"),
    APPROVED("approved"),
    REJECTED("rejected"),
    PAID("paid");

    private final String value;

    ExpenseReportStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static ExpenseReportStatus fromValue(String value) {
        for (ExpenseReportStatus s : values()) {
            if (s.value.equals(value)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown ExpenseReportStatus: " + value);
    }
}
