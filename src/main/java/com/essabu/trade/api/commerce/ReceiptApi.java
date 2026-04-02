package com.essabu.trade.api.commerce;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.trade.model.commerce.request.CreateGoodsReceiptRequest;
import com.essabu.trade.model.commerce.response.GoodsReceiptResponse;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing receipt resources in the Essabu Trade module.
 *
 * Provides typed methods to interact with the receipt REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - accept: accept operation
 *
 * Base path: /api/trade/goods-receipts
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class ReceiptApi extends BaseApi {

    private static final String BASE_PATH = "/api/trade/goods-receipts";

    public ReceiptApi(HttpClientWrapper http) {
        super(http);
    }

    public GoodsReceiptResponse create(CreateGoodsReceiptRequest request) {
        return http.post(BASE_PATH, request, GoodsReceiptResponse.class);
    }

    public GoodsReceiptResponse accept(UUID id) {
        return http.post(BASE_PATH + "/" + id + "/accept", GoodsReceiptResponse.class);
    }

    public PageResponse<GoodsReceiptResponse> getAll(UUID companyId, PageRequest page) {
        String path = withPagination(withParam(BASE_PATH, "companyId", companyId), page);
        return http.get(path, new TypeReference<>() {});
    }
}
