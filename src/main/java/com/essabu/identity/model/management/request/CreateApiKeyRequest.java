package com.essabu.identity.model.management.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * Request payload for creating a api key via the Essabu Identity API.
 *
 * This data transfer object carries the parameters required to create
 * a api key resource through the Identity REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - name: name
 * - companyId: company id
 * - scopes: scopes
 * - expiresInDays: expires in days
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateApiKeyRequest {

    private String name;
    private UUID companyId;
    private List<String> scopes;
    private Integer expiresInDays;
}
