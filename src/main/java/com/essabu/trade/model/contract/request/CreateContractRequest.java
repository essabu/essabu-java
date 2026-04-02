package com.essabu.trade.model.contract.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Request payload for creating a contract via the Essabu Trade API.
 *
 * This data transfer object carries the parameters required to create
 * a contract resource through the Trade REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - customerId: customer id
 * - title: title
 * - description: description
 * - type: type
 * - value: value
 * - currency: currency
 * - startDate: start date
 * - endDate: end date
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateContractRequest {
    private UUID companyId;
    private UUID customerId;
    private String title;
    private String description;
    private String type;
    private BigDecimal value;
    private String currency;
    private LocalDate startDate;
    private LocalDate endDate;
}
