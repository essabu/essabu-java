package com.essabu.hr.model.workforce.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for attendance status in the HR module.
 *
 * This enum defines the complete set of valid attendance status values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - PRESENT: present
 * - ABSENT: absent
 * - LATE: late
 * - HALF_DAY: half day
 * - ON_LEAVE: on leave
 * - HOLIDAY: holiday
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum AttendanceStatus {

    PRESENT("present"),
    ABSENT("absent"),
    LATE("late"),
    HALF_DAY("half_day"),
    ON_LEAVE("on_leave"),
    HOLIDAY("holiday");

    private final String value;

    AttendanceStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static AttendanceStatus fromValue(String value) {
        for (AttendanceStatus s : values()) {
            if (s.value.equals(value)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown AttendanceStatus: " + value);
    }
}
