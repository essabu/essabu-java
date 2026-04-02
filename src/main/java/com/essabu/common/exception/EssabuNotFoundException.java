package com.essabu.common.exception;

/**
 * Thrown when the Essabu API returns a 404 Not Found response.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class EssabuNotFoundException extends EssabuApiException {

    public EssabuNotFoundException(String message) {
        super(message, 404);
    }

    public EssabuNotFoundException(String message, Throwable cause) {
        super(message, 404, cause);
    }
}
