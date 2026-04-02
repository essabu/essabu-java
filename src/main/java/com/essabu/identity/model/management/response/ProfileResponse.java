package com.essabu.identity.model.management.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a profile returned by the Essabu Identity API.
 *
 * Contains all profile information returned by the Identity REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the profile resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - firstName: first name
 * - lastName: last name
 * - email: email
 * - phone: phone
 * - avatarUrl: avatar url
 * - emailVerified: email verified
 * - twoFactorEnabled: two factor enabled
 * - companies: companies
 * - createdAt: created at
 * - companyId: company id
 * - companyName: company name
 * - roles: roles
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileResponse {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String avatarUrl;
    private boolean emailVerified;
    private boolean twoFactorEnabled;
    private List<CompanyMembership> companies;
    private LocalDateTime createdAt;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CompanyMembership {
        private UUID companyId;
        private String companyName;
        private List<String> roles;
    }
}
