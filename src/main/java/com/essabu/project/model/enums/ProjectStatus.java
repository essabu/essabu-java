package com.essabu.project.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for project status in the Project module.
 *
 * This enum defines the complete set of valid project status values
 * that can be returned by or sent to the Essabu Project API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - PLANNING: planning
 * - IN_PROGRESS: in progress
 * - ON_HOLD: the project has been temporarily paused
 * - COMPLETED: the project has been finished successfully
 * - CANCELLED: the project has been cancelled and will not proceed
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum ProjectStatus {
    PLANNING("planning"), IN_PROGRESS("in_progress"), ON_HOLD("on_hold"),
    COMPLETED("completed"), CANCELLED("cancelled");
    private final String value;
    ProjectStatus(String value) { this.value = value; }
    @JsonValue public String getValue() { return value; }
}
