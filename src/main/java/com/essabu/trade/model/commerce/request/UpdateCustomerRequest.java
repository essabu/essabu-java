package com.essabu.trade.model.commerce.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Request payload for updating a customer via the Essabu Trade API.
 *
 * This data transfer object carries the parameters required to update
 * a customer resource through the Trade REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - name: name
 * - email: email
 * - phone: phone
 * - address: address
 * - taxId: tax id
 * - type: type
 * - customerGroupId: customer group id
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerRequest {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String taxId;
    private String type;
    private UUID customerGroupId;
}
