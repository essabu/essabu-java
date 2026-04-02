package com.essabu.accounting;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for accounting payment and payment term operations.
 * Endpoint bases: /api/accounting/payments, /api/accounting/payment-terms, /api/accounting/payment-schedules
 */
public final class PaymentApi extends BaseApi {

    private static final String PAYMENTS = "/api/accounting/payments";
    private static final String TERMS = "/api/accounting/payment-terms";
    private static final String SCHEDULES = "/api/accounting/payment-schedules";

    public PaymentApi(HttpClientWrapper http) {
        super(http);
    }

    // -- Payments --

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(PAYMENTS, pageRequest), pageType(Map.class));
    }

    public Map getById(UUID id) {
        return http.get(PAYMENTS + "/" + id, Map.class);
    }

    public Map create(Map<String, Object> request) {
        return http.post(PAYMENTS, request, Map.class);
    }

    public Map update(UUID id, Map<String, Object> request) {
        return http.put(PAYMENTS + "/" + id, request, Map.class);
    }

    public void delete(UUID id) {
        http.delete(PAYMENTS + "/" + id);
    }

    // -- Payment Terms --

    public PageResponse<Map> listTerms(PageRequest pageRequest) {
        return http.get(withPagination(TERMS, pageRequest), pageType(Map.class));
    }

    public Map getTermById(UUID id) {
        return http.get(TERMS + "/" + id, Map.class);
    }

    public Map createTerm(Map<String, Object> request) {
        return http.post(TERMS, request, Map.class);
    }

    public Map updateTerm(UUID id, Map<String, Object> request) {
        return http.put(TERMS + "/" + id, request, Map.class);
    }

    public void deleteTerm(UUID id) {
        http.delete(TERMS + "/" + id);
    }

    // -- Payment Schedules --

    public PageResponse<Map> listSchedules(PageRequest pageRequest) {
        return http.get(withPagination(SCHEDULES, pageRequest), pageType(Map.class));
    }

    public Map getScheduleById(UUID id) {
        return http.get(SCHEDULES + "/" + id, Map.class);
    }

    public Map createSchedule(Map<String, Object> request) {
        return http.post(SCHEDULES, request, Map.class);
    }
}
