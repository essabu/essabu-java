package com.essabu.accounting;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;

import java.util.Map;

/**
 * API client for accounting configuration and pricing operations.
 * Endpoint bases: /api/accounting/config, /api/accounting/price-lists
 */
public final class ConfigApi extends BaseApi {

    private static final String CONFIG = "/api/accounting/config";
    private static final String PRICE_LISTS = "/api/accounting/price-lists";

    public ConfigApi(HttpClientWrapper http) {
        super(http);
    }

    public Map getConfig() {
        return http.get(CONFIG, Map.class);
    }

    public Map updateConfig(Map<String, Object> request) {
        return http.put(CONFIG, request, Map.class);
    }

    public Map listPriceLists() {
        return http.get(PRICE_LISTS, Map.class);
    }

    public Map createPriceList(Map<String, Object> request) {
        return http.post(PRICE_LISTS, request, Map.class);
    }
}
