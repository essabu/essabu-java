package com.essabu.identity.api.management;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.identity.model.management.request.UpdateProfileRequest;
import com.essabu.identity.model.management.response.ProfileResponse;

import java.util.UUID;

/**
 * API client for managing profile resources in the Essabu Identity module.
 *
 * Provides typed methods to interact with the profile REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - updateMyProfile: update my profile operation
 *
 * Base path: /api/identity/users
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class ProfileApi extends BaseApi {

    private static final String BASE_PATH = "/api/identity/users";

    public ProfileApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Retrieves the current user's profile.
     */
    public ProfileResponse getMyProfile() {
        return http.get(BASE_PATH + "/profile", ProfileResponse.class);
    }

    /**
     * Updates the current user's profile.
     */
    public ProfileResponse updateMyProfile(UpdateProfileRequest request) {
        return http.put(BASE_PATH + "/profile", request, ProfileResponse.class);
    }

    /**
     * Retrieves a user's profile by their identifier.
     */
    public ProfileResponse getUserProfile(UUID userId) {
        return http.get(BASE_PATH + "/" + userId, ProfileResponse.class);
    }
}
