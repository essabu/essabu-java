package com.essabu.hr.model.workforce.request;

import com.essabu.hr.model.workforce.enums.ContractType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Request payload for updating a contract via the Essabu HR API.
 *
 * This data transfer object carries the parameters required to update
 * a contract resource through the HR REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - type: type
 * - startDate: start date
 * - endDate: end date
 * - salary: salary
 * - currency: currency
 * - position: position
 * - description: description
 * - trialPeriodEnd: trial period end
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateContractRequest {

    private ContractType type;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal salary;
    private String currency;
    private String position;
    private String description;
    private LocalDate trialPeriodEnd;
}
