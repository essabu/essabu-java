package com.essabu.trade.model.supply.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a supplier invoice returned by the Essabu Trade API.
 *
 * Contains all supplier invoice information returned by the Trade REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the supplier invoice resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - supplierId: supplier id
 * - purchaseOrderId: purchase order id
 * - invoiceNumber: invoice number
 * - totalAmount: total amount
 * - currency: currency
 * - slug: slug
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
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
public class SupplierInvoiceResponse {
    private UUID id;
    private UUID companyId;
    private UUID supplierId;
    private UUID purchaseOrderId;
    private String invoiceNumber;
    private BigDecimal totalAmount;
    private String currency;
    private String slug;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
