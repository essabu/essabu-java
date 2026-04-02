package com.essabu.payment.model.lending.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Request payload for updating a loan application via the Essabu Payment API.
 *
 * This data transfer object carries the parameters required to update
 * a loan application resource through the Payment REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - requestedAmount: requested amount
 * - requestedTerm: requested term
 * - purpose: purpose
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLoanApplicationRequest {

    private BigDecimal requestedAmount;
    private Integer requestedTerm;
    private String purpose;
}
