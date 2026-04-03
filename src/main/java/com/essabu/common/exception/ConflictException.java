package com.essabu.common.exception;

/**
 * Thrown when the request conflicts with the current state of the resource (HTTP 409).
 */
public class ConflictException extends EssabuApiException {
    public ConflictException(String message, int statusCode, String responseBody) {
        super(message, statusCode, responseBody);
    }

    public ConflictException(String message, int statusCode, String responseBody, String requestId) {
        super(message, statusCode, responseBody, requestId);
    }
}
