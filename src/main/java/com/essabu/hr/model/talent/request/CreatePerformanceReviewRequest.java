package com.essabu.hr.model.talent.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Request payload for creating a performance review via the Essabu HR API.
 *
 * This data transfer object carries the parameters required to create
 * a performance review resource through the HR REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - reviewCycleId: review cycle id
 * - employeeId: employee id
 * - reviewerId: reviewer id
 * - overallRating: overall rating
 * - strengths: strengths
 * - improvements: improvements
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePerformanceReviewRequest {

    private UUID reviewCycleId;
    private UUID employeeId;
    private UUID reviewerId;
    private Integer overallRating;
    private String strengths;
    private String improvements;
}
