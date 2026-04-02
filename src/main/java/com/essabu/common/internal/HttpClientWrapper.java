package com.essabu.common.internal;

import com.essabu.EssabuConfig;
import com.essabu.common.exception.*;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Map;
import java.util.UUID;

/**
 * HTTP client wrapper that handles all network communication for the Essabu SDK.
 * This is an internal component not intended for direct use by SDK consumers.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class HttpClientWrapper {

    private final HttpClient httpClient;
    private final String baseUrl;
    private final AuthInterceptor auth;
    private final RetryHandler retryHandler;

    public HttpClientWrapper(EssabuConfig config) {
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(config.getConnectTimeout())
                .build();
        this.baseUrl = normalizeBaseUrl(config.getBaseUrl());
        this.auth = new AuthInterceptor(config);
        this.retryHandler = new RetryHandler(config.getRetryOnServerError());
    }

    public <T> T get(String path, Class<T> responseType) {
        HttpRequest request = buildRequest(path).GET().build();
        byte[] body = executeAndExtractBody(request);
        return JsonMapper.fromBytes(body, responseType);
    }

    public <T> T get(String path, TypeReference<T> responseType) {
        HttpRequest request = buildRequest(path).GET().build();
        byte[] body = executeAndExtractBody(request);
        return JsonMapper.fromBytes(body, responseType);
    }

    public <T> T post(String path, Object requestBody, Class<T> responseType) {
        byte[] jsonBody = JsonMapper.toBytes(requestBody);
        HttpRequest request = buildRequest(path)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofByteArray(jsonBody))
                .build();
        byte[] body = executeAndExtractBody(request);
        return JsonMapper.fromBytes(body, responseType);
    }

    public <T> T post(String path, Object requestBody, TypeReference<T> responseType) {
        byte[] jsonBody = JsonMapper.toBytes(requestBody);
        HttpRequest request = buildRequest(path)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofByteArray(jsonBody))
                .build();
        byte[] body = executeAndExtractBody(request);
        return JsonMapper.fromBytes(body, responseType);
    }

    public void postVoid(String path, Object requestBody) {
        byte[] jsonBody = requestBody != null ? JsonMapper.toBytes(requestBody) : new byte[0];
        HttpRequest request = buildRequest(path)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofByteArray(jsonBody))
                .build();
        execute(request);
    }

    public <T> T put(String path, Object requestBody, Class<T> responseType) {
        byte[] jsonBody = JsonMapper.toBytes(requestBody);
        HttpRequest request = buildRequest(path)
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofByteArray(jsonBody))
                .build();
        byte[] body = executeAndExtractBody(request);
        return JsonMapper.fromBytes(body, responseType);
    }

    public <T> T put(String path, Class<T> responseType) {
        HttpRequest request = buildRequest(path)
                .PUT(HttpRequest.BodyPublishers.noBody())
                .build();
        byte[] body = executeAndExtractBody(request);
        return JsonMapper.fromBytes(body, responseType);
    }

    public <T> T patch(String path, Object requestBody, Class<T> responseType) {
        byte[] jsonBody = JsonMapper.toBytes(requestBody);
        HttpRequest request = buildRequest(path)
                .header("Content-Type", "application/json")
                .method("PATCH", HttpRequest.BodyPublishers.ofByteArray(jsonBody))
                .build();
        byte[] body = executeAndExtractBody(request);
        return JsonMapper.fromBytes(body, responseType);
    }

    public void delete(String path) {
        HttpRequest request = buildRequest(path).DELETE().build();
        execute(request);
    }

    public byte[] getBytes(String path) {
        HttpRequest request = buildRequest(path).GET().build();
        return executeAndExtractBody(request);
    }

    /**
     * Performs a POST request without a body and deserializes the response.
     */
    public <T> T post(String path, Class<T> responseType) {
        HttpRequest request = buildRequest(path)
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        byte[] body = executeAndExtractBody(request);
        return JsonMapper.fromBytes(body, responseType);
    }

    /**
     * Performs a POST request without body and deserializes the response (alias for post(path, class)).
     */
    public <T> T postEmpty(String path, Class<T> responseType) {
        return post(path, responseType);
    }

    /**
     * Performs a POST request without body and without expecting a response body.
     */
    public void postEmptyVoid(String path) {
        HttpRequest request = buildRequest(path)
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        execute(request);
    }

    /**
     * Performs a POST request without body and without expecting a response body (alias).
     */
    public void postVoidNoBody(String path) {
        postEmptyVoid(path);
    }

    /**
     * Performs a PATCH request without a body and deserializes the response.
     */
    public <T> T patch(String path, Class<T> responseType) {
        HttpRequest request = buildRequest(path)
                .method("PATCH", HttpRequest.BodyPublishers.noBody())
                .build();
        byte[] body = executeAndExtractBody(request);
        return JsonMapper.fromBytes(body, responseType);
    }

    /**
     * Performs a DELETE request with a JSON body.
     */
    public void deleteWithBody(String path, Object requestBody) {
        byte[] jsonBody = JsonMapper.toBytes(requestBody);
        HttpRequest request = buildRequest(path)
                .header("Content-Type", "application/json")
                .method("DELETE", HttpRequest.BodyPublishers.ofByteArray(jsonBody))
                .build();
        execute(request);
    }

    public <T> T postMultipart(String path, Map<String, Object> parts, Class<T> responseType) {
        String boundary = UUID.randomUUID().toString();
        byte[] multipartBody = buildMultipartBody(parts, boundary);
        HttpRequest request = buildRequest(path)
                .header("Content-Type", "multipart/form-data; boundary=" + boundary)
                .POST(HttpRequest.BodyPublishers.ofByteArray(multipartBody))
                .build();
        byte[] body = executeAndExtractBody(request);
        return JsonMapper.fromBytes(body, responseType);
    }

    // ---- Private helpers ----

    private HttpRequest.Builder buildRequest(String path) {
        URI uri = URI.create(baseUrl + path);
        HttpRequest.Builder builder = HttpRequest.newBuilder().uri(uri);
        return auth.applyHeaders(builder);
    }

    private byte[] executeAndExtractBody(HttpRequest request) {
        HttpResponse<byte[]> response = execute(request);
        return response.body();
    }

    private HttpResponse<byte[]> execute(HttpRequest request) {
        HttpResponse<byte[]> response = retryHandler.executeWithRetry(() -> {
            try {
                return httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray());
            } catch (IOException e) {
                throw new EssabuServerException("Erreur de communication avec l'API", 0, e);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new EssabuServerException("Request interrupted", 0, e);
            }
        });
        handleErrorResponse(response);
        return response;
    }

    private void handleErrorResponse(HttpResponse<byte[]> response) {
        int status = response.statusCode();
        if (status >= 200 && status < 300) {
            return;
        }
        String responseBody = response.body() != null
                ? new String(response.body(), StandardCharsets.UTF_8)
                : "";
        switch (status) {
            case 400, 422 -> {
                Map<String, String> fieldErrors = extractFieldErrors(responseBody);
                throw new EssabuValidationException("Erreur de validation : " + responseBody, status, fieldErrors);
            }
            case 401 -> throw new EssabuUnauthorizedException("Unauthorized: invalid or expired API key");
            case 403 -> throw new EssabuForbiddenException("Forbidden: insufficient permissions");
            case 404 -> throw new EssabuNotFoundException("Ressource introuvable : " + responseBody);
            case 429 -> throw new EssabuRateLimitException("Rate limit exceeded", 429, java.time.Duration.ofSeconds(60));
            default -> {
                if (status >= 500) {
                    throw new EssabuServerException("Erreur serveur : " + responseBody, status);
                }
                throw new EssabuServerException("Erreur HTTP inattendue " + status + " : " + responseBody, status);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private Map<String, String> extractFieldErrors(String responseBody) {
        try {
            Map<String, Object> errorResponse = JsonMapper.fromJson(responseBody, Map.class);
            Object violations = errorResponse.get("violations");
            if (violations instanceof Map) {
                return (Map<String, String>) violations;
            }
            Object errors = errorResponse.get("errors");
            if (errors instanceof Map) {
                return (Map<String, String>) errors;
            }
        } catch (Exception ignored) {
        }
        return Map.of();
    }

    private String normalizeBaseUrl(String url) {
        if (url != null && url.endsWith("/")) {
            return url.substring(0, url.length() - 1);
        }
        return url;
    }

    private byte[] buildMultipartBody(Map<String, Object> parts, String boundary) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : parts.entrySet()) {
            sb.append("--").append(boundary).append("\r\n");
            if (entry.getValue() instanceof Path filePath) {
                sb.append("Content-Disposition: form-data; name=\"")
                        .append(entry.getKey()).append("\"; filename=\"")
                        .append(filePath.getFileName()).append("\"\r\n");
                sb.append("Content-Type: application/octet-stream\r\n\r\n");
                try {
                    sb.append(new String(java.nio.file.Files.readAllBytes(filePath), StandardCharsets.UTF_8));
                } catch (IOException e) {
                    throw new IllegalArgumentException("Impossible de lire le fichier : " + filePath, e);
                }
            } else if (entry.getValue() instanceof byte[] bytes) {
                sb.append("Content-Disposition: form-data; name=\"")
                        .append(entry.getKey()).append("\"; filename=\"upload\"\r\n");
                sb.append("Content-Type: application/octet-stream\r\n\r\n");
                sb.append(new String(bytes, StandardCharsets.UTF_8));
            } else {
                sb.append("Content-Disposition: form-data; name=\"")
                        .append(entry.getKey()).append("\"\r\n\r\n");
                sb.append(entry.getValue());
            }
            sb.append("\r\n");
        }
        sb.append("--").append(boundary).append("--\r\n");
        return sb.toString().getBytes(StandardCharsets.UTF_8);
    }
}
