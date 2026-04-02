package com.essabu.identity.api.auth;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.identity.model.auth.request.*;
import com.essabu.identity.model.auth.response.*;

import java.util.Map;

/**
 * API client for managing auth resources in the Essabu Identity module.
 *
 * Provides typed methods to interact with the auth REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - login: login operation
 * - register: register operation
 * - refresh: refresh operation
 * - logout: logout operation
 * - verifyEmail: verify email operation
 * - forgotPassword: forgot password operation
 * - resetPassword: reset password operation
 * - enable2FA: enable2 f a operation
 * - verify2FA: verify2 f a operation
 *
 * Base path: /api/identity/auth
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class AuthApi extends BaseApi {

    private static final String BASE_PATH = "/api/identity/auth";

    public AuthApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Authenticates a user with email and password.
     */
    public LoginResponse login(LoginRequest request) {
        return http.post(BASE_PATH + "/login", request, LoginResponse.class);
    }

    /**
     * Registers a new user.
     */
    public LoginResponse register(RegisterRequest request) {
        return http.post(BASE_PATH + "/register", request, LoginResponse.class);
    }

    /**
     * Renews JWT tokens using a refresh token.
     */
    public LoginResponse refresh(String refreshToken) {
        return http.post(BASE_PATH + "/refresh", Map.of("refreshToken", refreshToken), LoginResponse.class);
    }

    /**
     * Logs out the user by invalidating their tokens.
     */
    public void logout(String accessToken, String refreshToken) {
        http.deleteWithBody(BASE_PATH + "/logout", Map.of(
                "accessToken", accessToken,
                "refreshToken", refreshToken
        ));
    }

    /**
     * Verifies a user's email address using the token received by email.
     */
    public MessageResponse verifyEmail(String token) {
        return http.post(BASE_PATH + "/verify-email?token=" + token, null, MessageResponse.class);
    }

    /**
     * Sends a password reset email.
     */
    public MessageResponse forgotPassword(ForgotPasswordRequest request) {
        return http.post(BASE_PATH + "/forgot-password", request, MessageResponse.class);
    }

    /**
     * Resets the password using the token received by email.
     */
    public MessageResponse resetPassword(ResetPasswordRequest request) {
        return http.post(BASE_PATH + "/reset-password", request, MessageResponse.class);
    }

    /**
     * Enables two-factor authentication for the current user.
     */
    public Enable2FAResponse enable2FA() {
        return http.post(BASE_PATH + "/2fa/enable", null, Enable2FAResponse.class);
    }

    /**
     * Verifies a 2FA code for the current user.
     */
    public Verify2FAResponse verify2FA(Verify2FARequest request) {
        return http.post(BASE_PATH + "/2fa/verify", request, Verify2FAResponse.class);
    }
}
