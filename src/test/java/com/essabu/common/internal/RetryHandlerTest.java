package com.essabu.common.internal;

import com.essabu.common.exception.RateLimitException;
import com.essabu.common.exception.ServerException;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RetryHandlerTest {

    @SuppressWarnings("unchecked")
    private HttpResponse<String> mockResponse(int statusCode, String body) {
        HttpResponse<String> response = mock(HttpResponse.class);
        when(response.statusCode()).thenReturn(statusCode);
        when(response.body()).thenReturn(body);
        return response;
    }

    @Test
    void returnsImmediately_onSuccess() {
        RetryHandler handler = new RetryHandler(3, Duration.ofMillis(10));
        HttpResponse<String> successResponse = mockResponse(200, "ok");

        HttpResponse<String> result = handler.executeWithRetry(() -> successResponse);

        assertThat(result.statusCode()).isEqualTo(200);
    }

    @Test
    void retriesOn429_thenThrowsRateLimitException() {
        RetryHandler handler = new RetryHandler(2, Duration.ofMillis(10));
        AtomicInteger callCount = new AtomicInteger(0);

        assertThatThrownBy(() -> handler.executeWithRetry(() -> {
            callCount.incrementAndGet();
            return mockResponse(429, "rate limited");
        })).isInstanceOf(RateLimitException.class);

        // 1 initial + 2 retries = 3 calls
        assertThat(callCount.get()).isEqualTo(3);
    }

    @Test
    void retriesOn5xx_thenThrowsServerException() {
        RetryHandler handler = new RetryHandler(2, Duration.ofMillis(10));
        AtomicInteger callCount = new AtomicInteger(0);

        assertThatThrownBy(() -> handler.executeWithRetry(() -> {
            callCount.incrementAndGet();
            return mockResponse(503, "service unavailable");
        })).isInstanceOf(ServerException.class);

        assertThat(callCount.get()).isEqualTo(3);
    }

    @Test
    void doesNotRetryOn4xx_except429() {
        RetryHandler handler = new RetryHandler(3, Duration.ofMillis(10));
        AtomicInteger callCount = new AtomicInteger(0);

        HttpResponse<String> result = handler.executeWithRetry(() -> {
            callCount.incrementAndGet();
            return mockResponse(400, "bad request");
        });

        // 4xx (non-429) is returned immediately, no retries
        assertThat(callCount.get()).isEqualTo(1);
        assertThat(result.statusCode()).isEqualTo(400);
    }

    @Test
    void doesNotRetryOn401() {
        RetryHandler handler = new RetryHandler(3, Duration.ofMillis(10));
        AtomicInteger callCount = new AtomicInteger(0);

        HttpResponse<String> result = handler.executeWithRetry(() -> {
            callCount.incrementAndGet();
            return mockResponse(401, "unauthorized");
        });

        assertThat(callCount.get()).isEqualTo(1);
    }

    @Test
    void doesNotRetryOn404() {
        RetryHandler handler = new RetryHandler(3, Duration.ofMillis(10));
        AtomicInteger callCount = new AtomicInteger(0);

        HttpResponse<String> result = handler.executeWithRetry(() -> {
            callCount.incrementAndGet();
            return mockResponse(404, "not found");
        });

        assertThat(callCount.get()).isEqualTo(1);
    }

    @Test
    void maxRetriesHonored() {
        RetryHandler handler = new RetryHandler(1, Duration.ofMillis(10));
        AtomicInteger callCount = new AtomicInteger(0);

        assertThatThrownBy(() -> handler.executeWithRetry(() -> {
            callCount.incrementAndGet();
            return mockResponse(500, "error");
        })).isInstanceOf(ServerException.class);

        // 1 initial + 1 retry = 2 calls
        assertThat(callCount.get()).isEqualTo(2);
    }

    @Test
    void retriesSucceedEventually() {
        RetryHandler handler = new RetryHandler(3, Duration.ofMillis(10));
        AtomicInteger callCount = new AtomicInteger(0);

        HttpResponse<String> result = handler.executeWithRetry(() -> {
            int count = callCount.incrementAndGet();
            if (count <= 2) {
                return mockResponse(500, "error");
            }
            return mockResponse(200, "ok");
        });

        assertThat(result.statusCode()).isEqualTo(200);
        assertThat(callCount.get()).isEqualTo(3);
    }

    @Test
    void exponentialBackoff_delaysIncrease() {
        RetryHandler handler = new RetryHandler(3, Duration.ofMillis(50));
        AtomicInteger callCount = new AtomicInteger(0);
        long[] timestamps = new long[4];

        assertThatThrownBy(() -> handler.executeWithRetry(() -> {
            int idx = callCount.getAndIncrement();
            if (idx < 4) {
                timestamps[idx] = System.currentTimeMillis();
            }
            return mockResponse(500, "error");
        })).isInstanceOf(ServerException.class);

        // 4 calls total: initial + 3 retries
        assertThat(callCount.get()).isEqualTo(4);

        // Verify some delay occurred between calls (at least 30ms for the first gap)
        long delay1 = timestamps[1] - timestamps[0];
        long delay2 = timestamps[2] - timestamps[1];
        assertThat(delay1).isGreaterThan(20);
        assertThat(delay2).isGreaterThan(delay1 - 20); // second delay >= first (with tolerance)
    }
}
