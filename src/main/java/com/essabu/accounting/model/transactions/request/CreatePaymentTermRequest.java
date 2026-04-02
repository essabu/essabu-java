package com.essabu.accounting.model.transactions.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Request payload for creating a payment term via the Essabu Accounting API.
 *
 * This data transfer object carries the parameters required to create
 * a payment term resource through the Accounting REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - name: name
 * - dueDays: due days
 * - discountPercentage: discount percentage
 * - discountDays: discount days
 * - description: description
 * - isDefault: is default
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentTermRequest {
    private UUID companyId;
    private String name;
    private int dueDays;
    private BigDecimal discountPercentage;
    private int discountDays;
    private String description;
    private boolean isDefault;
}
