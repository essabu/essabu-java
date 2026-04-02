package com.essabu.accounting;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for insurance operations (partners, contracts, claims).
 * Endpoint bases: /api/accounting/insurance-partners, /api/accounting/insurance-contracts, /api/accounting/insurance-claims
 */
public final class InsuranceApi extends BaseApi {

    private static final String PARTNERS = "/api/accounting/insurance-partners";
    private static final String CONTRACTS = "/api/accounting/insurance-contracts";
    private static final String CLAIMS = "/api/accounting/insurance-claims";

    public InsuranceApi(HttpClientWrapper http) {
        super(http);
    }

    // -- Partners --
    public PageResponse<Map> listPartners(PageRequest pageRequest) {
        return http.get(withPagination(PARTNERS, pageRequest), pageType(Map.class));
    }
    public Map getPartnerById(UUID id) { return http.get(PARTNERS + "/" + id, Map.class); }
    public Map createPartner(Map<String, Object> request) { return http.post(PARTNERS, request, Map.class); }
    public Map updatePartner(UUID id, Map<String, Object> request) { return http.put(PARTNERS + "/" + id, request, Map.class); }
    public void deletePartner(UUID id) { http.delete(PARTNERS + "/" + id); }

    // -- Contracts --
    public PageResponse<Map> listContracts(PageRequest pageRequest) {
        return http.get(withPagination(CONTRACTS, pageRequest), pageType(Map.class));
    }
    public Map getContractById(UUID id) { return http.get(CONTRACTS + "/" + id, Map.class); }
    public Map createContract(Map<String, Object> request) { return http.post(CONTRACTS, request, Map.class); }
    public Map updateContract(UUID id, Map<String, Object> request) { return http.put(CONTRACTS + "/" + id, request, Map.class); }
    public void deleteContract(UUID id) { http.delete(CONTRACTS + "/" + id); }

    // -- Claims --
    public PageResponse<Map> listClaims(PageRequest pageRequest) {
        return http.get(withPagination(CLAIMS, pageRequest), pageType(Map.class));
    }
    public Map getClaimById(UUID id) { return http.get(CLAIMS + "/" + id, Map.class); }
    public Map createClaim(Map<String, Object> request) { return http.post(CLAIMS, request, Map.class); }
    public Map updateClaim(UUID id, Map<String, Object> request) { return http.put(CLAIMS + "/" + id, request, Map.class); }
}
