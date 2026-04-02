package com.essabu.common.internal;

import com.essabu.EssabuConfig;

import java.net.http.HttpRequest;
import java.util.Map;

/**
 * Authentication interceptor that applies security headers to outgoing HTTP requests.
 * This is an internal component not intended for direct use by SDK consumers.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class AuthInterceptor {

    private final String apiKey;
    private final String tenantId;

    public AuthInterceptor(EssabuConfig config) {
        this.apiKey = config.getApiKey();
        this.tenantId = config.getTenantId();
    }

    /**
     * Applies authentication headers to the given request builder.
     */
    public HttpRequest.Builder applyHeaders(HttpRequest.Builder builder) {
        builder.header("Authorization", "Bearer " + apiKey);
        builder.header("X-Tenant-Id", tenantId);
        builder.header("Accept", "application/json");
        return builder;
    }

    /**
     * Returns the authentication headers as a map.
     */
    public Map<String, String> getHeaders() {
        return Map.of(
                "Authorization", "Bearer " + apiKey,
                "X-Tenant-Id", tenantId,
                "Accept", "application/json"
        );
    }
}
