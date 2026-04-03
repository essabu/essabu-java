package com.essabu.common.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests exception hierarchy and status code mapping.
 * The actual mapping logic lives in HttpClientWrapper.throwApiException,
 * but we verify the exception types carry correct data.
 */
class ExceptionMappingTest {

    @Test
    void unauthorizedException_carriesStatusAndBody() {
        var ex = new UnauthorizedException("Unauthorized", 401, "{\"error\":\"invalid_token\"}");

        assertThat(ex).isInstanceOf(EssabuApiException.class);
        assertThat(ex.getStatusCode()).isEqualTo(401);
        assertThat(ex.getResponseBody()).isEqualTo("{\"error\":\"invalid_token\"}");
        assertThat(ex.getMessage()).isEqualTo("Unauthorized");
    }

    @Test
    void forbiddenException_carriesStatusAndBody() {
        var ex = new ForbiddenException("Forbidden", 403, "{\"error\":\"access_denied\"}");

        assertThat(ex).isInstanceOf(EssabuApiException.class);
        assertThat(ex.getStatusCode()).isEqualTo(403);
        assertThat(ex.getResponseBody()).contains("access_denied");
    }

    @Test
    void notFoundException_carriesStatusAndBody() {
        var ex = new NotFoundException("Not found", 404, "{\"error\":\"not_found\"}");

        assertThat(ex).isInstanceOf(EssabuApiException.class);
        assertThat(ex.getStatusCode()).isEqualTo(404);
    }

    @Test
    void conflictException_carriesStatusAndBody() {
        var ex = new ConflictException("Conflict", 409, "{\"error\":\"duplicate\"}");

        assertThat(ex).isInstanceOf(EssabuApiException.class);
        assertThat(ex.getStatusCode()).isEqualTo(409);
    }

    @Test
    void validationException_carriesStatusAndBody() {
        var ex = new ValidationException("Validation failed", 422, "{\"errors\":[\"name required\"]}");

        assertThat(ex).isInstanceOf(EssabuApiException.class);
        assertThat(ex.getStatusCode()).isEqualTo(422);
        assertThat(ex.getResponseBody()).contains("name required");
    }

    @Test
    void rateLimitException_carriesStatusAndBody() {
        var ex = new RateLimitException("Rate limited", 429, "{\"retry_after\":60}");

        assertThat(ex).isInstanceOf(EssabuApiException.class);
        assertThat(ex.getStatusCode()).isEqualTo(429);
    }

    @Test
    void serverException_carriesStatusAndBody() {
        var ex = new ServerException("Server error", 500, "Internal Server Error");

        assertThat(ex).isInstanceOf(EssabuApiException.class);
        assertThat(ex.getStatusCode()).isEqualTo(500);
    }

    @Test
    void badRequestException_carriesStatusAndBody() {
        var ex = new BadRequestException("Bad request", 400, "{\"error\":\"invalid_param\"}");

        assertThat(ex).isInstanceOf(EssabuApiException.class);
        assertThat(ex.getStatusCode()).isEqualTo(400);
    }

    @Test
    void baseException_forUnknown4xx() {
        var ex = new EssabuApiException("API error (HTTP 418)", 418, "I'm a teapot");

        assertThat(ex.getStatusCode()).isEqualTo(418);
        assertThat(ex.getMessage()).contains("418");
        assertThat(ex.getResponseBody()).isEqualTo("I'm a teapot");
    }

    @ParameterizedTest
    @ValueSource(ints = {500, 502, 503, 504})
    void serverException_forVariousServerErrors(int status) {
        var ex = new ServerException("Server error", status, "error");

        assertThat(ex).isInstanceOf(EssabuApiException.class);
        assertThat(ex.getStatusCode()).isEqualTo(status);
    }

    @Test
    void allExceptions_extendEssabuApiException() {
        assertThat(BadRequestException.class).isAssignableTo(EssabuApiException.class);
        assertThat(UnauthorizedException.class).isAssignableTo(EssabuApiException.class);
        assertThat(ForbiddenException.class).isAssignableTo(EssabuApiException.class);
        assertThat(NotFoundException.class).isAssignableTo(EssabuApiException.class);
        assertThat(ConflictException.class).isAssignableTo(EssabuApiException.class);
        assertThat(ValidationException.class).isAssignableTo(EssabuApiException.class);
        assertThat(RateLimitException.class).isAssignableTo(EssabuApiException.class);
        assertThat(ServerException.class).isAssignableTo(EssabuApiException.class);
    }
}
