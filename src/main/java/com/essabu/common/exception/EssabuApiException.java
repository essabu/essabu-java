package com.essabu.common.exception;

import lombok.Getter;

/**
 * Base exception class for all errors raised by the Essabu SDK.
 *
 * This abstract exception serves as the root of the Essabu SDK exception
 * hierarchy. All specific HTTP error exceptions extend this class, allowing
 * callers to catch this single type when they want to handle any API error
 * uniformly. Each exception instance carries the HTTP status code returned
 * by the server and the error message extracted from the response body.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Getter
public abstract class EssabuApiException extends RuntimeException {

    private final int statusCode;

    protected EssabuApiException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    protected EssabuApiException(String message, int statusCode, Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
    }
}
