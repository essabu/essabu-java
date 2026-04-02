package com.essabu.accounting.api.inventory;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.accounting.model.inventory.request.CreateBatchRequest;
import com.essabu.accounting.model.inventory.request.UpdateBatchRequest;
import com.essabu.accounting.model.inventory.response.BatchResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing batch resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the batch REST API endpoints
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
 * - listByItem: list by item operation
 *
 * Base path: /api/accounting/batches
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class BatchApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/batches";

    public BatchApi(HttpClientWrapper http) {
        super(http);
    }

    public BatchResponse create(CreateBatchRequest request) {
        return http.post(BASE_PATH, request, BatchResponse.class);
    }

    public BatchResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, BatchResponse.class);
    }

    public PageResponse<BatchResponse> list(UUID companyId, PageRequest page) {
        String path = withPagination(BASE_PATH + "?companyId=" + companyId, page);
        return http.get(path, new TypeReference<>() {});
    }

    public BatchResponse update(UUID id, UpdateBatchRequest request) {
        return http.put(BASE_PATH + "/" + id, request, BatchResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }

    public List<BatchResponse> listByItem(UUID inventoryItemId) {
        return http.get(BASE_PATH + "?inventoryItemId=" + inventoryItemId, new TypeReference<>() {});
    }

    public List<BatchResponse> getExpiring(UUID companyId, int withinDays) {
        return http.get(BASE_PATH + "/expiring?companyId=" + companyId + "&withinDays=" + withinDays,
                new TypeReference<>() {});
    }
}
