package com.essabu.trade.model.crm.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Request payload for updating a campaign via the Essabu Trade API.
 *
 * This data transfer object carries the parameters required to update
 * a campaign resource through the Trade REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - name: name
 * - type: type
 * - description: description
 * - startDate: start date
 * - endDate: end date
 * - budget: budget
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCampaignRequest {
    private String name;
    private String type;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal budget;
}
