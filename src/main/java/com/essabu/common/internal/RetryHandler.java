package com.essabu.common.internal;

import com.essabu.common.exception.EssabuRateLimitException;
import com.essabu.common.exception.EssabuServerException;

import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.function.Supplier;

/**
 * Retry handler with exponential backoff for the Essabu SDK.
 * This is an internal component not intended for direct use by SDK consumers.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class RetryHandler {

    private final int maxRetries;
    private static final long BASE_DELAY_MS = 1000L;

    public RetryHandler(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public <T> HttpResponse<T> executeWithRetry(Supplier<HttpResponse<T>> operation) {
        HttpResponse<T> response = null;
        int attempt = 0;

        while (attempt <= maxRetries) {
            response = operation.get();
            int statusCode = response.statusCode();

            if (statusCode == 429) {
                Duration retryAfter = extractRetryAfter(response);
                throw new EssabuRateLimitException("Rate limit exceeded (429)", 429, retryAfter);
            }

            if (statusCode < 500) {
                return response;
            }

            attempt++;
            if (attempt <= maxRetries) {
                long delayMs = BASE_DELAY_MS * (1L << (attempt - 1));
                sleep(delayMs);
            }
        }

        throw new EssabuServerException(
                "Server error after " + maxRetries + " tentatives",
                response != null ? response.statusCode() : 500
        );
    }

    private <T> Duration extractRetryAfter(HttpResponse<T> response) {
        return response.headers()
                .firstValue("Retry-After")
                .map(value -> {
                    try {
                        long seconds = Long.parseLong(value);
                        return Duration.ofSeconds(seconds);
                    } catch (NumberFormatException e) {
                        return Duration.ofSeconds(60);
                    }
                })
                .orElse(Duration.ofSeconds(60));
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new EssabuServerException("Interruption lors du retry", 500);
        }
    }
}
