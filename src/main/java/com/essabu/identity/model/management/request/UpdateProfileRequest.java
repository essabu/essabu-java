package com.essabu.identity.model.management.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request payload for updating a profile via the Essabu Identity API.
 *
 * This data transfer object carries the parameters required to update
 * a profile resource through the Identity REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - firstName: first name
 * - lastName: last name
 * - phone: phone
 * - avatarUrl: avatar url
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProfileRequest {

    private String firstName;
    private String lastName;
    private String phone;
    private String avatarUrl;
}
