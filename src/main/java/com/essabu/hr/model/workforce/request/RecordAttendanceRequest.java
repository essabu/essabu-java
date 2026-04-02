package com.essabu.hr.model.workforce.request;

import com.essabu.hr.model.workforce.enums.AttendanceStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

/**
 * Request payload for performing an operation on a record attendance via the Essabu HR API.
 *
 * This data transfer object carries the parameters required to process
 * a record attendance resource through the HR REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - employeeId: employee id
 * - date: date
 * - clockIn: clock in
 * - clockOut: clock out
 * - status: status
 * - notes: notes
 * - overtimeHours: overtime hours
 * - location: location
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecordAttendanceRequest {

    private UUID employeeId;
    private LocalDate date;
    private LocalTime clockIn;
    private LocalTime clockOut;
    private AttendanceStatus status;
    private String notes;
    private BigDecimal overtimeHours;
    private String location;
}
