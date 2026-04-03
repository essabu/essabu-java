package com.essabu.common.model;

import lombok.Builder;
import lombok.Getter;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Pagination parameters for list endpoints.
 */
@Getter
@Builder
public class PageRequest {

    @Builder.Default
    private int page = 0;

    @Builder.Default
    private int size = 20;

    @Builder.Default
    private String sort = "";

    /**
     * Convert to query string parameters (without leading '?').
     * The sort parameter is URL-encoded to handle special characters safely.
     */
    public String toQueryString() {
        StringBuilder sb = new StringBuilder();
        sb.append("page=").append(page);
        sb.append("&size=").append(size);
        if (sort != null && !sort.isBlank()) {
            sb.append("&sort=").append(URLEncoder.encode(sort, StandardCharsets.UTF_8));
        }
        return sb.toString();
    }
}
