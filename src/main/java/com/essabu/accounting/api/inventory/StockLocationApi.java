package com.essabu.accounting.api.inventory;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.accounting.model.inventory.request.CreateStockLocationRequest;
import com.essabu.accounting.model.inventory.request.UpdateStockLocationRequest;
import com.essabu.accounting.model.inventory.response.StockLocationResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing stock location resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the stock location REST API endpoints
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
 *
 * Base path: /api/accounting/stock-locations
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class StockLocationApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/stock-locations";

    public StockLocationApi(HttpClientWrapper http) {
        super(http);
    }

    public StockLocationResponse create(CreateStockLocationRequest request) {
        return http.post(BASE_PATH, request, StockLocationResponse.class);
    }

    public StockLocationResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, StockLocationResponse.class);
    }

    public List<StockLocationResponse> list(UUID companyId) {
        return http.get(BASE_PATH + "?companyId=" + companyId, new TypeReference<>() {});
    }

    public StockLocationResponse update(UUID id, UpdateStockLocationRequest request) {
        return http.put(BASE_PATH + "/" + id, request, StockLocationResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }
}
