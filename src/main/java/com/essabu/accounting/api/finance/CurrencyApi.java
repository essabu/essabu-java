package com.essabu.accounting.api.finance;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.accounting.model.finance.request.CreateCurrencyRequest;
import com.essabu.accounting.model.finance.request.UpdateCurrencyRequest;
import com.essabu.accounting.model.finance.response.CurrencyResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing currency resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the currency REST API endpoints
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
 * Base path: /api/accounting/currencies
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class CurrencyApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/currencies";

    public CurrencyApi(HttpClientWrapper http) {
        super(http);
    }

    public CurrencyResponse create(CreateCurrencyRequest request) {
        return http.post(BASE_PATH, request, CurrencyResponse.class);
    }

    public CurrencyResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, CurrencyResponse.class);
    }

    public List<CurrencyResponse> list() {
        return http.get(BASE_PATH, new TypeReference<>() {});
    }

    public CurrencyResponse update(UUID id, UpdateCurrencyRequest request) {
        return http.put(BASE_PATH + "/" + id, request, CurrencyResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }

    public CurrencyResponse setDefault(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/set-default", CurrencyResponse.class);
    }
}
