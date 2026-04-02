package com.essabu.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Generic paginated response wrapper for list operations in the Essabu SDK.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> {

    private List<T> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean first;
    private boolean last;

    public boolean hasContent() {
        return content != null && !content.isEmpty();
    }

    public boolean hasNext() {
        return !last;
    }

    public boolean hasPrevious() {
        return !first;
    }
}
