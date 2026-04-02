package com.essabu.trade.model.contract.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Request payload for creating a document via the Essabu Trade API.
 *
 * This data transfer object carries the parameters required to create
 * a document resource through the Trade REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - contractId: contract id
 * - name: name
 * - type: type
 * - filePath: file path
 * - description: description
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateDocumentRequest {
    private UUID companyId;
    private UUID contractId;
    private String name;
    private String type;
    private String filePath;
    private String description;
}
