package com.essabu.trade.model.supply.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Request payload for creating a supplier invoice via the Essabu Trade API.
 *
 * This data transfer object carries the parameters required to create
 * a supplier invoice resource through the Trade REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - supplierId: supplier id
 * - purchaseOrderId: purchase order id
 * - invoiceNumber: invoice number
 * - totalAmount: total amount
 * - currency: currency
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSupplierInvoiceRequest {
    private UUID companyId;
    private UUID supplierId;
    private UUID purchaseOrderId;
    private String invoiceNumber;
    private BigDecimal totalAmount;
    private String currency;
}
