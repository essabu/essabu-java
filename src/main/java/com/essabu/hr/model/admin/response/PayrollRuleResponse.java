package com.essabu.hr.model.admin.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Response payload representing a payroll rule returned by the Essabu HR API.
 *
 * Contains all payroll rule information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the payroll rule resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - name: name
 * - description: description
 * - ruleType: rule type
 * - rate: rate
 * - active: active
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayrollRuleResponse {
    private UUID id;
    private String name;
    private String description;
    private String ruleType;
    private BigDecimal rate;
    private boolean active;
}
