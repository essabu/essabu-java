package com.essabu.accounting.api.inventory;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.accounting.model.inventory.request.CreateStockCountRequest;
import com.essabu.accounting.model.inventory.response.StockCountResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing stock count resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the stock count REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - list: list operation
 * - start: start operation
 * - complete: complete operation
 * - cancel: cancel operation
 *
 * Base path: /api/accounting/stock-counts
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class StockCountApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/stock-counts";

    public StockCountApi(HttpClientWrapper http) {
        super(http);
    }

    public StockCountResponse create(CreateStockCountRequest request) {
        return http.post(BASE_PATH, request, StockCountResponse.class);
    }

    public StockCountResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, StockCountResponse.class);
    }

    public PageResponse<StockCountResponse> list(UUID companyId, PageRequest page) {
        String path = withPagination(BASE_PATH + "?companyId=" + companyId, page);
        return http.get(path, new TypeReference<>() {});
    }

    public StockCountResponse start(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/start", StockCountResponse.class);
    }

    public StockCountResponse complete(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/complete", StockCountResponse.class);
    }

    public StockCountResponse cancel(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/cancel", StockCountResponse.class);
    }
}
