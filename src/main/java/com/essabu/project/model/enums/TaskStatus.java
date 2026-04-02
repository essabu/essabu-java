package com.essabu.project.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for task status in the Project module.
 *
 * This enum defines the complete set of valid task status values
 * that can be returned by or sent to the Essabu Project API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - TODO: the task has been created but work has not started
 * - IN_PROGRESS: the task is currently being worked on
 * - IN_REVIEW: the task is completed and awaiting review
 * - DONE: the task has been completed and approved
 * - BLOCKED: the task cannot proceed due to a dependency or issue
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum TaskStatus {
    TODO("todo"), IN_PROGRESS("in_progress"), IN_REVIEW("in_review"),
    DONE("done"), BLOCKED("blocked");
    private final String value;
    TaskStatus(String value) { this.value = value; }
    @JsonValue public String getValue() { return value; }
}
