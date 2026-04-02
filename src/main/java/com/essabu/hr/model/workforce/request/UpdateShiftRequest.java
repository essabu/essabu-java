package com.essabu.hr.model.workforce.request;

import com.essabu.hr.model.workforce.enums.ShiftType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Request payload for updating a shift via the Essabu HR API.
 *
 * This data transfer object carries the parameters required to update
 * a shift resource through the HR REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - shiftType: shift type
 * - date: date
 * - startTime: start time
 * - endTime: end time
 * - department: department
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateShiftRequest {

    private ShiftType shiftType;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String department;
}
