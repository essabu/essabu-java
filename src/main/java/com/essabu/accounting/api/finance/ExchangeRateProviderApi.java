package com.essabu.accounting.api.finance;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.accounting.model.finance.request.CreateExchangeRateProviderRequest;
import com.essabu.accounting.model.finance.request.UpdateExchangeRateProviderRequest;
import com.essabu.accounting.model.finance.response.ExchangeRateProviderResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * API client for managing exchange rate provider resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the exchange rate provider REST API endpoints
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
 * - test: test operation
 *
 * Base path: /api/accounting/exchange-rate-providers
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class ExchangeRateProviderApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/exchange-rate-providers";

    public ExchangeRateProviderApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Creates a new exchange rate provider.
     *
     * @param request the provider creation data
     * @return the created provider
     */
    public ExchangeRateProviderResponse create(CreateExchangeRateProviderRequest request) {
        return http.post(BASE_PATH, request, ExchangeRateProviderResponse.class);
    }

    /**
     * Retrieves an exchange rate provider by its identifier.
     *
     * @param id the provider identifier
     * @return the found provider
     */
    public ExchangeRateProviderResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, ExchangeRateProviderResponse.class);
    }

    /**
     * Lists the exchange rate providers of a company.
     *
     * @param companyId identifier of the company
     * @return the list of providers
     */
    public List<ExchangeRateProviderResponse> list(UUID companyId) {
        return http.get(BASE_PATH + "?companyId=" + companyId, new TypeReference<>() {});
    }

    /**
     * Updates an exchange rate provider.
     *
     * @param id the provider identifier
     * @param request the update data
     * @return the updated provider
     */
    public ExchangeRateProviderResponse update(UUID id, UpdateExchangeRateProviderRequest request) {
        return http.put(BASE_PATH + "/" + id, request, ExchangeRateProviderResponse.class);
    }

    /**
     * Deletes an exchange rate provider.
     *
     * @param id the provider identifier
     */
    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }

    /**
     * Tests an exchange rate provider in real time.
     *
     * @param id the provider identifier
     * @param sourceCurrency source currency (e.g. USD)
     * @param targetCurrency target currency (e.g. CDF)
     * @return a map containing the test result (providerId, providerName, rate, status)
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> test(UUID id, String sourceCurrency, String targetCurrency) {
        return http.postEmpty(BASE_PATH + "/" + id + "/test?source=" + sourceCurrency
                + "&target=" + targetCurrency, Map.class);
    }
}
