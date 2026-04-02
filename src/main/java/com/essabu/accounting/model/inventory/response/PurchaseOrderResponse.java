package com.essabu.accounting.model.inventory.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a purchase order returned by the Essabu Accounting API.
 *
 * Contains all purchase order information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the purchase order resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - supplierId: supplier id
 * - orderNumber: order number
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - orderDate: order date
 * - expectedDeliveryDate: expected delivery date
 * - totalAmount: total amount
 * - currency: currency
 * - notes: notes
 * - items: items
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderResponse {
    private UUID id;
    private UUID companyId;
    private UUID supplierId;
    private String orderNumber;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDate orderDate;
    private LocalDate expectedDeliveryDate;
    private long totalAmount;
    private String currency;
    private String notes;
    private List<PurchaseOrderItemResponse> items;
    private LocalDateTime createdAt;
}
