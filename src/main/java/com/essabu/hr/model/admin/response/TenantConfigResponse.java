package com.essabu.hr.model.admin.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

/**
 * Response payload representing a tenant config returned by the Essabu HR API.
 *
 * Contains all tenant config information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the tenant config resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - tenantId: tenant id
 * - companyName: company name
 * - currency: currency
 * - timezone: timezone
 * - locale: locale
 * - settings: settings
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TenantConfigResponse {
    private UUID id;
    private String tenantId;
    private String companyName;
    private String currency;
    private String timezone;
    private String locale;
    private Map<String, Object> settings;
}
