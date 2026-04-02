package com.essabu.trade;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for warehouse and transfer order operations.
 * Endpoint bases: /api/trade/warehouses, /api/trade/transfer-orders
 */
public final class WarehouseApi extends BaseApi {

    private static final String WAREHOUSES = "/api/trade/warehouses";
    private static final String TRANSFERS = "/api/trade/transfer-orders";

    public WarehouseApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(WAREHOUSES, pageRequest), pageType(Map.class));
    }

    public Map getById(UUID id) { return http.get(WAREHOUSES + "/" + id, Map.class); }
    public Map create(Map<String, Object> request) { return http.post(WAREHOUSES, request, Map.class); }
    public Map update(UUID id, Map<String, Object> request) { return http.put(WAREHOUSES + "/" + id, request, Map.class); }
    public void delete(UUID id) { http.delete(WAREHOUSES + "/" + id); }

    // -- Transfer Orders --
    public PageResponse<Map> listTransfers(PageRequest pageRequest) {
        return http.get(withPagination(TRANSFERS, pageRequest), pageType(Map.class));
    }
    public Map getTransferById(UUID id) { return http.get(TRANSFERS + "/" + id, Map.class); }
    public Map createTransfer(Map<String, Object> request) { return http.post(TRANSFERS, request, Map.class); }
    public Map updateTransfer(UUID id, Map<String, Object> request) { return http.put(TRANSFERS + "/" + id, request, Map.class); }
}
