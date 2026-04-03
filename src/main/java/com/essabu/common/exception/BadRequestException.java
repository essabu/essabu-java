package com.essabu.common.exception;

/**
 * Thrown when the server rejects the request due to invalid input (HTTP 400).
 */
public class BadRequestException extends EssabuApiException {
    public BadRequestException(String message, int statusCode, String responseBody) {
        super(message, statusCode, responseBody);
    }

    public BadRequestException(String message, int statusCode, String responseBody, String requestId) {
        super(message, statusCode, responseBody, requestId);
    }
}
