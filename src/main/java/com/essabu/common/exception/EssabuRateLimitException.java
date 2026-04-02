package com.essabu.common.exception;

import lombok.Getter;

import java.time.Duration;

/**
 * Thrown when the Essabu API returns a 429 Too Many Requests response.
 *
 * Includes a retryAfter duration extracted from the Retry-After header.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Getter
public class EssabuRateLimitException extends EssabuApiException {

    private final Duration retryAfter;

    public EssabuRateLimitException(String message, int statusCode, Duration retryAfter) {
        super(message, statusCode);
        this.retryAfter = retryAfter;
    }
}
