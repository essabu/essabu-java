package com.essabu.accounting.model.transactions.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a journal returned by the Essabu Accounting API.
 *
 * Contains all journal information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the journal resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - code: code
 * - name: name
 * - type: type
 * - typeLabel: type label
 * - typeColor: type color
 * - description: description
 * - isActive: is active
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JournalResponse {
    private UUID id;
    private UUID companyId;
    private String code;
    private String name;
    private String type;
    private String typeLabel;
    private String typeColor;
    private String description;
    private boolean isActive;
    private LocalDateTime createdAt;
}
