package com.essabu.hr.api.workforce;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.BaseApi;
import com.essabu.common.model.PageResponse;
import com.essabu.hr.model.workforce.request.CreateAmendmentRequest;
import com.essabu.hr.model.workforce.request.CreateContractRequest;
import com.essabu.hr.model.workforce.request.TerminateContractRequest;
import com.essabu.hr.model.workforce.request.UpdateContractRequest;
import com.essabu.hr.model.workforce.response.ContractAmendmentResponse;
import com.essabu.hr.model.workforce.response.ContractResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing contract resources in the Essabu HR module.
 *
 * Provides typed methods to interact with the contract REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - listByEmployee: list by employee operation
 * - update: update operation
 * - renew: renew operation
 * - terminate: terminate operation
 * - createAmendment: create amendment operation
 *
 * Base path: /api/hr/contracts
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class ContractApi extends BaseApi {

    private static final String BASE_PATH = "/api/hr/contracts";

    public ContractApi(HttpClientWrapper http) {
        super(http);
    }

    public ContractResponse create(CreateContractRequest request) {
        return http.post(BASE_PATH, request, ContractResponse.class);
    }

    public ContractResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, ContractResponse.class);
    }

    public List<ContractResponse> listByEmployee(UUID employeeId) {
        return http.get(withParam(BASE_PATH, "employeeId", employeeId),
                new TypeReference<>() {});
    }

    public ContractResponse update(UUID id, UpdateContractRequest request) {
        return http.put(BASE_PATH + "/" + id, request, ContractResponse.class);
    }

    public ContractResponse renew(UUID id) {
        return http.put(BASE_PATH + "/" + id + "/renew", null, ContractResponse.class);
    }

    public ContractResponse terminate(UUID id, TerminateContractRequest request) {
        return http.put(BASE_PATH + "/" + id + "/terminate", request, ContractResponse.class);
    }

    public ContractAmendmentResponse createAmendment(UUID contractId, CreateAmendmentRequest request) {
        return http.post(BASE_PATH + "/" + contractId + "/amendments", request, ContractAmendmentResponse.class);
    }

    public PageResponse<ContractResponse> getExpiring(int withinDays) {
        return http.get(withParam(BASE_PATH + "/expiring", "withinDays", withinDays),
                new TypeReference<PageResponse<ContractResponse>>() {});
    }
}
