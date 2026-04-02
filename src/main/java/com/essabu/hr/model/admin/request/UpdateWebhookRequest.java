package com.essabu.hr.model.admin.request;

import com.essabu.hr.model.admin.enums.WebhookStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Request payload for updating a webhook via the Essabu HR API.
 *
 * This data transfer object carries the parameters required to update
 * a webhook resource through the HR REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - url: url
 * - events: events
 * - status: status
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateWebhookRequest {

    private String url;
    private List<String> events;
    private WebhookStatus status;
}
