package com.essabu.trade.api.commerce;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.trade.model.commerce.request.CreateDeliveryNoteRequest;
import com.essabu.trade.model.commerce.response.DeliveryNoteResponse;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing delivery resources in the Essabu Trade module.
 *
 * Provides typed methods to interact with the delivery REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - ship: ship operation
 *
 * Base path: /api/trade/delivery-notes
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class DeliveryApi extends BaseApi {

    private static final String BASE_PATH = "/api/trade/delivery-notes";

    public DeliveryApi(HttpClientWrapper http) {
        super(http);
    }

    public DeliveryNoteResponse create(CreateDeliveryNoteRequest request) {
        return http.post(BASE_PATH, request, DeliveryNoteResponse.class);
    }

    public DeliveryNoteResponse ship(UUID id) {
        return http.post(BASE_PATH + "/" + id + "/ship", DeliveryNoteResponse.class);
    }

    public PageResponse<DeliveryNoteResponse> getAll(UUID companyId, PageRequest page) {
        String path = withPagination(withParam(BASE_PATH, "companyId", companyId), page);
        return http.get(path, new TypeReference<>() {});
    }
}
