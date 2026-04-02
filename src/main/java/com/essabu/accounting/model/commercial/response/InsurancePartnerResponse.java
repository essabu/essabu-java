package com.essabu.accounting.model.commercial.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a insurance partner returned by the Essabu Accounting API.
 *
 * Contains all insurance partner information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the insurance partner resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - name: name
 * - code: code
 * - type: type
 * - typeLabel: type label
 * - typeColor: type color
 * - contactName: contact name
 * - email: email
 * - phone: phone
 * - address: address
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsurancePartnerResponse {
    private UUID id;
    private UUID companyId;
    private String name;
    private String code;
    private String type;
    private String typeLabel;
    private String typeColor;
    private String contactName;
    private String email;
    private String phone;
    private String address;
    private LocalDateTime createdAt;
}
