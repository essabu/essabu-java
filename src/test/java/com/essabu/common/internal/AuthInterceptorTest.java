package com.essabu.common.internal;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpRequest;

import static org.assertj.core.api.Assertions.assertThat;

class AuthInterceptorTest {

    @Test
    void addsAuthorizationHeader() {
        AuthInterceptor interceptor = new AuthInterceptor("my-api-key", "tenant-1");
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create("https://api.essabu.com/test"));

        interceptor.apply(builder);
        HttpRequest request = builder.GET().build();

        assertThat(request.headers().firstValue("Authorization"))
                .isPresent()
                .hasValue("Bearer my-api-key");
    }

    @Test
    void addsTenantIdHeader() {
        AuthInterceptor interceptor = new AuthInterceptor("my-api-key", "tenant-42");
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create("https://api.essabu.com/test"));

        interceptor.apply(builder);
        HttpRequest request = builder.GET().build();

        assertThat(request.headers().firstValue("X-Tenant-Id"))
                .isPresent()
                .hasValue("tenant-42");
    }

    @Test
    void tenantIdOmitted_whenNull() {
        AuthInterceptor interceptor = new AuthInterceptor("my-api-key", null);
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create("https://api.essabu.com/test"));

        interceptor.apply(builder);
        HttpRequest request = builder.GET().build();

        assertThat(request.headers().firstValue("X-Tenant-Id")).isEmpty();
    }

    @Test
    void tenantIdOmitted_whenBlank() {
        AuthInterceptor interceptor = new AuthInterceptor("my-api-key", "   ");
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create("https://api.essabu.com/test"));

        interceptor.apply(builder);
        HttpRequest request = builder.GET().build();

        assertThat(request.headers().firstValue("X-Tenant-Id")).isEmpty();
    }

    @Test
    void addsContentTypeHeader() {
        AuthInterceptor interceptor = new AuthInterceptor("key", "tenant");
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create("https://api.essabu.com/test"));

        interceptor.apply(builder);
        HttpRequest request = builder.GET().build();

        assertThat(request.headers().firstValue("Content-Type"))
                .isPresent()
                .hasValue("application/json");
    }

    @Test
    void addsAcceptHeader() {
        AuthInterceptor interceptor = new AuthInterceptor("key", "tenant");
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create("https://api.essabu.com/test"));

        interceptor.apply(builder);
        HttpRequest request = builder.GET().build();

        assertThat(request.headers().firstValue("Accept"))
                .isPresent()
                .hasValue("application/json");
    }
}
