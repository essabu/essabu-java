package com.essabu.trade;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for contract, clause, amendment, and document operations.
 * Endpoint bases: /api/contract/contracts, /api/contract/clauses, /api/contract/amendments,
 * /api/contract/documents, /api/contract/document-versions
 */
public final class ContractApi extends BaseApi {

    private static final String CONTRACTS = "/api/contract/contracts";
    private static final String CLAUSES = "/api/contract/clauses";
    private static final String AMENDMENTS = "/api/contract/amendments";
    private static final String DOCUMENTS = "/api/contract/documents";
    private static final String DOC_VERSIONS = "/api/contract/document-versions";

    public ContractApi(HttpClientWrapper http) {
        super(http);
    }

    // -- Contracts --
    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(CONTRACTS, pageRequest), pageType(Map.class));
    }
    public Map getById(UUID id) { return http.get(CONTRACTS + "/" + id, Map.class); }
    public Map create(Map<String, Object> request) { return http.post(CONTRACTS, request, Map.class); }
    public Map update(UUID id, Map<String, Object> request) { return http.put(CONTRACTS + "/" + id, request, Map.class); }
    public void delete(UUID id) { http.delete(CONTRACTS + "/" + id); }

    // -- Clauses --
    public PageResponse<Map> listClauses(PageRequest pageRequest) {
        return http.get(withPagination(CLAUSES, pageRequest), pageType(Map.class));
    }
    public Map createClause(Map<String, Object> request) { return http.post(CLAUSES, request, Map.class); }
    public Map updateClause(UUID id, Map<String, Object> request) { return http.put(CLAUSES + "/" + id, request, Map.class); }
    public void deleteClause(UUID id) { http.delete(CLAUSES + "/" + id); }

    // -- Amendments --
    public PageResponse<Map> listAmendments(PageRequest pageRequest) {
        return http.get(withPagination(AMENDMENTS, pageRequest), pageType(Map.class));
    }
    public Map createAmendment(Map<String, Object> request) { return http.post(AMENDMENTS, request, Map.class); }

    // -- Documents --
    public PageResponse<Map> listDocuments(PageRequest pageRequest) {
        return http.get(withPagination(DOCUMENTS, pageRequest), pageType(Map.class));
    }
    public Map createDocument(Map<String, Object> request) { return http.post(DOCUMENTS, request, Map.class); }

    // -- Document Versions --
    public PageResponse<Map> listDocumentVersions(PageRequest pageRequest) {
        return http.get(withPagination(DOC_VERSIONS, pageRequest), pageType(Map.class));
    }
}
