package com.essabu.identity;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;

import java.util.Map;

/**
 * API client for authentication operations.
 * Endpoint base: /api/identity/auth
 */
public final class AuthApi extends BaseApi {

    private static final String BASE = "/api/identity/auth";

    public AuthApi(HttpClientWrapper http) {
        super(http);
    }

    public Map login(Map<String, Object> request) {
        return http.post(BASE + "/login", request, Map.class);
    }

    public Map refresh(Map<String, Object> request) {
        return http.post(BASE + "/refresh", request, Map.class);
    }

    public Map register(Map<String, Object> request) {
        return http.post(BASE + "/register", request, Map.class);
    }

    public Map verifyEmail(Map<String, Object> request) {
        return http.post(BASE + "/verify-email", request, Map.class);
    }

    public Map forgotPassword(Map<String, Object> request) {
        return http.post(BASE + "/forgot-password", request, Map.class);
    }

    public Map resetPassword(Map<String, Object> request) {
        return http.post(BASE + "/reset-password", request, Map.class);
    }

    public void logout() {
        http.delete(BASE + "/logout");
    }

    public Map confirmRegistration(Map<String, Object> request) {
        return http.post(BASE + "/confirm-registration", request, Map.class);
    }

    public Map resendConfirmation(Map<String, Object> request) {
        return http.post(BASE + "/resend-confirmation", request, Map.class);
    }

    // -- Two-Factor Authentication --

    public Map enable2FA(Map<String, Object> request) {
        return http.post(BASE + "/2fa/enable", request, Map.class);
    }

    public Map verify2FA(Map<String, Object> request) {
        return http.post(BASE + "/2fa/verify", request, Map.class);
    }

    public Map generateRecoveryCodes() {
        return http.post(BASE + "/2fa/recovery-codes", null, Map.class);
    }

    public Map get2FAStatus() {
        return http.get(BASE + "/2fa/status", Map.class);
    }
}
