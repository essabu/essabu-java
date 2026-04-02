package com.essabu.common.internal;

import java.net.http.HttpRequest;

/**
 * Adds authentication and tenant headers to outgoing HTTP requests.
 * Injects the Bearer token via the Authorization header and the tenant
 * identifier via the X-Tenant-Id header.
 */
public final class AuthInterceptor {

    private final String apiKey;
    private final String tenantId;

    public AuthInterceptor(String apiKey, String tenantId) {
        this.apiKey = apiKey;
        this.tenantId = tenantId;
    }

    /**
     * Apply authentication headers to the given request builder.
     */
    public HttpRequest.Builder apply(HttpRequest.Builder builder) {
        builder.header("Authorization", "Bearer " + apiKey);
        if (tenantId != null && !tenantId.isBlank()) {
            builder.header("X-Tenant-Id", tenantId);
        }
        builder.header("Content-Type", "application/json");
        builder.header("Accept", "application/json");
        return builder;
    }
}
