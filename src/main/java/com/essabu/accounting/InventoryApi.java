package com.essabu.accounting;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for accounting inventory operations (items, suppliers, purchase orders, stock).
 * Endpoint bases: /api/accounting/inventory, /api/accounting/suppliers, /api/accounting/purchase-orders,
 * /api/accounting/stock-locations, /api/accounting/stock-movements, /api/accounting/stock-counts, /api/accounting/batches
 */
public final class InventoryApi extends BaseApi {

    private static final String ITEMS = "/api/accounting/inventory";
    private static final String SUPPLIERS = "/api/accounting/suppliers";
    private static final String PO = "/api/accounting/purchase-orders";
    private static final String LOCATIONS = "/api/accounting/stock-locations";
    private static final String MOVEMENTS = "/api/accounting/stock-movements";
    private static final String COUNTS = "/api/accounting/stock-counts";
    private static final String BATCHES = "/api/accounting/batches";

    public InventoryApi(HttpClientWrapper http) {
        super(http);
    }

    // -- Inventory Items --
    public PageResponse<Map> listItems(PageRequest pageRequest) {
        return http.get(withPagination(ITEMS, pageRequest), pageType(Map.class));
    }
    public Map getItemById(UUID id) { return http.get(ITEMS + "/" + id, Map.class); }
    public Map createItem(Map<String, Object> request) { return http.post(ITEMS, request, Map.class); }
    public Map updateItem(UUID id, Map<String, Object> request) { return http.put(ITEMS + "/" + id, request, Map.class); }
    public void deleteItem(UUID id) { http.delete(ITEMS + "/" + id); }

    // -- Suppliers --
    public PageResponse<Map> listSuppliers(PageRequest pageRequest) {
        return http.get(withPagination(SUPPLIERS, pageRequest), pageType(Map.class));
    }
    public Map getSupplierById(UUID id) { return http.get(SUPPLIERS + "/" + id, Map.class); }
    public Map createSupplier(Map<String, Object> request) { return http.post(SUPPLIERS, request, Map.class); }
    public Map updateSupplier(UUID id, Map<String, Object> request) { return http.put(SUPPLIERS + "/" + id, request, Map.class); }
    public void deleteSupplier(UUID id) { http.delete(SUPPLIERS + "/" + id); }

    // -- Purchase Orders --
    public PageResponse<Map> listPurchaseOrders(PageRequest pageRequest) {
        return http.get(withPagination(PO, pageRequest), pageType(Map.class));
    }
    public Map getPurchaseOrderById(UUID id) { return http.get(PO + "/" + id, Map.class); }
    public Map createPurchaseOrder(Map<String, Object> request) { return http.post(PO, request, Map.class); }
    public Map updatePurchaseOrder(UUID id, Map<String, Object> request) { return http.put(PO + "/" + id, request, Map.class); }
    public void deletePurchaseOrder(UUID id) { http.delete(PO + "/" + id); }

    // -- Stock Locations --
    public PageResponse<Map> listStockLocations(PageRequest pageRequest) {
        return http.get(withPagination(LOCATIONS, pageRequest), pageType(Map.class));
    }
    public Map getStockLocationById(UUID id) { return http.get(LOCATIONS + "/" + id, Map.class); }
    public Map createStockLocation(Map<String, Object> request) { return http.post(LOCATIONS, request, Map.class); }

    // -- Stock Movements --
    public PageResponse<Map> listStockMovements(PageRequest pageRequest) {
        return http.get(withPagination(MOVEMENTS, pageRequest), pageType(Map.class));
    }
    public Map createStockMovement(Map<String, Object> request) { return http.post(MOVEMENTS, request, Map.class); }

    // -- Stock Counts --
    public PageResponse<Map> listStockCounts(PageRequest pageRequest) {
        return http.get(withPagination(COUNTS, pageRequest), pageType(Map.class));
    }
    public Map createStockCount(Map<String, Object> request) { return http.post(COUNTS, request, Map.class); }

    // -- Batches --
    public PageResponse<Map> listBatches(PageRequest pageRequest) {
        return http.get(withPagination(BATCHES, pageRequest), pageType(Map.class));
    }
    public Map getBatchById(UUID id) { return http.get(BATCHES + "/" + id, Map.class); }
    public Map createBatch(Map<String, Object> request) { return http.post(BATCHES, request, Map.class); }
}
