package com.essabu;

import lombok.Builder;
import lombok.Getter;

import java.time.Duration;

/**
 * Configuration holder for the Essabu SDK.
 * Use the builder to set credentials and connection parameters.
 */
@Getter
@Builder
public class EssabuConfig {

    /**
     * API key used for Bearer token authentication.
     */
    private final String apiKey;

    /**
     * Tenant identifier sent via the X-Tenant-Id header.
     */
    private final String tenantId;

    /**
     * Base URL of the Essabu API. Defaults to https://api.essabu.com.
     */
    @Builder.Default
    private final String baseUrl = "https://api.essabu.com";

    /**
     * Timeout for establishing a connection. Defaults to 30 seconds.
     */
    @Builder.Default
    private final Duration connectTimeout = Duration.ofSeconds(30);

    /**
     * Timeout for reading a response. Defaults to 30 seconds.
     */
    @Builder.Default
    private final Duration readTimeout = Duration.ofSeconds(30);

    /**
     * Maximum number of retries for transient errors (5xx, 429). Defaults to 3.
     */
    @Builder.Default
    private final int maxRetries = 3;

    /**
     * Initial delay between retries (exponential backoff). Defaults to 500ms.
     */
    @Builder.Default
    private final Duration retryDelay = Duration.ofMillis(500);
}
