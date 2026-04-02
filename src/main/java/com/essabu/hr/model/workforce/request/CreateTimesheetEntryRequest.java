package com.essabu.hr.model.workforce.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Request payload for creating a timesheet entry via the Essabu HR API.
 *
 * This data transfer object carries the parameters required to create
 * a timesheet entry resource through the HR REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - date: date
 * - projectName: project name
 * - taskDescription: task description
 * - hours: hours
 * - billable: billable
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTimesheetEntryRequest {

    private LocalDate date;
    private String projectName;
    private String taskDescription;
    private BigDecimal hours;
    private Boolean billable;
}
