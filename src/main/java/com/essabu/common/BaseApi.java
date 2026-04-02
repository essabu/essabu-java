package com.essabu.common;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.internal.JsonMapper;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.fasterxml.jackson.databind.JavaType;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Base class for all API resource classes. Provides convenience methods
 * for building paths with pagination, query parameters, and generic
 * CRUD operations.
 */
public abstract class BaseApi {

    protected final HttpClientWrapper http;

    protected BaseApi(HttpClientWrapper http) {
        this.http = http;
    }

    /**
     * Append pagination query parameters to a path.
     */
    protected String withPagination(String path, PageRequest pageRequest) {
        if (pageRequest == null) {
            return path;
        }
        String separator = path.contains("?") ? "&" : "?";
        return path + separator + pageRequest.toQueryString();
    }

    /**
     * Append a single query parameter to a path.
     */
    protected String withParam(String path, String key, Object value) {
        if (value == null) {
            return path;
        }
        String separator = path.contains("?") ? "&" : "?";
        return path + separator + key + "=" + value;
    }

    /**
     * Append multiple query parameters to a path.
     */
    protected String withParams(String path, Map<String, Object> params) {
        if (params == null || params.isEmpty()) {
            return path;
        }
        StringBuilder sb = new StringBuilder(path);
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (entry.getValue() != null) {
                sb.append(sb.toString().contains("?") ? "&" : "?");
                sb.append(entry.getKey()).append("=").append(entry.getValue());
            }
        }
        return sb.toString();
    }

    /**
     * Build a JavaType for PageResponse with the given element type.
     */
    protected <T> JavaType pageType(Class<T> elementType) {
        return JsonMapper.instance().getTypeFactory()
                .constructParametricType(PageResponse.class, elementType);
    }

    /**
     * Create a mutable parameter map for building query strings.
     */
    protected Map<String, Object> params() {
        return new LinkedHashMap<>();
    }
}
