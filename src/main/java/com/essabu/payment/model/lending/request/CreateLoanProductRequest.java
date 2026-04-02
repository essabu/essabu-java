package com.essabu.payment.model.lending.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Request payload for creating a loan product via the Essabu Payment API.
 *
 * This data transfer object carries the parameters required to create
 * a loan product resource through the Payment REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - name: name
 * - type: type
 * - interestRate: interest rate
 * - minAmount: min amount
 * - maxAmount: max amount
 * - minTerm: min term
 * - maxTerm: max term
 * - currency: currency
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateLoanProductRequest {

    private UUID companyId;
    private String name;
    private String type;
    private BigDecimal interestRate;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private int minTerm;
    private int maxTerm;
    private String currency;
}
