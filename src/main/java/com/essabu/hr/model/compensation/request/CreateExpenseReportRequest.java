package com.essabu.hr.model.compensation.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Request payload for creating a expense report via the Essabu HR API.
 *
 * This data transfer object carries the parameters required to create
 * a expense report resource through the HR REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - employeeId: employee id
 * - title: title
 * - description: description
 * - periodStart: period start
 * - periodEnd: period end
 * - currency: currency
 * - lines: lines
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateExpenseReportRequest {

    private UUID employeeId;
    private String title;
    private String description;
    private LocalDate periodStart;
    private LocalDate periodEnd;
    private String currency;
    private List<CreateExpenseLineRequest> lines;
}
