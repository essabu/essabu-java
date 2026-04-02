package com.essabu.hr.model.core.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Request payload for updating a position via the Essabu HR API.
 *
 * This data transfer object carries the parameters required to update
 * a position resource through the HR REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - name: name
 * - description: description
 * - level: level
 * - minSalary: min salary
 * - maxSalary: max salary
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePositionRequest {

    private String name;
    private String description;
    private Integer level;
    private BigDecimal minSalary;
    private BigDecimal maxSalary;
}
