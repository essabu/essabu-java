package com.essabu.accounting.api.commercial;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.accounting.model.commercial.request.CreatePriceListOverrideRequest;
import com.essabu.accounting.model.commercial.request.UpdatePriceListOverrideRequest;
import com.essabu.accounting.model.commercial.response.PriceListOverrideResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing price list override resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the price list override REST API endpoints
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
 * Base path: /api/accounting/price-lists
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class PriceListOverrideApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/price-lists";

    public PriceListOverrideApi(HttpClientWrapper http) {
        super(http);
    }

    public PriceListOverrideResponse create(UUID priceListId, CreatePriceListOverrideRequest request) {
        return http.post(BASE_PATH + "/" + priceListId + "/overrides", request, PriceListOverrideResponse.class);
    }

    public PageResponse<PriceListOverrideResponse> list(UUID priceListId, PageRequest page) {
        String path = withPagination(BASE_PATH + "/" + priceListId + "/overrides", page);
        return http.get(path, new TypeReference<>() {});
    }

    public PriceListOverrideResponse update(UUID overrideId, UpdatePriceListOverrideRequest request) {
        return http.put(BASE_PATH + "/overrides/" + overrideId, request, PriceListOverrideResponse.class);
    }

    public void delete(UUID overrideId) {
        http.delete(BASE_PATH + "/overrides/" + overrideId);
    }
}
