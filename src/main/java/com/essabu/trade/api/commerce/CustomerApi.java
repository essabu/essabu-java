package com.essabu.trade.api.commerce;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.trade.model.commerce.request.CreateCustomerGroupRequest;
import com.essabu.trade.model.commerce.request.CreateCustomerRequest;
import com.essabu.trade.model.commerce.request.UpdateCustomerRequest;
import com.essabu.trade.model.commerce.response.CustomerGroupResponse;
import com.essabu.trade.model.commerce.response.CustomerResponse;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing customer resources in the Essabu Trade module.
 *
 * Provides typed methods to interact with the customer REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - update: update operation
 * - createGroup: create group operation
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class CustomerApi extends BaseApi {

    private static final String CUSTOMERS_PATH = "/api/trade/customers";
    private static final String GROUPS_PATH = "/api/trade/customer-groups";

    public CustomerApi(HttpClientWrapper http) {
        super(http);
    }

    // --- Customers ---

    public CustomerResponse create(CreateCustomerRequest request) {
        return http.post(CUSTOMERS_PATH, request, CustomerResponse.class);
    }

    public PageResponse<CustomerResponse> getAll(UUID companyId, PageRequest page) {
        String path = withPagination(withParam(CUSTOMERS_PATH, "companyId", companyId), page);
        return http.get(path, new TypeReference<>() {});
    }

    public CustomerResponse getById(UUID id) {
        return http.get(CUSTOMERS_PATH + "/" + id, CustomerResponse.class);
    }

    public CustomerResponse update(UUID id, UpdateCustomerRequest request) {
        return http.put(CUSTOMERS_PATH + "/" + id, request, CustomerResponse.class);
    }

    // --- Customer Groups ---

    public CustomerGroupResponse createGroup(CreateCustomerGroupRequest request) {
        return http.post(GROUPS_PATH, request, CustomerGroupResponse.class);
    }

    public PageResponse<CustomerGroupResponse> getAllGroups(UUID companyId, PageRequest page) {
        String path = withPagination(withParam(GROUPS_PATH, "companyId", companyId), page);
        return http.get(path, new TypeReference<>() {});
    }
}
