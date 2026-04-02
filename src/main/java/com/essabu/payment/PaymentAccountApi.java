package com.essabu.payment;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for payment account and SDK key operations.
 * Endpoint bases: /api/payment/accounts, /api/payment/sdk-keys
 */
public final class PaymentAccountApi extends BaseApi {

    private static final String ACCOUNTS = "/api/payment/accounts";
    private static final String SDK_KEYS = "/api/payment/sdk-keys";

    public PaymentAccountApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(ACCOUNTS, pageRequest), pageType(Map.class));
    }
    public Map getById(UUID id) { return http.get(ACCOUNTS + "/" + id, Map.class); }
    public Map create(Map<String, Object> request) { return http.post(ACCOUNTS, request, Map.class); }
    public Map update(UUID id, Map<String, Object> request) { return http.put(ACCOUNTS + "/" + id, request, Map.class); }

    // -- SDK Keys --
    public PageResponse<Map> listSdkKeys(PageRequest pageRequest) {
        return http.get(withPagination(SDK_KEYS, pageRequest), pageType(Map.class));
    }
    public Map createSdkKey(Map<String, Object> request) { return http.post(SDK_KEYS, request, Map.class); }
    public void revokeSdkKey(UUID id) { http.delete(SDK_KEYS + "/" + id); }
}
