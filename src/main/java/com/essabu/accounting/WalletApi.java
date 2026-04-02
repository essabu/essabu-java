package com.essabu.accounting;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for wallet and wallet transaction operations.
 * Endpoint bases: /api/accounting/wallets, /api/accounting/wallet-transactions
 */
public final class WalletApi extends BaseApi {

    private static final String WALLETS = "/api/accounting/wallets";
    private static final String TRANSACTIONS = "/api/accounting/wallet-transactions";

    public WalletApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(WALLETS, pageRequest), pageType(Map.class));
    }

    public Map getById(UUID id) {
        return http.get(WALLETS + "/" + id, Map.class);
    }

    public Map create(Map<String, Object> request) {
        return http.post(WALLETS, request, Map.class);
    }

    public Map update(UUID id, Map<String, Object> request) {
        return http.put(WALLETS + "/" + id, request, Map.class);
    }

    public void delete(UUID id) {
        http.delete(WALLETS + "/" + id);
    }

    // -- Transactions --

    public PageResponse<Map> listTransactions(UUID walletId, PageRequest pageRequest) {
        String path = withParam(TRANSACTIONS, "walletId", walletId);
        return http.get(withPagination(path, pageRequest), pageType(Map.class));
    }

    public Map getTransactionById(UUID id) {
        return http.get(TRANSACTIONS + "/" + id, Map.class);
    }

    public Map createTransaction(Map<String, Object> request) {
        return http.post(TRANSACTIONS, request, Map.class);
    }
}
