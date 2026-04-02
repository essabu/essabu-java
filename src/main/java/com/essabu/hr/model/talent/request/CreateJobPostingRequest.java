package com.essabu.hr.model.talent.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Request payload for creating a job posting via the Essabu HR API.
 *
 * This data transfer object carries the parameters required to create
 * a job posting resource through the HR REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - title: title
 * - departmentId: department id
 * - positionId: position id
 * - description: description
 * - requirements: requirements
 * - salaryMin: salary min
 * - salaryMax: salary max
 * - closingDate: closing date
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobPostingRequest {

    private String title;
    private UUID departmentId;
    private UUID positionId;
    private String description;
    private String requirements;
    private BigDecimal salaryMin;
    private BigDecimal salaryMax;
    private LocalDate closingDate;
}
