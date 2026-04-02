package com.essabu.payment;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for payout and settlement operations.
 * Endpoint bases: /api/payment/payouts, /api/payment/settlements
 */
public final class PayoutApi extends BaseApi {

    private static final String PAYOUTS = "/api/payment/payouts";
    private static final String SETTLEMENTS = "/api/payment/settlements";

    public PayoutApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(PAYOUTS, pageRequest), pageType(Map.class));
    }

    public Map getById(UUID id) { return http.get(PAYOUTS + "/" + id, Map.class); }
    public Map create(Map<String, Object> request) { return http.post(PAYOUTS, request, Map.class); }

    // -- Settlements --
    public PageResponse<Map> listSettlements(PageRequest pageRequest) {
        return http.get(withPagination(SETTLEMENTS, pageRequest), pageType(Map.class));
    }
    public Map getSettlementById(UUID id) { return http.get(SETTLEMENTS + "/" + id, Map.class); }
}
