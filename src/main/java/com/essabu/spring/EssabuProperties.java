package com.essabu.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

/**
 * Spring Boot configuration properties for the Essabu SDK.
 * Bind with the prefix "essabu." in application.yml or application.properties.
 *
 * <pre>
 * essabu:
 *   api-key: your-api-key
 *   tenant-id: your-tenant-id
 *   base-url: https://api.essabu.com
 *   connect-timeout: 30s
 *   read-timeout: 30s
 *   max-retries: 3
 *   retry-delay: 500ms
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

    /**
     * Timeout for establishing a connection. Defaults to 30 seconds.
     */
    private Duration connectTimeout = Duration.ofSeconds(30);

    /**
     * Timeout for reading a response. Defaults to 30 seconds.
     */
    private Duration readTimeout = Duration.ofSeconds(30);

    /**
     * Maximum number of retries for transient errors. Defaults to 3.
     */
    private int maxRetries = 3;

    /**
     * Initial delay between retries (exponential backoff). Defaults to 500ms.
     */
    private Duration retryDelay = Duration.ofMillis(500);

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

    public Duration getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Duration connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Duration getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(Duration readTimeout) {
        this.readTimeout = readTimeout;
    }

    public int getMaxRetries() {
        return maxRetries;
    }

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public Duration getRetryDelay() {
        return retryDelay;
    }

    public void setRetryDelay(Duration retryDelay) {
        this.retryDelay = retryDelay;
    }
}
