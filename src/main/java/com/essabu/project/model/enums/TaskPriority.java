package com.essabu.project.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for task priority in the Project module.
 *
 * This enum defines the complete set of valid task priority values
 * that can be returned by or sent to the Essabu Project API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - LOW: the task has low urgency and can be addressed when convenient
 * - MEDIUM: the task has normal priority and should be addressed in due course
 * - HIGH: the task is important and should be prioritized
 * - CRITICAL: the task is critical and must be resolved as the top priority
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum TaskPriority {
    LOW("low"), MEDIUM("medium"), HIGH("high"), CRITICAL("critical");
    private final String value;
    TaskPriority(String value) { this.value = value; }
    @JsonValue public String getValue() { return value; }
}
