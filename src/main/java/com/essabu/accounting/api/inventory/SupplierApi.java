package com.essabu.accounting.api.inventory;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.accounting.model.inventory.request.CreateSupplierRequest;
import com.essabu.accounting.model.inventory.request.UpdateSupplierRequest;
import com.essabu.accounting.model.inventory.response.SupplierResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing supplier resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the supplier REST API endpoints
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
 * Base path: /api/accounting/suppliers
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class SupplierApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/suppliers";

    public SupplierApi(HttpClientWrapper http) {
        super(http);
    }

    public SupplierResponse create(CreateSupplierRequest request) {
        return http.post(BASE_PATH, request, SupplierResponse.class);
    }

    public SupplierResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, SupplierResponse.class);
    }

    public PageResponse<SupplierResponse> list(UUID companyId, PageRequest page) {
        String path = withPagination(BASE_PATH + "?companyId=" + companyId, page);
        return http.get(path, new TypeReference<>() {});
    }

    public SupplierResponse update(UUID id, UpdateSupplierRequest request) {
        return http.put(BASE_PATH + "/" + id, request, SupplierResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }
}
