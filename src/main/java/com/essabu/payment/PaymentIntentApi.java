package com.essabu.payment;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for payment intent operations.
 * Endpoint base: /api/payment/intents
 */
public final class PaymentIntentApi extends BaseApi {

    private static final String BASE = "/api/payment/intents";

    public PaymentIntentApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(BASE, pageRequest), pageType(Map.class));
    }

    public Map getById(UUID id) { return http.get(BASE + "/" + id, Map.class); }
    public Map create(Map<String, Object> request) { return http.post(BASE, request, Map.class); }
    public Map confirm(UUID id) { return http.post(BASE + "/" + id + "/confirm", null, Map.class); }
    public Map cancel(UUID id) { return http.post(BASE + "/" + id + "/cancel", null, Map.class); }
}
