package com.essabu.common.internal;

import com.essabu.common.exception.EssabuApiException;
import com.essabu.common.exception.RateLimitException;
import com.essabu.common.exception.ServerException;

import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.function.Supplier;

/**
 * Implements exponential backoff retry logic for transient server errors (5xx)
 * and rate-limit responses (429). Non-retryable errors are thrown immediately.
 */
public final class RetryHandler {

    private final int maxRetries;
    private final Duration initialDelay;

    public RetryHandler(int maxRetries, Duration initialDelay) {
        this.maxRetries = maxRetries;
        this.initialDelay = initialDelay;
    }

    /**
     * Default retry handler: 3 retries, 500ms initial delay.
     */
    public RetryHandler() {
        this(3, Duration.ofMillis(500));
    }

    /**
     * Execute the given HTTP call with retry logic.
     *
     * @param call supplier that performs the HTTP request
     * @return the successful HTTP response
     */
    public HttpResponse<String> executeWithRetry(Supplier<HttpResponse<String>> call) {
        int attempt = 0;
        while (true) {
            HttpResponse<String> response = call.get();
            int status = response.statusCode();

            if (status >= 200 && status < 300) {
                return response;
            }

            if (status == 429 || status >= 500) {
                attempt++;
                if (attempt > maxRetries) {
                    if (status == 429) {
                        throw new RateLimitException("Rate limit exceeded after " + maxRetries + " retries", status, response.body());
                    }
                    throw new ServerException("Server error after " + maxRetries + " retries", status, response.body());
                }
                long delay = initialDelay.toMillis() * (long) Math.pow(2, attempt - 1);
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new EssabuApiException("Retry interrupted", status, response.body());
                }
                continue;
            }

            // Non-retryable error, return for caller to handle
            return response;
        }
    }
}
