package com.essabu.trade.model.commerce.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a product category returned by the Essabu Trade API.
 *
 * Contains all product category information returned by the Trade REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the product category resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - name: name
 * - description: description
 * - parentId: parent id
 * - slug: slug
 * - createdAt: created at
 * - updatedAt: updated at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryResponse {
    private UUID id;
    private UUID companyId;
    private String name;
    private String description;
    private UUID parentId;
    private String slug;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
