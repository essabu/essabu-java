package com.essabu.accounting.api.commercial;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.accounting.model.commercial.request.ApproveClaimRequest;
import com.essabu.accounting.model.commercial.request.CreateInsuranceClaimRequest;
import com.essabu.accounting.model.commercial.request.DenyClaimRequest;
import com.essabu.accounting.model.commercial.response.InsuranceClaimResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing insurance claim resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the insurance claim REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - list: list operation
 * - submit: submit operation
 * - approve: approve operation
 * - deny: deny operation
 * - appeal: appeal operation
 * - close: close operation
 * - listByContract: list by contract operation
 * - listByInvoice: list by invoice operation
 *
 * Base path: /api/accounting/insurance-claims
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class InsuranceClaimApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/insurance-claims";

    public InsuranceClaimApi(HttpClientWrapper http) {
        super(http);
    }

    public InsuranceClaimResponse create(CreateInsuranceClaimRequest request) {
        return http.post(BASE_PATH, request, InsuranceClaimResponse.class);
    }

    public InsuranceClaimResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, InsuranceClaimResponse.class);
    }

    public PageResponse<InsuranceClaimResponse> list(UUID companyId, PageRequest page) {
        String path = withPagination(BASE_PATH + "?companyId=" + companyId, page);
        return http.get(path, new TypeReference<>() {});
    }

    public InsuranceClaimResponse submit(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/submit", InsuranceClaimResponse.class);
    }

    public InsuranceClaimResponse approve(UUID id, ApproveClaimRequest request) {
        return http.post(BASE_PATH + "/" + id + "/approve", request, InsuranceClaimResponse.class);
    }

    public InsuranceClaimResponse deny(UUID id, DenyClaimRequest request) {
        return http.post(BASE_PATH + "/" + id + "/deny", request, InsuranceClaimResponse.class);
    }

    public InsuranceClaimResponse appeal(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/appeal", InsuranceClaimResponse.class);
    }

    public InsuranceClaimResponse close(UUID id) {
        return http.postEmpty(BASE_PATH + "/" + id + "/close", InsuranceClaimResponse.class);
    }

    public List<InsuranceClaimResponse> listByContract(UUID contractId) {
        return http.get(BASE_PATH + "?contractId=" + contractId, new TypeReference<>() {});
    }

    public List<InsuranceClaimResponse> listByInvoice(UUID invoiceId) {
        return http.get(BASE_PATH + "?invoiceId=" + invoiceId, new TypeReference<>() {});
    }
}
