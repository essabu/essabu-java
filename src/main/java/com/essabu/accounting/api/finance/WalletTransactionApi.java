package com.essabu.accounting.api.finance;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.accounting.model.finance.request.CreateWalletTransactionRequest;
import com.essabu.accounting.model.finance.response.WalletTransactionResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing wallet transaction resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the wallet transaction REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - list: list operation
 * - listByWallet: list by wallet operation
 * - reverse: reverse operation
 *
 * Base path: /api/accounting/wallet-transactions
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class WalletTransactionApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/wallet-transactions";

    public WalletTransactionApi(HttpClientWrapper http) {
        super(http);
    }

    public WalletTransactionResponse create(CreateWalletTransactionRequest request) {
        return http.post(BASE_PATH, request, WalletTransactionResponse.class);
    }

    public WalletTransactionResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, WalletTransactionResponse.class);
    }

    public PageResponse<WalletTransactionResponse> list(UUID companyId, PageRequest page) {
        String path = withPagination(BASE_PATH + "?companyId=" + companyId, page);
        return http.get(path, new TypeReference<>() {});
    }

    public PageResponse<WalletTransactionResponse> listByWallet(UUID walletId, PageRequest page) {
        String path = withPagination(BASE_PATH + "?walletId=" + walletId, page);
        return http.get(path, new TypeReference<>() {});
    }

    public WalletTransactionResponse reverse(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/reverse", WalletTransactionResponse.class);
    }
}
