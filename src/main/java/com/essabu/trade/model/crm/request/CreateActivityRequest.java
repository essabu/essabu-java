package com.essabu.trade.model.crm.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Request payload for creating a activity via the Essabu Trade API.
 *
 * This data transfer object carries the parameters required to create
 * a activity resource through the Trade REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - contactId: contact id
 * - opportunityId: opportunity id
 * - type: type
 * - subject: subject
 * - description: description
 * - activityDate: activity date
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateActivityRequest {
    private UUID companyId;
    private UUID contactId;
    private UUID opportunityId;
    private String type;
    private String subject;
    private String description;
    private LocalDateTime activityDate;
}
