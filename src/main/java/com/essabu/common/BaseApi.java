package com.essabu.common;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.common.model.PageRequest;

/**
 * Abstract base class shared by all API clients in the Essabu SDK.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public abstract class BaseApi {

    protected final HttpClientWrapper http;

    protected BaseApi(HttpClientWrapper http) {
        this.http = http;
    }

    protected String withPagination(String basePath, PageRequest page) {
        if (page == null) {
            return basePath;
        }
        String separator = basePath.contains("?") ? "&" : "?";
        return basePath + separator + page.toQueryString();
    }

    protected String withParam(String basePath, String key, Object value) {
        if (value == null) {
            return basePath;
        }
        String separator = basePath.contains("?") ? "&" : "?";
        return basePath + separator + key + "=" + value;
    }
}
