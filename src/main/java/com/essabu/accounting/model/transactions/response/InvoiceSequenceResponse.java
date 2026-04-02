package com.essabu.accounting.model.transactions.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response payload representing a invoice sequence returned by the Essabu Accounting API.
 *
 * Contains all invoice sequence information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the invoice sequence resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - prefix: prefix
 * - nextNumber: next number
 * - nextInvoiceNumber: next invoice number
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceSequenceResponse {
    private String prefix;
    private long nextNumber;
    private String nextInvoiceNumber;
}
