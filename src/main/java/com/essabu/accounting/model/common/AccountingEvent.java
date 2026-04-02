package com.essabu.accounting.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Accounting Event class in the Essabu Accounting SDK.
 *
 * This class is part of the Essabu Accounting SDK and provides
 * functionality related to accounting event operations. It is used internally
 * by the SDK to support the Accounting API integration and may also be
 * referenced by consuming applications when working with Accounting
 * resources and operations.
 *
 * Fields:
 * - id: id
 * - type: type
 * - tenantId: tenant id
 * - timestamp: timestamp
 * - data: data
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountingEvent {

    private String id;
    private String type;
    private String tenantId;
    private LocalDateTime timestamp;
    private Map<String, Object> data;
}
