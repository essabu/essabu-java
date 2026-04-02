package com.essabu.identity.model.management.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a user returned by the Essabu Identity API.
 *
 * Contains all user information returned by the Identity REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the user resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - firstName: first name
 * - lastName: last name
 * - email: email
 * - phone: phone
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - emailVerified: email verified
 * - twoFactorEnabled: two factor enabled
 * - roles: roles
 * - createdAt: created at
 * - updatedAt: updated at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String status;
    private String statusLabel;
    private String statusColor;
    private boolean emailVerified;
    private boolean twoFactorEnabled;
    private List<String> roles;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
