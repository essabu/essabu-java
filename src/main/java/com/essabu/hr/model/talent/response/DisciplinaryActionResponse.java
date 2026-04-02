package com.essabu.hr.model.talent.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a disciplinary action returned by the Essabu HR API.
 *
 * Contains all disciplinary action information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the disciplinary action resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - employeeId: employee id
 * - employeeName: employee name
 * - disciplinaryType: disciplinary type
 * - disciplinaryTypeLabel: disciplinary type label
 * - disciplinaryTypeColor: disciplinary type color
 * - reason: reason
 * - description: description
 * - effectiveDate: effective date
 * - expiryDate: expiry date
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - issuedBy: issued by
 * - issuedByName: issued by name
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
public class DisciplinaryActionResponse {
    private UUID id;
    private UUID employeeId;
    private String employeeName;
    private String disciplinaryType;
    private String disciplinaryTypeLabel;
    private String disciplinaryTypeColor;
    private String reason;
    private String description;
    private LocalDate effectiveDate;
    private LocalDate expiryDate;
    private String status;
    private String statusLabel;
    private String statusColor;
    private UUID issuedBy;
    private String issuedByName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
