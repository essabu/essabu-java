package com.essabu.payment;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for KYC (Know Your Customer) operations.
 * Endpoint bases: /api/lending/kyc-profiles, /api/lending/kyc-documents
 */
public final class KycApi extends BaseApi {

    private static final String PROFILES = "/api/lending/kyc-profiles";
    private static final String DOCUMENTS = "/api/lending/kyc-documents";

    public KycApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> listProfiles(PageRequest pageRequest) {
        return http.get(withPagination(PROFILES, pageRequest), pageType(Map.class));
    }
    public Map getProfileById(UUID id) { return http.get(PROFILES + "/" + id, Map.class); }
    public Map createProfile(Map<String, Object> request) { return http.post(PROFILES, request, Map.class); }

    public PageResponse<Map> listDocuments(PageRequest pageRequest) {
        return http.get(withPagination(DOCUMENTS, pageRequest), pageType(Map.class));
    }
    public Map uploadDocument(Map<String, Object> request) { return http.post(DOCUMENTS, request, Map.class); }
}
