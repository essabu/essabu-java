package com.essabu.trade.model.crm.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a contact returned by the Essabu Trade API.
 *
 * Contains all contact information returned by the Trade REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the contact resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - firstName: first name
 * - lastName: last name
 * - email: email
 * - phone: phone
 * - company: company
 * - position: position
 * - source: source
 * - assignedToUserId: assigned to user id
 * - slug: slug
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
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
public class ContactResponse {
    private UUID id;
    private UUID companyId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String company;
    private String position;
    private String source;
    private UUID assignedToUserId;
    private String slug;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
