package com.essabu.common.exception;

/**
 * Thrown when the server rejects input due to validation errors (HTTP 422).
 */
public class ValidationException extends EssabuApiException {
    public ValidationException(String message, int statusCode, String responseBody) {
        super(message, statusCode, responseBody);
    }

    public ValidationException(String message, int statusCode, String responseBody, String requestId) {
        super(message, statusCode, responseBody, requestId);
    }
}
