package com.essabu.accounting.model.inventory.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Request payload for creating a batch via the Essabu Accounting API.
 *
 * This data transfer object carries the parameters required to create
 * a batch resource through the Accounting REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - inventoryItemId: inventory item id
 * - batchNumber: batch number
 * - manufacturingDate: manufacturing date
 * - expiryDate: expiry date
 * - quantity: quantity
 * - locationId: location id
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBatchRequest {
    private UUID companyId;
    private UUID inventoryItemId;
    private String batchNumber;
    private LocalDate manufacturingDate;
    private LocalDate expiryDate;
    private int quantity;
    private UUID locationId;
}
