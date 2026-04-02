package com.essabu.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

/**
 * Spring Boot configuration properties for the Essabu SDK.
 *
 * Maps application properties under the {@code essabu} prefix to typed
 * Java fields used to configure the unified SDK client.
 *
 * <p>Properties:</p>
 * <ul>
 *   <li>{@code essabu.api-key} - API authentication key (required)</li>
 *   <li>{@code essabu.tenant-id} - tenant identifier (required)</li>
 *   <li>{@code essabu.base-url} - root URL of the API (default: https://api.essabu.com)</li>
 *   <li>{@code essabu.connect-timeout} - connection timeout (default: 5s)</li>
 *   <li>{@code essabu.read-timeout} - read timeout (default: 30s)</li>
 *   <li>{@code essabu.retry-on-server-error} - max retries on 5xx (default: 3)</li>
 * </ul>
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "essabu")
public class EssabuProperties {

    private String baseUrl = "https://api.essabu.com";
    private String apiKey;
    private String tenantId;
    private Duration connectTimeout = Duration.ofSeconds(5);
    private Duration readTimeout = Duration.ofSeconds(30);
    private int retryOnServerError = 3;

    public String getBaseUrl() { return baseUrl; }
    public void setBaseUrl(String baseUrl) { this.baseUrl = baseUrl; }

    public String getApiKey() { return apiKey; }
    public void setApiKey(String apiKey) { this.apiKey = apiKey; }

    public String getTenantId() { return tenantId; }
    public void setTenantId(String tenantId) { this.tenantId = tenantId; }

    public Duration getConnectTimeout() { return connectTimeout; }
    public void setConnectTimeout(Duration connectTimeout) { this.connectTimeout = connectTimeout; }

    public Duration getReadTimeout() { return readTimeout; }
    public void setReadTimeout(Duration readTimeout) { this.readTimeout = readTimeout; }

    public int getRetryOnServerError() { return retryOnServerError; }
    public void setRetryOnServerError(int retryOnServerError) { this.retryOnServerError = retryOnServerError; }
}
