package com.essabu.common.exception;

/**
 * Thrown when the server returns a 5xx error after all retries are exhausted.
 */
public class ServerException extends EssabuApiException {
    public ServerException(String message, int statusCode, String responseBody) {
        super(message, statusCode, responseBody);
    }
}
