package com.essabu.trade.model.crm.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a opportunity returned by the Essabu Trade API.
 *
 * Contains all opportunity information returned by the Trade REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the opportunity resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - contactId: contact id
 * - name: name
 * - amount: amount
 * - probability: probability
 * - expectedCloseDate: expected close date
 * - stage: stage
 * - source: source
 * - notes: notes
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
public class OpportunityResponse {
    private UUID id;
    private UUID companyId;
    private UUID contactId;
    private String name;
    private BigDecimal amount;
    private int probability;
    private LocalDate expectedCloseDate;
    private String stage;
    private String source;
    private String notes;
    private String slug;
    private String status;
    private String statusLabel;
    private String statusColor;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
