package com.essabu.accounting.model.finance.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Request payload for creating a exchange rate provider via the Essabu Accounting API.
 *
 * This data transfer object carries the parameters required to create
 * a exchange rate provider resource through the Accounting REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
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
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateExchangeRateProviderRequest {
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
}
