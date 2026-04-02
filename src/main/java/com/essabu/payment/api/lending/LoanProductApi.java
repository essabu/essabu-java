package com.essabu.payment.api.lending;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.payment.model.lending.request.CreateLoanProductRequest;
import com.essabu.payment.model.lending.request.UpdateLoanProductRequest;
import com.essabu.payment.model.lending.response.LoanProductResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing loan product resources in the Essabu Payment module.
 *
 * Provides typed methods to interact with the loan product REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - update: update operation
 *
 * Base path: /api/lending/loan-products
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class LoanProductApi extends BaseApi {

    private static final String BASE_PATH = "/api/lending/loan-products";

    public LoanProductApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Creates a new loan product.
     */
    public LoanProductResponse create(CreateLoanProductRequest request) {
        return http.post(BASE_PATH, request, LoanProductResponse.class);
    }

    /**
     * Retrieves a loan product by its identifier.
     */
    public LoanProductResponse getById(UUID id) {
        return http.get(BASE_PATH + "/" + id, LoanProductResponse.class);
    }

    /**
     * Lists the loan products of a company.
     */
    public PageResponse<LoanProductResponse> getByCompany(UUID companyId, PageRequest page) {
        String path = withParam(BASE_PATH, "companyId", companyId);
        path = withPagination(path, page);
        return http.get(path, new TypeReference<>() {});
    }

    /**
     * Updates a loan product.
     */
    public LoanProductResponse update(UUID id, UpdateLoanProductRequest request) {
        return http.put(BASE_PATH + "/" + id, request, LoanProductResponse.class);
    }
}
