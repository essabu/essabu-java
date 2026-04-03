package com.essabu;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EssabuConfigTest {

    @Test
    void defaultValues() {
        EssabuConfig config = EssabuConfig.builder()
                .apiKey("test-key")
                .build();

        assertThat(config.getBaseUrl()).isEqualTo("https://api.essabu.com");
        assertThat(config.getTenantId()).isNull();
        assertThat(config.getApiKey()).isEqualTo("test-key");
    }

    @Test
    void builder_setsAllFields() {
        EssabuConfig config = EssabuConfig.builder()
                .apiKey("my-key")
                .tenantId("tenant-42")
                .baseUrl("https://custom.api.com")
                .build();

        assertThat(config.getApiKey()).isEqualTo("my-key");
        assertThat(config.getTenantId()).isEqualTo("tenant-42");
        assertThat(config.getBaseUrl()).isEqualTo("https://custom.api.com");
    }

    @Test
    void builder_apiKeyCanBeNull() {
        // EssabuConfig itself does not validate; validation is in Essabu.Builder
        EssabuConfig config = EssabuConfig.builder()
                .apiKey(null)
                .build();

        assertThat(config.getApiKey()).isNull();
    }
}
