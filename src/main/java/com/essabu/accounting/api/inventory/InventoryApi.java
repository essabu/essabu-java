package com.essabu.accounting.api.inventory;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.accounting.model.inventory.enums.InventoryCategory;
import com.essabu.accounting.model.inventory.request.CreateInventoryItemRequest;
import com.essabu.accounting.model.inventory.request.UpdateInventoryItemRequest;
import com.essabu.accounting.model.inventory.response.InventoryItemResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing inventory resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the inventory REST API endpoints
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
 * - listByCategory: list by category operation
 *
 * Base path: /api/accounting/inventory
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class InventoryApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/inventory";

    public InventoryApi(HttpClientWrapper http) {
        super(http);
    }

    public InventoryItemResponse create(CreateInventoryItemRequest request) {
        return http.post(BASE_PATH, request, InventoryItemResponse.class);
    }

    public InventoryItemResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, InventoryItemResponse.class);
    }

    public PageResponse<InventoryItemResponse> list(UUID companyId, PageRequest page) {
        String path = withPagination(BASE_PATH + "?companyId=" + companyId, page);
        return http.get(path, new TypeReference<>() {});
    }

    public InventoryItemResponse update(UUID id, UpdateInventoryItemRequest request) {
        return http.put(BASE_PATH + "/" + id, request, InventoryItemResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }

    public List<InventoryItemResponse> getLowStock(UUID companyId) {
        return http.get(BASE_PATH + "/low-stock?companyId=" + companyId, new TypeReference<>() {});
    }

    public List<InventoryItemResponse> listByCategory(UUID companyId, InventoryCategory category) {
        return http.get(BASE_PATH + "?companyId=" + companyId + "&category=" + category, new TypeReference<>() {});
    }
}
