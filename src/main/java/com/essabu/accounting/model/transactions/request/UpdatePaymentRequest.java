package com.essabu.accounting.model.transactions.request;

import com.essabu.accounting.model.transactions.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Request payload for updating a payment via the Essabu Accounting API.
 *
 * This data transfer object carries the parameters required to update
 * a payment resource through the Accounting REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - amount: amount
 * - currency: currency
 * - paymentDate: payment date
 * - method: method
 * - reference: reference
 * - notes: notes
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePaymentRequest {
    private long amount;
    private String currency;
    private LocalDate paymentDate;
    private PaymentMethod method;
    private String reference;
    private String notes;
}
