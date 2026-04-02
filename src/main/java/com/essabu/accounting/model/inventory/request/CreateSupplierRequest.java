package com.essabu.accounting.model.inventory.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Request payload for creating a supplier via the Essabu Accounting API.
 *
 * This data transfer object carries the parameters required to create
 * a supplier resource through the Accounting REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - name: name
 * - code: code
 * - contactName: contact name
 * - email: email
 * - phone: phone
 * - address: address
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSupplierRequest {
    private UUID companyId;
    private String name;
    private String code;
    private String contactName;
    private String email;
    private String phone;
    private String address;
}
