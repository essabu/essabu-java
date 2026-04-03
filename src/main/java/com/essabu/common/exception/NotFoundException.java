package com.essabu.common.exception;

/**
 * Thrown when a requested resource is not found (HTTP 404).
 */
public class NotFoundException extends EssabuApiException {
    public NotFoundException(String message, int statusCode, String responseBody) {
        super(message, statusCode, responseBody);
    }

    public NotFoundException(String message, int statusCode, String responseBody, String requestId) {
        super(message, statusCode, responseBody, requestId);
    }
}
