package com.essabu;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EssabuTest {

    @Test
    void builder_createsInstanceCorrectly() {
        Essabu essabu = Essabu.builder()
                .apiKey("test-api-key")
                .build();

        assertThat(essabu).isNotNull();
    }

    @Test
    void builder_withAllConfigOptions() {
        Essabu essabu = Essabu.builder()
                .apiKey("test-api-key")
                .tenantId("tenant-123")
                .baseUrl("https://custom.api.com")
                .build();

        assertThat(essabu).isNotNull();
    }

    @Test
    void builder_failsWithoutApiKey() {
        assertThatThrownBy(() -> Essabu.builder().build())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("apiKey is required");
    }

    @Test
    void builder_failsWithBlankApiKey() {
        assertThatThrownBy(() -> Essabu.builder().apiKey("   ").build())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("apiKey is required");
    }

    @Test
    void lazyModuleInitialization_returnsNonNull() {
        Essabu essabu = Essabu.builder()
                .apiKey("test-api-key")
                .build();

        assertThat(essabu.hr()).isNotNull();
        assertThat(essabu.accounting()).isNotNull();
        assertThat(essabu.identity()).isNotNull();
        assertThat(essabu.trade()).isNotNull();
        assertThat(essabu.payment()).isNotNull();
        assertThat(essabu.einvoice()).isNotNull();
        assertThat(essabu.project()).isNotNull();
        assertThat(essabu.asset()).isNotNull();
        assertThat(essabu.compliance()).isNotNull();
    }

    @Test
    void lazyModuleInitialization_returnsSameInstance() {
        Essabu essabu = Essabu.builder()
                .apiKey("test-api-key")
                .build();

        assertThat(essabu.hr()).isSameAs(essabu.hr());
        assertThat(essabu.accounting()).isSameAs(essabu.accounting());
        assertThat(essabu.identity()).isSameAs(essabu.identity());
    }

    @Test
    void threadSafety_lazyInitReturnsConsistentInstance() throws InterruptedException {
        Essabu essabu = Essabu.builder()
                .apiKey("test-api-key")
                .build();

        int threadCount = 10;
        CountDownLatch latch = new CountDownLatch(1);
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        Set<Integer> identityHashes = ConcurrentHashMap.newKeySet();

        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    latch.await();
                    identityHashes.add(System.identityHashCode(essabu.hr()));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        latch.countDown();
        executor.shutdown();
        executor.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);

        assertThat(identityHashes).hasSize(1);
    }
}
