package com.essabu.common.exception;

/**
 * Thrown when the authenticated user lacks permission for the action (HTTP 403).
 */
public class ForbiddenException extends EssabuApiException {
    public ForbiddenException(String message, int statusCode, String responseBody) {
        super(message, statusCode, responseBody);
    }

    public ForbiddenException(String message, int statusCode, String responseBody, String requestId) {
        super(message, statusCode, responseBody, requestId);
    }
}
