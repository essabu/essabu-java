package com.essabu.project.model.request;

import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;

/**
 * Request payload for updating a task comment via the Essabu Project API.
 *
 * This data transfer object carries the parameters required to update
 * a task comment resource through the Project REST API. It is serialized
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
public class UpdateTaskCommentRequest {
}
