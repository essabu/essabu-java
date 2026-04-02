package com.essabu.common.exception;

import lombok.Getter;

/**
 * Base exception for all Essabu API errors.
 * Contains the HTTP status code and the raw response body from the server.
 */
@Getter
public class EssabuApiException extends RuntimeException {

    private final int statusCode;
    private final String responseBody;

    public EssabuApiException(String message, int statusCode, String responseBody) {
        super(message);
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }
}
