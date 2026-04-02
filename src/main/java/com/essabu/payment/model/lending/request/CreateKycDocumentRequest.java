package com.essabu.payment.model.lending.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Request payload for creating a kyc document via the Essabu Payment API.
 *
 * This data transfer object carries the parameters required to create
 * a kyc document resource through the Payment REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - kycProfileId: kyc profile id
 * - type: type
 * - documentUrl: document url
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateKycDocumentRequest {

    private UUID kycProfileId;
    private String type;
    private String documentUrl;
}
