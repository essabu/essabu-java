package com.essabu.einvoice.model.verification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Verify Invoice Request class in the Essabu E-Invoice SDK.
 *
 * This class is part of the Essabu E-Invoice SDK and provides
 * functionality related to verify invoice request operations. It is used internally
 * by the SDK to support the E-Invoice API integration and may also be
 * referenced by consuming applications when working with E-Invoice
 * resources and operations.
 *
 * Fields:
 * - verificationCode: verification code
 * - qrData: qr data
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VerifyInvoiceRequest {

    private String verificationCode;
    private String qrData;
}
