package com.essabu.accounting.api.commercial;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.accounting.model.commercial.request.CreateInsuranceContractRequest;
import com.essabu.accounting.model.commercial.request.UpdateInsuranceContractRequest;
import com.essabu.accounting.model.commercial.response.InsuranceContractResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing insurance contract resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the insurance contract REST API endpoints
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
 * - suspend: suspend operation
 * - reactivate: reactivate operation
 * - listByCustomer: list by customer operation
 * - listByPartner: list by partner operation
 *
 * Base path: /api/accounting/insurance-contracts
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class InsuranceContractApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/insurance-contracts";

    public InsuranceContractApi(HttpClientWrapper http) {
        super(http);
    }

    public InsuranceContractResponse create(CreateInsuranceContractRequest request) {
        return http.post(BASE_PATH, request, InsuranceContractResponse.class);
    }

    public InsuranceContractResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, InsuranceContractResponse.class);
    }

    public PageResponse<InsuranceContractResponse> list(UUID companyId, PageRequest page) {
        String path = withPagination(BASE_PATH + "?companyId=" + companyId, page);
        return http.get(path, new TypeReference<>() {});
    }

    public InsuranceContractResponse update(UUID id, UpdateInsuranceContractRequest request) {
        return http.put(BASE_PATH + "/" + id, request, InsuranceContractResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }

    public InsuranceContractResponse suspend(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/suspend", InsuranceContractResponse.class);
    }

    public InsuranceContractResponse reactivate(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/reactivate", InsuranceContractResponse.class);
    }

    public List<InsuranceContractResponse> listByCustomer(UUID customerId) {
        return http.get(BASE_PATH + "?customerId=" + customerId, new TypeReference<>() {});
    }

    public List<InsuranceContractResponse> listByPartner(UUID partnerId) {
        return http.get(BASE_PATH + "?partnerId=" + partnerId, new TypeReference<>() {});
    }

    public List<InsuranceContractResponse> getExpiring(int withinDays) {
        return http.get(BASE_PATH + "/expiring?withinDays=" + withinDays, new TypeReference<>() {});
    }
}
