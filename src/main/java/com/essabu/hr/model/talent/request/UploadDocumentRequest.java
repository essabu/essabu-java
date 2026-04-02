package com.essabu.hr.model.talent.request;

import com.essabu.hr.model.talent.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Request payload for performing an operation on a upload document via the Essabu HR API.
 *
 * This data transfer object carries the parameters required to process
 * a upload document resource through the HR REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - type: type
 * - name: name
 * - expiresAt: expires at
 * - confidential: confidential
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadDocumentRequest {

    private DocumentType type;
    private String name;
    private byte[] file;
    private LocalDate expiresAt;
    private Boolean confidential;
}
