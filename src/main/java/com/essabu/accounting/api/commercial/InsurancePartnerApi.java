package com.essabu.accounting.api.commercial;

import com.essabu.common.BaseApi;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.accounting.model.commercial.request.CreateInsurancePartnerRequest;
import com.essabu.accounting.model.commercial.request.UpdateInsurancePartnerRequest;
import com.essabu.accounting.model.commercial.response.InsurancePartnerResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing insurance partner resources in the Essabu Accounting module.
 *
 * Provides typed methods to interact with the insurance partner REST API endpoints
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
 * Base path: /api/accounting/insurance-partners
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public class InsurancePartnerApi extends BaseApi {

    private static final String BASE_PATH = "/api/accounting/insurance-partners";

    public InsurancePartnerApi(HttpClientWrapper http) {
        super(http);
    }

    public InsurancePartnerResponse create(CreateInsurancePartnerRequest request) {
        return http.post(BASE_PATH, request, InsurancePartnerResponse.class);
    }

    public InsurancePartnerResponse get(UUID id) {
        return http.get(BASE_PATH + "/" + id, InsurancePartnerResponse.class);
    }

    public PageResponse<InsurancePartnerResponse> list(UUID companyId, PageRequest page) {
        String path = withPagination(BASE_PATH + "?companyId=" + companyId, page);
        return http.get(path, new TypeReference<>() {});
    }

    public InsurancePartnerResponse update(UUID id, UpdateInsurancePartnerRequest request) {
        return http.put(BASE_PATH + "/" + id, request, InsurancePartnerResponse.class);
    }

    public void delete(UUID id) {
        http.delete(BASE_PATH + "/" + id);
    }
}
