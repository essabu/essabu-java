package com.essabu.accounting.model.core.request;

import com.essabu.accounting.model.core.enums.AccountNature;
import com.essabu.accounting.model.core.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Request payload for creating a account via the Essabu Accounting API.
 *
 * This data transfer object carries the parameters required to create
 * a account resource through the Accounting REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - code: code
 * - name: name
 * - accountClass: account class
 * - type: type
 * - nature: nature
 * - parentId: parent id
 * - description: description
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountRequest {
    private UUID companyId;
    private String code;
    private String name;
    private int accountClass;
    private AccountType type;
    private AccountNature nature;
    private UUID parentId;
    private String description;
}
