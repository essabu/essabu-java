package com.essabu.common.exception;

/**
 * Thrown when the API rate limit has been exceeded (HTTP 429).
 */
public class RateLimitException extends EssabuApiException {
    public RateLimitException(String message, int statusCode, String responseBody) {
        super(message, statusCode, responseBody);
    }

    public RateLimitException(String message, int statusCode, String responseBody, String requestId) {
        super(message, statusCode, responseBody, requestId);
    }
}
