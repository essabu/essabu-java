package com.essabu.trade.model.supply.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Request payload for creating a reorder rule via the Essabu Trade API.
 *
 * This data transfer object carries the parameters required to create
 * a reorder rule resource through the Trade REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - productId: product id
 * - warehouseId: warehouse id
 * - minimumQuantity: minimum quantity
 * - reorderQuantity: reorder quantity
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateReorderRuleRequest {
    private UUID companyId;
    private UUID productId;
    private UUID warehouseId;
    private int minimumQuantity;
    private int reorderQuantity;
}
