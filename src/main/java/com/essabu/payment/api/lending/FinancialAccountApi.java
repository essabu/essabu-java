package com.essabu.payment.api.lending;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.payment.model.lending.request.*;
import com.essabu.payment.model.lending.response.AccountTransactionResponse;
import com.essabu.payment.model.lending.response.FinancialAccountResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing financial account resources in the Essabu Payment module.
 *
 * Provides typed methods to interact with the financial account REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - update: update operation
 * - deposit: deposit operation
 * - withdraw: withdraw operation
 * - transfer: transfer operation
 *
 * Base path: /api/lending/accounts
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class FinancialAccountApi extends BaseApi {

    private static final String BASE_PATH = "/api/lending/accounts";

    public FinancialAccountApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Creates a new financial account.
     */
    public FinancialAccountResponse create(CreateFinancialAccountRequest request) {
        return http.post(BASE_PATH, request, FinancialAccountResponse.class);
    }

    /**
     * Retrieves a financial account by its identifier.
     */
    public FinancialAccountResponse getById(UUID id) {
        return http.get(BASE_PATH + "/" + id, FinancialAccountResponse.class);
    }

    /**
     * Lists the financial accounts of a company.
     */
    public PageResponse<FinancialAccountResponse> getByCompany(UUID companyId, PageRequest page) {
        String path = withParam(BASE_PATH, "companyId", companyId);
        path = withPagination(path, page);
        return http.get(path, new TypeReference<>() {});
    }

    /**
     * Updates a financial account.
     */
    public FinancialAccountResponse update(UUID id, UpdateFinancialAccountRequest request) {
        return http.put(BASE_PATH + "/" + id, request, FinancialAccountResponse.class);
    }

    /**
     * Makes a deposit to a financial account.
     */
    public AccountTransactionResponse deposit(UUID id, DepositRequest request) {
        return http.post(BASE_PATH + "/" + id + "/deposit", request, AccountTransactionResponse.class);
    }

    /**
     * Makes a withdrawal from a financial account.
     */
    public AccountTransactionResponse withdraw(UUID id, WithdrawRequest request) {
        return http.post(BASE_PATH + "/" + id + "/withdraw", request, AccountTransactionResponse.class);
    }

    /**
     * Makes a transfer between financial accounts.
     */
    public AccountTransactionResponse transfer(UUID id, TransferRequest request) {
        return http.post(BASE_PATH + "/" + id + "/transfer", request, AccountTransactionResponse.class);
    }

    /**
     * Retrieves the account statement.
     */
    public PageResponse<AccountTransactionResponse> getStatement(UUID id, PageRequest page) {
        String path = BASE_PATH + "/" + id + "/statement";
        path = withPagination(path, page);
        return http.get(path, new TypeReference<>() {});
    }
}
