package com.essabu.einvoice.model.invoice.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Request payload for performing an operation on a submit to government via the Essabu E-Invoice API.
 *
 * This data transfer object carries the parameters required to process
 * a submit to government resource through the E-Invoice REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - normalizedInvoiceId: normalized invoice id
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubmitToGovernmentRequest {

    private UUID normalizedInvoiceId;
}
