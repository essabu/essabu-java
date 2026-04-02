package com.essabu.accounting.api.finance;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.accounting.model.finance.request.CreateExchangeRateRequest;
import com.essabu.accounting.model.finance.request.UpdateExchangeRateRequest;
import com.essabu.accounting.model.finance.response.ExchangeRateResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing exchange rate resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the exchange rate REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - list: list operation
 * - update: update operation
 * - delete: delete operation
 * - fetch: fetch operation
 *
 * Base path: /api/accounting/exchange-rates
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class ExchangeRateApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/exchange-rates";

    public ExchangeRateApi(HttpClientWrapper http) {
        super(http);
    }

    public ExchangeRateResponse create(CreateExchangeRateRequest request) {
        return http.post(BASE_PATH, request, ExchangeRateResponse.class);
    }

    public ExchangeRateResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, ExchangeRateResponse.class);
    }

    public List<ExchangeRateResponse> list(UUID companyId) {
        return http.get(BASE_PATH + "?companyId=" + companyId, new TypeReference<>() {});
    }

    public ExchangeRateResponse update(UUID id, UpdateExchangeRateRequest request) {
        return http.put(BASE_PATH + "/" + id, request, ExchangeRateResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }

    public ExchangeRateResponse fetch(UUID companyId, String sourceCurrency, String targetCurrency) {
        return http.get(BASE_PATH + "/fetch?companyId=" + companyId
                + "&sourceCurrency=" + sourceCurrency
                + "&targetCurrency=" + targetCurrency, ExchangeRateResponse.class);
    }
}
