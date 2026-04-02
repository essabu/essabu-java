package com.essabu.trade.api.commerce;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.trade.model.commerce.request.CreateSalesOrderRequest;
import com.essabu.trade.model.commerce.response.SalesOrderResponse;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing sales order resources in the Essabu Trade module.
 *
 * Provides typed methods to interact with the sales order REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - confirm: confirm operation
 *
 * Base path: /api/trade/sales-orders
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class SalesOrderApi extends BaseApi {

    private static final String BASE_PATH = "/api/trade/sales-orders";

    public SalesOrderApi(HttpClientWrapper http) {
        super(http);
    }

    public SalesOrderResponse create(CreateSalesOrderRequest request) {
        return http.post(BASE_PATH, request, SalesOrderResponse.class);
    }

    public SalesOrderResponse confirm(UUID id) {
        return http.post(BASE_PATH + "/" + id + "/confirm", SalesOrderResponse.class);
    }

    public PageResponse<SalesOrderResponse> getAll(UUID companyId, PageRequest page) {
        String path = withPagination(withParam(BASE_PATH, "companyId", companyId), page);
        return http.get(path, new TypeReference<>() {});
    }

    public SalesOrderResponse getById(UUID id) {
        return http.get(BASE_PATH + "/" + id, SalesOrderResponse.class);
    }
}
