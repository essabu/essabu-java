package com.essabu.trade.model.commerce.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Request payload for updating a product via the Essabu Trade API.
 *
 * This data transfer object carries the parameters required to update
 * a product resource through the Trade REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - name: name
 * - sku: sku
 * - description: description
 * - unitPrice: unit price
 * - unit: unit
 * - categoryId: category id
 * - type: type
 * - trackInventory: track inventory
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {
    private String name;
    private String sku;
    private String description;
    private BigDecimal unitPrice;
    private String unit;
    private UUID categoryId;
    private String type;
    private boolean trackInventory;
}
