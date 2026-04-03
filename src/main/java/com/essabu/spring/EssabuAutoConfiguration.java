package com.essabu.spring;

import com.essabu.Essabu;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * Spring Boot auto-configuration for the Essabu SDK.
 * Automatically creates an {@link Essabu} bean when the essabu.api-key property is set.
 *
 * Usage in application.yml:
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
@AutoConfiguration
@ConditionalOnClass(Essabu.class)
@ConditionalOnProperty(prefix = "essabu", name = "api-key")
@EnableConfigurationProperties(EssabuProperties.class)
public class EssabuAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Essabu essabu(EssabuProperties properties) {
        return Essabu.builder()
                .apiKey(properties.getApiKey())
                .tenantId(properties.getTenantId())
                .baseUrl(properties.getBaseUrl())
                .connectTimeout(properties.getConnectTimeout())
                .readTimeout(properties.getReadTimeout())
                .maxRetries(properties.getMaxRetries())
                .retryDelay(properties.getRetryDelay())
                .build();
    }
}
