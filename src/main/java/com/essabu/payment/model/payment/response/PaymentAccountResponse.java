package com.essabu.payment.model.payment.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a payment account returned by the Essabu Payment API.
 *
 * Contains all payment account information returned by the Payment REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the payment account resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - companyId: company id
 * - accountName: account name
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - kycVerified: kyc verified
 * - balance: balance
 * - currency: currency
 * - bankName: bank name
 * - bankAccountNumber: bank account number
 * - mobileNumber: mobile number
 * - createdAt: created at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentAccountResponse {

    private UUID id;
    private UUID companyId;
    private String accountName;
    private String status;
    private String statusLabel;
    private String statusColor;
    private boolean kycVerified;
    private BigDecimal balance;
    private String currency;
    private String bankName;
    private String bankAccountNumber;
    private String mobileNumber;
    private LocalDateTime createdAt;
}
