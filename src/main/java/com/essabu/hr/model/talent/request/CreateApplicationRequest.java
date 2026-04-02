package com.essabu.hr.model.talent.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Request payload for creating a application via the Essabu HR API.
 *
 * This data transfer object carries the parameters required to create
 * a application resource through the HR REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - jobPostingId: job posting id
 * - candidateName: candidate name
 * - email: email
 * - phone: phone
 * - resumeUrl: resume url
 * - coverLetter: cover letter
 * - source: source
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplicationRequest {

    private UUID jobPostingId;
    private String candidateName;
    private String email;
    private String phone;
    private String resumeUrl;
    private String coverLetter;
    private String source;
}
