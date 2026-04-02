package com.essabu.trade;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for supplier and supplier invoice operations.
 * Endpoint bases: /api/trade/suppliers, /api/trade/supplier-invoices
 */
public final class SupplierApi extends BaseApi {

    private static final String SUPPLIERS = "/api/trade/suppliers";
    private static final String INVOICES = "/api/trade/supplier-invoices";

    public SupplierApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(SUPPLIERS, pageRequest), pageType(Map.class));
    }

    public Map getById(UUID id) { return http.get(SUPPLIERS + "/" + id, Map.class); }
    public Map create(Map<String, Object> request) { return http.post(SUPPLIERS, request, Map.class); }
    public Map update(UUID id, Map<String, Object> request) { return http.put(SUPPLIERS + "/" + id, request, Map.class); }
    public void delete(UUID id) { http.delete(SUPPLIERS + "/" + id); }

    // -- Supplier Invoices --
    public PageResponse<Map> listInvoices(PageRequest pageRequest) {
        return http.get(withPagination(INVOICES, pageRequest), pageType(Map.class));
    }
    public Map getInvoiceById(UUID id) { return http.get(INVOICES + "/" + id, Map.class); }
    public Map createInvoice(Map<String, Object> request) { return http.post(INVOICES, request, Map.class); }
    public Map updateInvoice(UUID id, Map<String, Object> request) { return http.put(INVOICES + "/" + id, request, Map.class); }
    public void deleteInvoice(UUID id) { http.delete(INVOICES + "/" + id); }
}
