package com.essabu.common.model;

import lombok.Builder;
import lombok.Getter;

/**
 * Pagination parameters for list operations in the Essabu SDK.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Getter
@Builder
public class PageRequest {

    @Builder.Default
    private final int page = 0;

    @Builder.Default
    private final int size = 20;

    private final String sort;
    private final String direction;

    public static PageRequest of(int page, int size) {
        return PageRequest.builder().page(page).size(size).build();
    }

    public static PageRequest first() {
        return PageRequest.builder().build();
    }

    public String toQueryString() {
        StringBuilder sb = new StringBuilder();
        sb.append("page=").append(page);
        sb.append("&size=").append(size);
        if (sort != null && !sort.isBlank()) {
            sb.append("&sort=").append(sort);
            if (direction != null && !direction.isBlank()) {
                sb.append(",").append(direction);
            }
        }
        return sb.toString();
    }
}
