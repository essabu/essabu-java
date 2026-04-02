package com.essabu.hr.model.workforce.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Request payload for creating a shift swap via the Essabu HR API.
 *
 * This data transfer object carries the parameters required to create
 * a shift swap resource through the HR REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - requesterId: requester id
 * - targetId: target id
 * - requesterShiftId: requester shift id
 * - targetShiftId: target shift id
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateShiftSwapRequest {

    private UUID requesterId;
    private UUID targetId;
    private UUID requesterShiftId;
    private UUID targetShiftId;
}
