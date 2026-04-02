package com.essabu.accounting.model.finance.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a exchange rate provider returned by the Essabu Accounting API.
 *
 * Contains all exchange rate provider information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the exchange rate provider resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - name: name
 * - apiUrl: api url
 * - apiKey: api key
 * - authHeader: auth header
 * - httpMethod: http method
 * - rateJsonPath: rate json path
 * - priority: priority
 * - active: active
 * - cacheDurationMinutes: cache duration minutes
 * - baseCurrency: base currency
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateProviderResponse {
    private UUID id;
    private UUID companyId;
    private String name;
    private String apiUrl;
    private String apiKey;
    private String authHeader;
    private String httpMethod;
    private String rateJsonPath;
    private int priority;
    private boolean active;
    private int cacheDurationMinutes;
    private String baseCurrency;
    private LocalDateTime createdAt;
}
