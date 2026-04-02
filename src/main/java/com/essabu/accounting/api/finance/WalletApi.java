package com.essabu.accounting.api.finance;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.accounting.model.finance.request.CreateWalletRequest;
import com.essabu.accounting.model.finance.request.UpdateWalletRequest;
import com.essabu.accounting.model.finance.response.WalletResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing wallet resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the wallet REST API endpoints
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
 * - freeze: freeze operation
 * - unfreeze: unfreeze operation
 * - close: close operation
 *
 * Base path: /api/accounting/wallets
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class WalletApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/wallets";

    public WalletApi(HttpClientWrapper http) {
        super(http);
    }

    public WalletResponse create(CreateWalletRequest request) {
        return http.post(BASE_PATH, request, WalletResponse.class);
    }

    public WalletResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, WalletResponse.class);
    }

    public PageResponse<WalletResponse> list(UUID companyId, PageRequest page) {
        String path = withPagination(BASE_PATH + "?companyId=" + companyId, page);
        return http.get(path, new TypeReference<>() {});
    }

    public WalletResponse update(UUID id, UpdateWalletRequest request) {
        return http.put(BASE_PATH + "/" + id, request, WalletResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }

    public WalletResponse freeze(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/freeze", WalletResponse.class);
    }

    public WalletResponse unfreeze(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/unfreeze", WalletResponse.class);
    }

    public WalletResponse close(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/close", WalletResponse.class);
    }
}
