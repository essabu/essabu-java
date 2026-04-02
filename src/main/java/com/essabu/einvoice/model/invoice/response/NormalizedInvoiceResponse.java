package com.essabu.einvoice.model.invoice.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Response payload representing a normalized invoice returned by the Essabu E-Invoice API.
 *
 * Contains all normalized invoice information returned by the E-Invoice REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the normalized invoice resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
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
 * - qrCodeData: qr code data
 * - digitalSignature: digital signature
 * - verificationCode: verification code
 * - governmentSystem: government system
 * - governmentSystemLabel: government system label
 * - governmentSystemColor: government system color
 * - normalizedAt: normalized at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NormalizedInvoiceResponse {

    private UUID id;
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
    private List<NormalizedInvoiceItemResponse> items;
    private String qrCodeData;
    private String digitalSignature;
    private String verificationCode;
    private String governmentSystem;
    private String governmentSystemLabel;
    private String governmentSystemColor;
    private LocalDateTime normalizedAt;
}
