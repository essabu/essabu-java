package com.essabu.common.exception;

import lombok.Getter;

/**
 * Base exception for all Essabu API errors.
 * Contains the HTTP status code, the raw response body, and an optional request ID from the server.
 */
@Getter
public class EssabuApiException extends RuntimeException {

    private final int statusCode;
    private final String responseBody;
    private final String requestId;

    public EssabuApiException(String message, int statusCode, String responseBody) {
        this(message, statusCode, responseBody, null);
    }

    public EssabuApiException(String message, int statusCode, String responseBody, String requestId) {
        super(message);
        this.statusCode = statusCode;
        this.responseBody = responseBody;
        this.requestId = requestId;
    }
}
