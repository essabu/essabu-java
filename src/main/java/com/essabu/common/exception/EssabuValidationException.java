package com.essabu.common.exception;

import lombok.Getter;

import java.util.Collections;
import java.util.Map;

/**
 * Thrown when the Essabu API returns a validation error (400 or 422 status code).
 *
 * Contains a map of field-level errors where each key is the field name and the
 * value is the validation error message for that field.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Getter
public class EssabuValidationException extends EssabuApiException {

    private final Map<String, String> fieldErrors;

    public EssabuValidationException(String message, int statusCode, Map<String, String> fieldErrors) {
        super(message, statusCode);
        this.fieldErrors = fieldErrors != null
                ? Collections.unmodifiableMap(fieldErrors)
                : Collections.emptyMap();
    }

    public EssabuValidationException(String message, int statusCode) {
        this(message, statusCode, Collections.emptyMap());
    }
}
