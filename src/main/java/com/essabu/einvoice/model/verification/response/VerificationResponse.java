package com.essabu.einvoice.model.verification.response;

import com.essabu.einvoice.model.invoice.response.NormalizedInvoiceResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a verification returned by the Essabu E-Invoice API.
 *
 * Contains all verification information returned by the E-Invoice REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the verification resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - verificationCode: verification code
 * - result: result
 * - resultLabel: result label
 * - resultColor: result color
 * - requestedAt: requested at
 * - invoice: invoice
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VerificationResponse {

    private UUID id;
    private String verificationCode;
    private String result;
    private String resultLabel;
    private String resultColor;
    private LocalDateTime requestedAt;
    private NormalizedInvoiceResponse invoice;
}
