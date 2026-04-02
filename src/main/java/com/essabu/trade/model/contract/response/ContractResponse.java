package com.essabu.trade.model.contract.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a contract returned by the Essabu Trade API.
 *
 * Contains all contract information returned by the Trade REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the contract resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - customerId: customer id
 * - title: title
 * - description: description
 * - type: type
 * - value: value
 * - currency: currency
 * - startDate: start date
 * - endDate: end date
 * - signedDate: signed date
 * - signedBy: signed by
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
public class ContractResponse {
    private UUID id;
    private UUID companyId;
    private UUID customerId;
    private String title;
    private String description;
    private String type;
    private BigDecimal value;
    private String currency;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate signedDate;
    private String signedBy;
    private String slug;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
