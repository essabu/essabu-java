package com.essabu.accounting.model.inventory.request;

import com.essabu.accounting.model.inventory.enums.InventoryCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Request payload for creating a inventory item via the Essabu Accounting API.
 *
 * This data transfer object carries the parameters required to create
 * a inventory item resource through the Accounting REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - code: code
 * - name: name
 * - category: category
 * - unit: unit
 * - unitPrice: unit price
 * - minimumStock: minimum stock
 * - reorderPoint: reorder point
 * - defaultLocationId: default location id
 * - description: description
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateInventoryItemRequest {
    private UUID companyId;
    private String code;
    private String name;
    private InventoryCategory category;
    private String unit;
    private long unitPrice;
    private int minimumStock;
    private int reorderPoint;
    private UUID defaultLocationId;
    private String description;
}
