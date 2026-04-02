package com.essabu.trade.model.supply.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * Request payload for creating a purchase order via the Essabu Trade API.
 *
 * This data transfer object carries the parameters required to create
 * a purchase order resource through the Trade REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - supplierId: supplier id
 * - currency: currency
 * - notes: notes
 * - lines: lines
 * - productId: product id
 * - quantity: quantity
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePurchaseOrderRequest {
    private UUID companyId;
    private UUID supplierId;
    private String currency;
    private String notes;
    private List<PurchaseOrderLineRequest> lines;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PurchaseOrderLineRequest {
        private UUID productId;
        private int quantity;
        private java.math.BigDecimal unitPrice;
    }
}
