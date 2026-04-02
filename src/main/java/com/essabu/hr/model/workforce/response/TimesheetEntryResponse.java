package com.essabu.hr.model.workforce.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Response payload representing a timesheet entry returned by the Essabu HR API.
 *
 * Contains all timesheet entry information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the timesheet entry resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - timesheetId: timesheet id
 * - date: date
 * - hours: hours
 * - projectName: project name
 * - taskDescription: task description
 * - notes: notes
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimesheetEntryResponse {
    private UUID id;
    private UUID timesheetId;
    private LocalDate date;
    private double hours;
    private String projectName;
    private String taskDescription;
    private String notes;
}
