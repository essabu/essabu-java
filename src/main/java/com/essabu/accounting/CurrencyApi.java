package com.essabu.accounting;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for currency, exchange rate, and exchange rate provider operations.
 * Endpoint bases: /api/accounting/currencies, /api/accounting/exchange-rates, /api/accounting/exchange-rate-providers
 */
public final class CurrencyApi extends BaseApi {

    private static final String CURRENCIES = "/api/accounting/currencies";
    private static final String RATES = "/api/accounting/exchange-rates";
    private static final String PROVIDERS = "/api/accounting/exchange-rate-providers";

    public CurrencyApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(CURRENCIES, pageRequest), pageType(Map.class));
    }

    public Map getById(UUID id) {
        return http.get(CURRENCIES + "/" + id, Map.class);
    }

    public Map create(Map<String, Object> request) {
        return http.post(CURRENCIES, request, Map.class);
    }

    public Map update(UUID id, Map<String, Object> request) {
        return http.put(CURRENCIES + "/" + id, request, Map.class);
    }

    public void delete(UUID id) {
        http.delete(CURRENCIES + "/" + id);
    }

    // -- Exchange Rates --

    public PageResponse<Map> listRates(PageRequest pageRequest) {
        return http.get(withPagination(RATES, pageRequest), pageType(Map.class));
    }

    public Map createRate(Map<String, Object> request) {
        return http.post(RATES, request, Map.class);
    }

    // -- Exchange Rate Providers --

    public PageResponse<Map> listProviders(PageRequest pageRequest) {
        return http.get(withPagination(PROVIDERS, pageRequest), pageType(Map.class));
    }

    public Map getProviderById(UUID id) {
        return http.get(PROVIDERS + "/" + id, Map.class);
    }

    public Map createProvider(Map<String, Object> request) {
        return http.post(PROVIDERS, request, Map.class);
    }

    public Map updateProvider(UUID id, Map<String, Object> request) {
        return http.put(PROVIDERS + "/" + id, request, Map.class);
    }
}
