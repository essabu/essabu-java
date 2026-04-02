package com.essabu.accounting.model.finance.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Request payload for creating a exchange rate via the Essabu Accounting API.
 *
 * This data transfer object carries the parameters required to create
 * a exchange rate resource through the Accounting REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - sourceCurrencyId: source currency id
 * - targetCurrencyId: target currency id
 * - rate: rate
 * - effectiveDate: effective date
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateExchangeRateRequest {
    private UUID companyId;
    private UUID sourceCurrencyId;
    private UUID targetCurrencyId;
    private BigDecimal rate;
    private LocalDate effectiveDate;
}
