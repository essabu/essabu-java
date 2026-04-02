package com.essabu.asset.model.request;

import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;

/**
 * Request payload for creating a depreciation via the Essabu Asset API.
 *
 * This data transfer object carries the parameters required to create
 * a depreciation resource through the Asset REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data @Builder @NoArgsConstructor
public class CreateDepreciationRequest {
}
