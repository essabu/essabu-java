package com.essabu.common.exception;

/**
 * Thrown when the Essabu API returns a server error (5xx status code).
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class EssabuServerException extends EssabuApiException {

    public EssabuServerException(String message, int statusCode) {
        super(message, statusCode);
    }

    public EssabuServerException(String message, int statusCode, Throwable cause) {
        super(message, statusCode, cause);
    }
}
