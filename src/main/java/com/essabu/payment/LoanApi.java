package com.essabu.payment;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for lending operations (loan products, applications, collaterals, financial accounts).
 * Endpoint bases: /api/lending/loan-products, /api/lending/loan-applications, /api/lending/collaterals, /api/lending/accounts
 */
public final class LoanApi extends BaseApi {

    private static final String PRODUCTS = "/api/lending/loan-products";
    private static final String APPLICATIONS = "/api/lending/loan-applications";
    private static final String COLLATERALS = "/api/lending/collaterals";
    private static final String ACCOUNTS = "/api/lending/accounts";

    public LoanApi(HttpClientWrapper http) {
        super(http);
    }

    // -- Loan Products --
    public PageResponse<Map> listProducts(PageRequest pageRequest) {
        return http.get(withPagination(PRODUCTS, pageRequest), pageType(Map.class));
    }
    public Map getProductById(UUID id) { return http.get(PRODUCTS + "/" + id, Map.class); }
    public Map createProduct(Map<String, Object> request) { return http.post(PRODUCTS, request, Map.class); }
    public Map updateProduct(UUID id, Map<String, Object> request) { return http.put(PRODUCTS + "/" + id, request, Map.class); }
    public void deleteProduct(UUID id) { http.delete(PRODUCTS + "/" + id); }

    // -- Loan Applications --
    public PageResponse<Map> listApplications(PageRequest pageRequest) {
        return http.get(withPagination(APPLICATIONS, pageRequest), pageType(Map.class));
    }
    public Map getApplicationById(UUID id) { return http.get(APPLICATIONS + "/" + id, Map.class); }
    public Map createApplication(Map<String, Object> request) { return http.post(APPLICATIONS, request, Map.class); }
    public Map updateApplication(UUID id, Map<String, Object> request) { return http.put(APPLICATIONS + "/" + id, request, Map.class); }

    // -- Collaterals --
    public PageResponse<Map> listCollaterals(PageRequest pageRequest) {
        return http.get(withPagination(COLLATERALS, pageRequest), pageType(Map.class));
    }
    public Map createCollateral(Map<String, Object> request) { return http.post(COLLATERALS, request, Map.class); }

    // -- Financial Accounts --
    public PageResponse<Map> listAccounts(PageRequest pageRequest) {
        return http.get(withPagination(ACCOUNTS, pageRequest), pageType(Map.class));
    }
    public Map getAccountById(UUID id) { return http.get(ACCOUNTS + "/" + id, Map.class); }
    public Map createAccount(Map<String, Object> request) { return http.post(ACCOUNTS, request, Map.class); }
}
