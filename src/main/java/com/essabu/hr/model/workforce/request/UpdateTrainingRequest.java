package com.essabu.hr.model.workforce.request;

import com.essabu.hr.model.workforce.enums.TrainingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Request payload for updating a training via the Essabu HR API.
 *
 * This data transfer object carries the parameters required to update
 * a training resource through the HR REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - title: title
 * - description: description
 * - type: type
 * - provider: provider
 * - startDate: start date
 * - endDate: end date
 * - score: score
 * - certificateUrl: certificate url
 * - expiresAt: expires at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTrainingRequest {

    private String title;
    private String description;
    private TrainingType type;
    private String provider;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer score;
    private String certificateUrl;
    private LocalDate expiresAt;
}
