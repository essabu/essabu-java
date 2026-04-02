package com.essabu.identity.model.management.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request payload for updating a company via the Essabu Identity API.
 *
 * This data transfer object carries the parameters required to update
 * a company resource through the Identity REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - name: name
 * - nif: nif
 * - rccm: rccm
 * - address: address
 * - phone: phone
 * - email: email
 * - sector: sector
 * - country: country
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCompanyRequest {

    private String name;
    private String nif;
    private String rccm;
    private String address;
    private String phone;
    private String email;
    private String sector;
    private String country;
}
