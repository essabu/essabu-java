package com.essabu.accounting;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for chart of accounts and balance operations.
 * Endpoint bases: /api/accounting/accounts, /api/accounting/balances
 */
public final class AccountApi extends BaseApi {

    private static final String ACCOUNTS = "/api/accounting/accounts";
    private static final String BALANCES = "/api/accounting/balances";

    public AccountApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(ACCOUNTS, pageRequest), pageType(Map.class));
    }

    public Map getById(UUID id) {
        return http.get(ACCOUNTS + "/" + id, Map.class);
    }

    public Map create(Map<String, Object> request) {
        return http.post(ACCOUNTS, request, Map.class);
    }

    public Map update(UUID id, Map<String, Object> request) {
        return http.put(ACCOUNTS + "/" + id, request, Map.class);
    }

    public void delete(UUID id) {
        http.delete(ACCOUNTS + "/" + id);
    }

    // -- Balances --

    public PageResponse<Map> listBalances(PageRequest pageRequest) {
        return http.get(withPagination(BALANCES, pageRequest), pageType(Map.class));
    }

    public Map getBalance(UUID accountId) {
        return http.get(BALANCES + "/" + accountId, Map.class);
    }
}
