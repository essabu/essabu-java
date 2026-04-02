package com.essabu.accounting.model.inventory.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * Request payload for updating a purchase order via the Essabu Accounting API.
 *
 * This data transfer object carries the parameters required to update
 * a purchase order resource through the Accounting REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - expectedDeliveryDate: expected delivery date
 * - currency: currency
 * - notes: notes
 * - items: items
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePurchaseOrderRequest {
    private LocalDate expectedDeliveryDate;
    private String currency;
    private String notes;
    private List<CreatePurchaseOrderItemRequest> items;
}
