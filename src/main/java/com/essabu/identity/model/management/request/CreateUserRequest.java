package com.essabu.identity.model.management.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * Request payload for creating a user via the Essabu Identity API.
 *
 * This data transfer object carries the parameters required to create
 * a user resource through the Identity REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - firstName: first name
 * - lastName: last name
 * - email: email
 * - password: password
 * - phone: phone
 * - companyId: company id
 * - roleIds: role ids
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private UUID companyId;
    private List<UUID> roleIds;
}
