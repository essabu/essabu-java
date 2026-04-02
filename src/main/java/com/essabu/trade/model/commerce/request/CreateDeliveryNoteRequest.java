package com.essabu.trade.model.commerce.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Request payload for creating a delivery note via the Essabu Trade API.
 *
 * This data transfer object carries the parameters required to create
 * a delivery note resource through the Trade REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - salesOrderId: sales order id
 * - warehouseId: warehouse id
 * - notes: notes
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateDeliveryNoteRequest {
    private UUID companyId;
    private UUID salesOrderId;
    private UUID warehouseId;
    private String notes;
}
