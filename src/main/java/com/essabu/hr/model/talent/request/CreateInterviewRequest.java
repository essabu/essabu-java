package com.essabu.hr.model.talent.request;

import com.essabu.hr.model.talent.enums.InterviewType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Request payload for creating a interview via the Essabu HR API.
 *
 * This data transfer object carries the parameters required to create
 * a interview resource through the HR REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - applicationId: application id
 * - interviewerId: interviewer id
 * - scheduledAt: scheduled at
 * - type: type
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateInterviewRequest {

    private UUID applicationId;
    private UUID interviewerId;
    private LocalDateTime scheduledAt;
    private InterviewType type;
}
