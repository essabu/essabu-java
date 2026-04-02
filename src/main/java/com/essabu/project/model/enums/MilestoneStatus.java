package com.essabu.project.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for milestone status in the Project module.
 *
 * This enum defines the complete set of valid milestone status values
 * that can be returned by or sent to the Essabu Project API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - PENDING: the milestone has not yet been reached
 * - IN_PROGRESS: in progress
 * - COMPLETED: completed
 * - OVERDUE: the milestone target date has passed without completion
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum MilestoneStatus {
    PENDING("pending"), IN_PROGRESS("in_progress"), COMPLETED("completed"), OVERDUE("overdue");
    private final String value;
    MilestoneStatus(String value) { this.value = value; }
    @JsonValue public String getValue() { return value; }
}
