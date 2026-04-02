package com.essabu.common.exception;

/**
 * Thrown when the Essabu API returns a 401 Unauthorized response.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class EssabuUnauthorizedException extends EssabuApiException {

    public EssabuUnauthorizedException(String message) {
        super(message, 401);
    }

    public EssabuUnauthorizedException(String message, Throwable cause) {
        super(message, 401, cause);
    }
}
