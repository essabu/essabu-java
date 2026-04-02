package com.essabu.accounting.api.inventory;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.accounting.model.inventory.request.CreateStockMovementRequest;
import com.essabu.accounting.model.inventory.response.StockMovementResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing stock movement resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the stock movement REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - list: list operation
 * - listByItem: list by item operation
 * - listByLocation: list by location operation
 *
 * Base path: /api/accounting/stock-movements
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class StockMovementApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/stock-movements";

    public StockMovementApi(HttpClientWrapper http) {
        super(http);
    }

    public StockMovementResponse create(CreateStockMovementRequest request) {
        return http.post(BASE_PATH, request, StockMovementResponse.class);
    }

    public StockMovementResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, StockMovementResponse.class);
    }

    public PageResponse<StockMovementResponse> list(UUID companyId, PageRequest page) {
        String path = withPagination(BASE_PATH + "?companyId=" + companyId, page);
        return http.get(path, new TypeReference<>() {});
    }

    public List<StockMovementResponse> listByItem(UUID inventoryItemId) {
        return http.get(BASE_PATH + "?inventoryItemId=" + inventoryItemId, new TypeReference<>() {});
    }

    public List<StockMovementResponse> listByLocation(UUID locationId) {
        return http.get(BASE_PATH + "?locationId=" + locationId, new TypeReference<>() {});
    }
}
