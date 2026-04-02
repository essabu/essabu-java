package com.essabu.common.exception;

/**
 * Thrown when the Essabu API returns a 403 Forbidden response.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class EssabuForbiddenException extends EssabuApiException {

    public EssabuForbiddenException(String message) {
        super(message, 403);
    }

    public EssabuForbiddenException(String message, Throwable cause) {
        super(message, 403, cause);
    }
}
