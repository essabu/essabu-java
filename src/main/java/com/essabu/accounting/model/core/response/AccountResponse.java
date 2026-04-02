package com.essabu.accounting.model.core.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a account returned by the Essabu Accounting API.
 *
 * Contains all account information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the account resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - code: code
 * - name: name
 * - accountClass: account class
 * - type: type
 * - typeLabel: type label
 * - typeColor: type color
 * - nature: nature
 * - natureLabel: nature label
 * - natureColor: nature color
 * - parentId: parent id
 * - isActive: is active
 * - description: description
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
    private UUID id;
    private UUID companyId;
    private String code;
    private String name;
    private int accountClass;
    private String type;
    private String typeLabel;
    private String typeColor;
    private String nature;
    private String natureLabel;
    private String natureColor;
    private UUID parentId;
    private boolean isActive;
    private String description;
    private LocalDateTime createdAt;
}
