package com.essabu.accounting.model.inventory.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Request payload for performing an operation on a receive purchase order via the Essabu Accounting API.
 *
 * This data transfer object carries the parameters required to process
 * a receive purchase order resource through the Accounting REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - items: items
 * - inventoryItemId: inventory item id
 * - receivedQuantity: received quantity
 * - locationId: location id
 * - batchNumber: batch number
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceivePurchaseOrderRequest {
    private List<ReceivedItemRequest> items;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReceivedItemRequest {
        private UUID inventoryItemId;
        private BigDecimal receivedQuantity;
        private UUID locationId;
        private String batchNumber;
    }
}
