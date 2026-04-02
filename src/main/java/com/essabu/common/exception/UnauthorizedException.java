package com.essabu.common.exception;

/**
 * Thrown when authentication fails or the token is invalid (HTTP 401).
 */
public class UnauthorizedException extends EssabuApiException {
    public UnauthorizedException(String message, int statusCode, String responseBody) {
        super(message, statusCode, responseBody);
    }
}
