package com.essabu.trade;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * API client for product, product category, and price list operations.
 * Endpoint bases: /api/trade/products, /api/trade/product-categories, /api/trade/price-lists
 */
public final class ProductApi extends BaseApi {

    private static final String PRODUCTS = "/api/trade/products";
    private static final String CATEGORIES = "/api/trade/product-categories";
    private static final String PRICE_LISTS = "/api/trade/price-lists";

    public ProductApi(HttpClientWrapper http) {
        super(http);
    }

    public PageResponse<Map> list(PageRequest pageRequest) {
        return http.get(withPagination(PRODUCTS, pageRequest), pageType(Map.class));
    }

    public Map getById(UUID id) { return http.get(PRODUCTS + "/" + id, Map.class); }
    public Map create(Map<String, Object> request) { return http.post(PRODUCTS, request, Map.class); }
    public Map update(UUID id, Map<String, Object> request) { return http.put(PRODUCTS + "/" + id, request, Map.class); }
    public void delete(UUID id) { http.delete(PRODUCTS + "/" + id); }

    // -- Categories --
    public PageResponse<Map> listCategories(PageRequest pageRequest) {
        return http.get(withPagination(CATEGORIES, pageRequest), pageType(Map.class));
    }
    public Map getCategoryById(UUID id) { return http.get(CATEGORIES + "/" + id, Map.class); }
    public Map createCategory(Map<String, Object> request) { return http.post(CATEGORIES, request, Map.class); }
    public Map updateCategory(UUID id, Map<String, Object> request) { return http.put(CATEGORIES + "/" + id, request, Map.class); }
    public void deleteCategory(UUID id) { http.delete(CATEGORIES + "/" + id); }

    // -- Price Lists --
    public PageResponse<Map> listPriceLists(PageRequest pageRequest) {
        return http.get(withPagination(PRICE_LISTS, pageRequest), pageType(Map.class));
    }
    public Map getPriceListById(UUID id) { return http.get(PRICE_LISTS + "/" + id, Map.class); }
    public Map createPriceList(Map<String, Object> request) { return http.post(PRICE_LISTS, request, Map.class); }
    public Map updatePriceList(UUID id, Map<String, Object> request) { return http.put(PRICE_LISTS + "/" + id, request, Map.class); }
    public void deletePriceList(UUID id) { http.delete(PRICE_LISTS + "/" + id); }
}
