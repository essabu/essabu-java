package com.essabu.payment.model.payment.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

/**
 * Request payload for creating a payment intent via the Essabu Payment API.
 *
 * This data transfer object carries the parameters required to create
 * a payment intent resource through the Payment REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - amount: amount
 * - currency: currency
 * - paymentMethodType: payment method type
 * - idempotencyKey: idempotency key
 * - description: description
 * - metadata: metadata
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentIntentRequest {

    private UUID companyId;
    private BigDecimal amount;
    private String currency;
    private String paymentMethodType;
    private String idempotencyKey;
    private String description;
    private Map<String, String> metadata;
}
