package com.essabu.accounting.model.inventory.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a supplier returned by the Essabu Accounting API.
 *
 * Contains all supplier information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the supplier resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - name: name
 * - code: code
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
public class SupplierResponse {
    private UUID id;
    private UUID companyId;
    private String name;
    private String code;
    private String contactName;
    private String email;
    private String phone;
    private String address;
    private LocalDateTime createdAt;
}
