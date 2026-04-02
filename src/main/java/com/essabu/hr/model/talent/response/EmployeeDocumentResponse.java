package com.essabu.hr.model.talent.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a employee document returned by the Essabu HR API.
 *
 * Contains all employee document information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the employee document resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - employeeId: employee id
 * - employeeName: employee name
 * - documentType: document type
 * - documentTypeLabel: document type label
 * - documentTypeColor: document type color
 * - fileName: file name
 * - fileUrl: file url
 * - fileSize: file size
 * - mimeType: mime type
 * - expiryDate: expiry date
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
public class EmployeeDocumentResponse {
    private UUID id;
    private UUID employeeId;
    private String employeeName;
    private String documentType;
    private String documentTypeLabel;
    private String documentTypeColor;
    private String fileName;
    private String fileUrl;
    private long fileSize;
    private String mimeType;
    private LocalDate expiryDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
