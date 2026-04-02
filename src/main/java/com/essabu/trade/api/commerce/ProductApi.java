package com.essabu.trade.api.commerce;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.trade.model.commerce.request.CreatePriceListRequest;
import com.essabu.trade.model.commerce.request.CreateProductCategoryRequest;
import com.essabu.trade.model.commerce.request.CreateProductRequest;
import com.essabu.trade.model.commerce.request.UpdateProductRequest;
import com.essabu.trade.model.commerce.response.PriceListResponse;
import com.essabu.trade.model.commerce.response.ProductCategoryResponse;
import com.essabu.trade.model.commerce.response.ProductResponse;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;

/**
 * API client for managing product resources in the Essabu Trade module.
 *
 * Provides typed methods to interact with the product REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - update: update operation
 * - createCategory: create category operation
 * - createPriceList: create price list operation
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class ProductApi extends BaseApi {

    private static final String PRODUCTS_PATH = "/api/trade/products";
    private static final String CATEGORIES_PATH = "/api/trade/product-categories";
    private static final String PRICE_LISTS_PATH = "/api/trade/price-lists";

    public ProductApi(HttpClientWrapper http) {
        super(http);
    }

    // --- Products ---

    public ProductResponse create(CreateProductRequest request) {
        return http.post(PRODUCTS_PATH, request, ProductResponse.class);
    }

    public PageResponse<ProductResponse> getAll(UUID companyId, PageRequest page) {
        String path = withPagination(withParam(PRODUCTS_PATH, "companyId", companyId), page);
        return http.get(path, new TypeReference<>() {});
    }

    public ProductResponse getById(UUID id) {
        return http.get(PRODUCTS_PATH + "/" + id, ProductResponse.class);
    }

    public ProductResponse update(UUID id, UpdateProductRequest request) {
        return http.put(PRODUCTS_PATH + "/" + id, request, ProductResponse.class);
    }

    // --- Product Categories ---

    public ProductCategoryResponse createCategory(CreateProductCategoryRequest request) {
        return http.post(CATEGORIES_PATH, request, ProductCategoryResponse.class);
    }

    public PageResponse<ProductCategoryResponse> getAllCategories(UUID companyId, PageRequest page) {
        String path = withPagination(withParam(CATEGORIES_PATH, "companyId", companyId), page);
        return http.get(path, new TypeReference<>() {});
    }

    // --- Price Lists ---

    public PriceListResponse createPriceList(CreatePriceListRequest request) {
        return http.post(PRICE_LISTS_PATH, request, PriceListResponse.class);
    }

    public PageResponse<PriceListResponse> getAllPriceLists(UUID companyId, PageRequest page) {
        String path = withPagination(withParam(PRICE_LISTS_PATH, "companyId", companyId), page);
        return http.get(path, new TypeReference<>() {});
    }
}
