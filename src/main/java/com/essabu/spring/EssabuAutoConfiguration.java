package com.essabu.spring;

import com.essabu.Essabu;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * Spring Boot auto-configuration for the Essabu SDK.
 *
 * Automatically creates and configures an {@link Essabu} bean when the
 * application property {@code essabu.api-key} is present in the environment.
 *
 * <p>Configuration example (application.yml):</p>
 * <pre>{@code
 * essabu:
 *   api-key: your-api-key
 *   tenant-id: your-tenant-id
 *   base-url: https://api.essabu.com  # optional, default
 * }</pre>
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@AutoConfiguration
@EnableConfigurationProperties(EssabuProperties.class)
@ConditionalOnProperty(prefix = "essabu", name = "api-key")
public class EssabuAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Essabu essabu(EssabuProperties properties) {
        return Essabu.builder()
                .baseUrl(properties.getBaseUrl())
                .apiKey(properties.getApiKey())
                .tenantId(properties.getTenantId())
                .connectTimeout(properties.getConnectTimeout())
                .readTimeout(properties.getReadTimeout())
                .retryOnServerError(properties.getRetryOnServerError())
                .build();
    }
}
