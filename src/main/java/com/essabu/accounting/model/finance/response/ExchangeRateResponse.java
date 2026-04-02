package com.essabu.accounting.model.finance.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Response payload representing a exchange rate returned by the Essabu Accounting API.
 *
 * Contains all exchange rate information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the exchange rate resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
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
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateResponse {
    private UUID id;
    private UUID companyId;
    private UUID sourceCurrencyId;
    private UUID targetCurrencyId;
    private BigDecimal rate;
    private LocalDate effectiveDate;
}
