package examples;

import com.essabu.Essabu;
import com.essabu.common.exception.EssabuApiException;
import com.essabu.common.exception.EssabuUnauthorizedException;
import com.essabu.common.exception.EssabuValidationException;
import com.essabu.identity.model.auth.request.LoginRequest;
import com.essabu.identity.model.auth.request.RegisterRequest;
import com.essabu.identity.model.auth.request.ForgotPasswordRequest;
import com.essabu.identity.model.auth.request.ResetPasswordRequest;
import com.essabu.identity.model.auth.response.LoginResponse;
import com.essabu.identity.model.auth.response.MessageResponse;

/**
 * Example: Authentication flows using the Essabu Identity module.
 *
 * Demonstrates:
 * - User login
 * - Token refresh
 * - User registration
 * - Password reset flow
 * - Two-factor authentication
 * - Logout
 */
public class Authentication {

    public static void main(String[] args) {
        Essabu essabu = Essabu.builder()
                .apiKey("sk_live_your_api_key")
                .tenantId("your-tenant-id")
                .build();

        try {
            // 1. Login with email and password
            LoginRequest loginRequest = LoginRequest.builder()
                    .email("user@example.com")
                    .password("secure-password-123")
                    .build();

            LoginResponse loginResponse = essabu.identity().auth().login(loginRequest);
            System.out.println("Login successful!");
            System.out.println("Access token: " + loginResponse.getAccessToken());
            System.out.println("Refresh token: " + loginResponse.getRefreshToken());

            // 2. Refresh the token when it expires
            LoginResponse refreshed = essabu.identity().auth().refresh(loginResponse.getRefreshToken());
            System.out.println("Token refreshed: " + refreshed.getAccessToken());

            // 3. Register a new user
            RegisterRequest registerRequest = RegisterRequest.builder()
                    .email("newuser@example.com")
                    .password("strong-password-456")
                    .firstName("Marie")
                    .lastName("Kabila")
                    .build();

            LoginResponse registered = essabu.identity().auth().register(registerRequest);
            System.out.println("User registered: " + registered.getAccessToken());

            // 4. Forgot password - sends a reset email
            ForgotPasswordRequest forgotRequest = ForgotPasswordRequest.builder()
                    .email("user@example.com")
                    .build();

            MessageResponse forgotResponse = essabu.identity().auth().forgotPassword(forgotRequest);
            System.out.println("Password reset: " + forgotResponse.getMessage());

            // 5. Reset password with the token received by email
            ResetPasswordRequest resetRequest = ResetPasswordRequest.builder()
                    .token("reset-token-from-email")
                    .password("new-secure-password-789")
                    .build();

            MessageResponse resetResponse = essabu.identity().auth().resetPassword(resetRequest);
            System.out.println("Password reset: " + resetResponse.getMessage());

            // 6. Enable two-factor authentication
            var twoFaResponse = essabu.identity().auth().enable2FA();
            System.out.println("2FA enabled. Scan the QR code.");

            // 7. Logout - invalidate tokens
            essabu.identity().auth().logout(
                    loginResponse.getAccessToken(),
                    loginResponse.getRefreshToken()
            );
            System.out.println("Logged out successfully");

        } catch (EssabuUnauthorizedException e) {
            System.err.println("Authentication failed: " + e.getMessage());
        } catch (EssabuValidationException e) {
            System.err.println("Validation failed:");
            e.getFieldErrors().forEach((field, msg) ->
                    System.err.println("  " + field + ": " + msg));
        } catch (EssabuApiException e) {
            System.err.println("API error (HTTP " + e.getStatusCode() + "): " + e.getMessage());
        }
    }
}
