package com.essabu.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Spring Boot configuration properties for the Essabu SDK.
 * Bind with the prefix "essabu." in application.yml or application.properties.
 *
 * <pre>
 * essabu:
 *   api-key: your-api-key
 *   tenant-id: your-tenant-id
 *   base-url: https://api.essabu.com
 * </pre>
 */
@ConfigurationProperties(prefix = "essabu")
public class EssabuProperties {

    /**
     * API key for Bearer token authentication.
     */
    private String apiKey;

    /**
     * Tenant identifier sent via X-Tenant-Id header.
     */
    private String tenantId;

    /**
     * Base URL of the Essabu API. Defaults to https://api.essabu.com.
     */
    private String baseUrl = "https://api.essabu.com";

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
