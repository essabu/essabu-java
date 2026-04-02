package com.essabu;

import lombok.Builder;
import lombok.Getter;

import java.time.Duration;

/**
 * Global configuration settings for the Essabu SDK.
 *
 * Holds all parameters needed to initialize the Essabu client including
 * the API base URL, authentication API key, and tenant identifier.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Getter
@Builder
public class EssabuConfig {

    /**
     * Base URL of the Essabu API (e.g., "https://api.essabu.com").
     */
    private final String baseUrl;

    /**
     * API key for authentication.
     */
    private final String apiKey;

    /**
     * Tenant identifier (company ID).
     */
    private final String tenantId;

    /**
     * Connection timeout. Defaults to 5 seconds.
     */
    @Builder.Default
    private final Duration connectTimeout = Duration.ofSeconds(5);

    /**
     * Read timeout. Defaults to 30 seconds.
     */
    @Builder.Default
    private final Duration readTimeout = Duration.ofSeconds(30);

    /**
     * Number of retry attempts on 5xx server errors. Defaults to 3.
     */
    @Builder.Default
    private final int retryOnServerError = 3;
}
