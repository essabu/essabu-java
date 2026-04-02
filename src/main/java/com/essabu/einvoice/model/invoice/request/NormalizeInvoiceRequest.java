package com.essabu.einvoice.model.invoice.request;

import com.essabu.einvoice.model.invoice.GovernmentSystem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Request payload for performing an operation on a normalize invoice via the Essabu E-Invoice API.
 *
 * This data transfer object carries the parameters required to process
 * a normalize invoice resource through the E-Invoice REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - originalInvoiceId: original invoice id
 * - invoiceNumber: invoice number
 * - nif: nif
 * - issuerName: issuer name
 * - recipientName: recipient name
 * - recipientNif: recipient nif
 * - issueDate: issue date
 * - totalAmount: total amount
 * - taxAmount: tax amount
 * - currency: currency
 * - items: items
 * - governmentSystem: government system
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NormalizeInvoiceRequest {

    private UUID companyId;
    private UUID originalInvoiceId;
    private String invoiceNumber;
    private String nif;
    private String issuerName;
    private String recipientName;
    private String recipientNif;
    private LocalDate issueDate;
    private BigDecimal totalAmount;
    private BigDecimal taxAmount;
    private String currency;
    private List<NormalizeInvoiceItemRequest> items;
    private GovernmentSystem governmentSystem;
}
