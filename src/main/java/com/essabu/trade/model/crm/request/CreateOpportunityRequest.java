package com.essabu.trade.model.crm.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Request payload for creating a opportunity via the Essabu Trade API.
 *
 * This data transfer object carries the parameters required to create
 * a opportunity resource through the Trade REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - contactId: contact id
 * - name: name
 * - amount: amount
 * - probability: probability
 * - expectedCloseDate: expected close date
 * - source: source
 * - notes: notes
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOpportunityRequest {
    private UUID companyId;
    private UUID contactId;
    private String name;
    private BigDecimal amount;
    private int probability;
    private LocalDate expectedCloseDate;
    private String source;
    private String notes;
}
