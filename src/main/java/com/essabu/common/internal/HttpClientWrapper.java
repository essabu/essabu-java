package com.essabu.common.internal;

import com.essabu.EssabuConfig;
import com.essabu.common.exception.*;
import com.fasterxml.jackson.databind.JavaType;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;

/**
 * Low-level HTTP client wrapper built on {@link java.net.http.HttpClient}.
 * Handles request building, authentication, retry logic, response parsing
 * and error mapping for all SDK HTTP operations.
 */
public final class HttpClientWrapper {

    private static final String REQUEST_ID_HEADER = "X-Request-Id";

    private final HttpClient httpClient;
    private final AuthInterceptor auth;
    private final RetryHandler retryHandler;
    private final String baseUrl;
    private final Duration readTimeout;

    public HttpClientWrapper(EssabuConfig config) {
        String url = config.getBaseUrl();
        this.baseUrl = url.endsWith("/") ? url.substring(0, url.length() - 1) : url;
        this.auth = new AuthInterceptor(config.getApiKey(), config.getTenantId());
        this.retryHandler = new RetryHandler(config.getMaxRetries(), config.getRetryDelay());
        this.readTimeout = config.getReadTimeout();
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(config.getConnectTimeout())
                .build();
    }

    public HttpClientWrapper(String baseUrl, String apiKey, String tenantId) {
        this(EssabuConfig.builder()
                .baseUrl(baseUrl)
                .apiKey(apiKey)
                .tenantId(tenantId)
                .build());
    }

    /**
     * Returns the underlying {@link HttpClient} so it can be closed externally.
     */
    public HttpClient getHttpClient() {
        return httpClient;
    }

    /**
     * Perform a GET request and deserialize the response body.
     */
    public <T> T get(String path, Class<T> responseType) {
        HttpResponse<String> response = doRequest("GET", path, null);
        return JsonMapper.fromJson(response.body(), responseType);
    }

    /**
     * Perform a GET request and deserialize using a JavaType (for generics).
     */
    public <T> T get(String path, JavaType responseType) {
        HttpResponse<String> response = doRequest("GET", path, null);
        return JsonMapper.fromJson(response.body(), responseType);
    }

    /**
     * Perform a POST request with a JSON body and deserialize the response.
     */
    public <T> T post(String path, Object body, Class<T> responseType) {
        HttpResponse<String> response = doRequest("POST", path, body);
        return JsonMapper.fromJson(response.body(), responseType);
    }

    /**
     * Perform a PUT request with a JSON body and deserialize the response.
     */
    public <T> T put(String path, Object body, Class<T> responseType) {
        HttpResponse<String> response = doRequest("PUT", path, body);
        return JsonMapper.fromJson(response.body(), responseType);
    }

    /**
     * Perform a PATCH request with a JSON body and deserialize the response.
     */
    public <T> T patch(String path, Object body, Class<T> responseType) {
        HttpResponse<String> response = doRequest("PATCH", path, body);
        return JsonMapper.fromJson(response.body(), responseType);
    }

    /**
     * Perform a DELETE request. Returns void on success.
     */
    public void delete(String path) {
        doRequest("DELETE", path, null);
    }

    /**
     * Perform a GET request and return the raw response bytes (e.g. PDF downloads).
     */
    public byte[] getBytes(String path) {
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + path))
                    .timeout(readTimeout)
                    .method("GET", HttpRequest.BodyPublishers.noBody());
            auth.apply(builder);

            HttpResponse<byte[]> response = httpClient.send(builder.build(),
                    HttpResponse.BodyHandlers.ofByteArray());

            if (response.statusCode() >= 200 && response.statusCode() < 300) {
                return response.body();
            }
            String requestId = extractRequestId(response);
            throwApiException(response.statusCode(), new String(response.body()), requestId);
            return null; // unreachable
        } catch (EssabuApiException e) {
            throw e;
        } catch (Exception e) {
            throw new EssabuApiException("HTTP request failed: " + e.getMessage(), 0, null);
        }
    }

    /**
     * Perform a raw GET returning the response body as a String.
     */
    public String getRaw(String path) {
        HttpResponse<String> response = doRequest("GET", path, null);
        return response.body();
    }

    // ---- Internal ----

    private HttpResponse<String> doRequest(String method, String path, Object body) {
        HttpResponse<String> response = retryHandler.executeWithRetry(() -> {
            try {
                HttpRequest.BodyPublisher publisher = (body != null)
                        ? HttpRequest.BodyPublishers.ofString(JsonMapper.toJson(body))
                        : HttpRequest.BodyPublishers.noBody();

                HttpRequest.Builder builder = HttpRequest.newBuilder()
                        .uri(URI.create(baseUrl + path))
                        .timeout(readTimeout)
                        .method(method, publisher);

                auth.apply(builder);
                return httpClient.send(builder.build(), HttpResponse.BodyHandlers.ofString());
            } catch (Exception e) {
                throw new RuntimeException("HTTP request failed", e);
            }
        });

        int status = response.statusCode();
        if (status >= 200 && status < 300) {
            return response;
        }
        String requestId = extractRequestId(response);
        throwApiException(status, response.body(), requestId);
        return response; // unreachable
    }

    private void throwApiException(int status, String body, String requestId) {
        switch (status) {
            case 400 -> throw new BadRequestException("Bad request", status, body, requestId);
            case 401 -> throw new UnauthorizedException("Unauthorized", status, body, requestId);
            case 403 -> throw new ForbiddenException("Forbidden", status, body, requestId);
            case 404 -> throw new NotFoundException("Resource not found", status, body, requestId);
            case 409 -> throw new ConflictException("Conflict", status, body, requestId);
            case 422 -> throw new ValidationException("Validation failed", status, body, requestId);
            case 429 -> throw new RateLimitException("Rate limit exceeded", status, body, requestId);
            default -> {
                if (status >= 500) {
                    throw new ServerException("Server error", status, body, requestId);
                }
                throw new EssabuApiException("API error (HTTP " + status + ")", status, body, requestId);
            }
        }
    }

    private static String extractRequestId(HttpResponse<?> response) {
        Optional<String> header = response.headers().firstValue(REQUEST_ID_HEADER);
        return header.orElse(null);
    }
}
