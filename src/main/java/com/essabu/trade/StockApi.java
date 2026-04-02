package com.essabu.trade;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for stock management operations (levels, movements, lots, serial numbers, reorder rules, inventory counts).
 * Endpoint bases: /api/trade/stock-levels, /api/trade/stock-movements, /api/trade/stock-lots,
 * /api/trade/serial-numbers, /api/trade/reorder-rules, /api/trade/inventory-counts
 */
public final class StockApi extends BaseApi {

    private static final String LEVELS = "/api/trade/stock-levels";
    private static final String MOVEMENTS = "/api/trade/stock-movements";
    private static final String LOTS = "/api/trade/stock-lots";
    private static final String SERIALS = "/api/trade/serial-numbers";
    private static final String REORDER = "/api/trade/reorder-rules";
    private static final String COUNTS = "/api/trade/inventory-counts";

    public StockApi(HttpClientWrapper http) {
        super(http);
    }

    // -- Stock Levels --
    public PageResponse<Map> listLevels(PageRequest pageRequest) {
        return http.get(withPagination(LEVELS, pageRequest), pageType(Map.class));
    }

    // -- Stock Movements --
    public PageResponse<Map> listMovements(PageRequest pageRequest) {
        return http.get(withPagination(MOVEMENTS, pageRequest), pageType(Map.class));
    }
    public Map createMovement(Map<String, Object> request) { return http.post(MOVEMENTS, request, Map.class); }

    // -- Stock Lots --
    public PageResponse<Map> listLots(PageRequest pageRequest) {
        return http.get(withPagination(LOTS, pageRequest), pageType(Map.class));
    }
    public Map createLot(Map<String, Object> request) { return http.post(LOTS, request, Map.class); }

    // -- Serial Numbers --
    public PageResponse<Map> listSerialNumbers(PageRequest pageRequest) {
        return http.get(withPagination(SERIALS, pageRequest), pageType(Map.class));
    }

    // -- Reorder Rules --
    public PageResponse<Map> listReorderRules(PageRequest pageRequest) {
        return http.get(withPagination(REORDER, pageRequest), pageType(Map.class));
    }
    public Map createReorderRule(Map<String, Object> request) { return http.post(REORDER, request, Map.class); }
    public Map updateReorderRule(UUID id, Map<String, Object> request) { return http.put(REORDER + "/" + id, request, Map.class); }
    public void deleteReorderRule(UUID id) { http.delete(REORDER + "/" + id); }

    // -- Inventory Counts --
    public PageResponse<Map> listInventoryCounts(PageRequest pageRequest) {
        return http.get(withPagination(COUNTS, pageRequest), pageType(Map.class));
    }
    public Map createInventoryCount(Map<String, Object> request) { return http.post(COUNTS, request, Map.class); }
}
