package com.essabu.accounting.api.inventory;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.accounting.model.inventory.request.CreatePurchaseOrderRequest;
import com.essabu.accounting.model.inventory.request.ReceivePurchaseOrderRequest;
import com.essabu.accounting.model.inventory.request.UpdatePurchaseOrderRequest;
import com.essabu.accounting.model.inventory.response.PurchaseOrderResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing purchase order resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the purchase order REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - list: list operation
 * - update: update operation
 * - delete: delete operation
 * - submit: submit operation
 * - approve: approve operation
 * - markAsOrdered: mark as ordered operation
 * - receive: receive operation
 * - cancel: cancel operation
 *
 * Base path: /api/accounting/purchase-orders
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class PurchaseOrderApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/purchase-orders";

    public PurchaseOrderApi(HttpClientWrapper http) {
        super(http);
    }

    public PurchaseOrderResponse create(CreatePurchaseOrderRequest request) {
        return http.post(BASE_PATH, request, PurchaseOrderResponse.class);
    }

    public PurchaseOrderResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, PurchaseOrderResponse.class);
    }

    public PageResponse<PurchaseOrderResponse> list(UUID companyId, PageRequest page) {
        String path = withPagination(BASE_PATH + "?companyId=" + companyId, page);
        return http.get(path, new TypeReference<>() {});
    }

    public PurchaseOrderResponse update(UUID id, UpdatePurchaseOrderRequest request) {
        return http.put(BASE_PATH + "/" + id, request, PurchaseOrderResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }

    public PurchaseOrderResponse submit(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/submit", PurchaseOrderResponse.class);
    }

    public PurchaseOrderResponse approve(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/approve", PurchaseOrderResponse.class);
    }

    public PurchaseOrderResponse markAsOrdered(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/mark-as-ordered", PurchaseOrderResponse.class);
    }

    public PurchaseOrderResponse receive(UUID id, ReceivePurchaseOrderRequest request) {
        return http.post(BASE_PATH + "/" + id + "/receive", request, PurchaseOrderResponse.class);
    }

    public PurchaseOrderResponse cancel(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/cancel", PurchaseOrderResponse.class);
    }

    public byte[] downloadPdf(UUID id) {
        return http.getBytes(BASE_PATH + "/" + id + "/pdf");
    }
}
