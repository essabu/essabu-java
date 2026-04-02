package com.essabu.payment;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for payment transaction operations.
 * Endpoint base: /api/payment/transactions
 */
public final class TransactionApi extends BaseApi {

    private static final String BASE = "/api/payment/transactions";

    public TransactionApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(BASE, pageRequest), pageType(Map.class));
    }

    public Map getById(UUID id) {
        return http.get(BASE + "/" + id, Map.class);
    }
}
