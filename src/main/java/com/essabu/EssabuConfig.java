package com.essabu;

import lombok.Builder;
import lombok.Getter;

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
}
