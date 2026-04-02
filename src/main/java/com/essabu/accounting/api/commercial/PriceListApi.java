package com.essabu.accounting.api.commercial;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.accounting.model.commercial.request.*;
import com.essabu.accounting.model.commercial.response.PriceListItemResponse;
import com.essabu.accounting.model.commercial.response.PriceListResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing price list resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the price list REST API endpoints
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
 * - createItem: create item operation
 * - updateItem: update item operation
 * - deleteItem: delete item operation
 *
 * Base path: /api/accounting/price-lists
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class PriceListApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/price-lists";

    public PriceListApi(HttpClientWrapper http) {
        super(http);
    }

    public PriceListResponse create(CreatePriceListRequest request) {
        return http.post(BASE_PATH, request, PriceListResponse.class);
    }

    public PriceListResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, PriceListResponse.class);
    }

    public PageResponse<PriceListResponse> list(UUID companyId, PageRequest page) {
        String path = withPagination(BASE_PATH + "?companyId=" + companyId, page);
        return http.get(path, new TypeReference<>() {});
    }

    public PriceListResponse update(UUID id, UpdatePriceListRequest request) {
        return http.put(BASE_PATH + "/" + id, request, PriceListResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }

    public PriceListResponse setDefault(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/set-default", PriceListResponse.class);
    }

    // Items
    public PriceListItemResponse createItem(UUID priceListId, CreatePriceListItemRequest request) {
        return http.post(BASE_PATH + "/" + priceListId + "/items", request, PriceListItemResponse.class);
    }

    public PageResponse<PriceListItemResponse> getItems(UUID priceListId, PageRequest page) {
        String path = withPagination(BASE_PATH + "/" + priceListId + "/items", page);
        return http.get(path, new TypeReference<>() {});
    }

    public PriceListItemResponse updateItem(UUID itemId, UpdatePriceListItemRequest request) {
        return http.put(BASE_PATH + "/items/" + itemId, request, PriceListItemResponse.class);
    }

    public void deleteItem(UUID itemId) {
        http.delete(BASE_PATH + "/items/" + itemId);
    }
}
