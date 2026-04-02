package com.essabu.hr.model.workforce.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Request payload for performing an operation on a terminate contract via the Essabu HR API.
 *
 * This data transfer object carries the parameters required to process
 * a terminate contract resource through the HR REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - terminationReason: termination reason
 * - terminationDate: termination date
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TerminateContractRequest {

    private String terminationReason;
    private LocalDate terminationDate;
}
