package com.essabu.hr.model.compensation.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Request payload for creating a expense line via the Essabu HR API.
 *
 * This data transfer object carries the parameters required to create
 * a expense line resource through the HR REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - expenseDate: expense date
 * - category: category
 * - description: description
 * - amount: amount
 * - currency: currency
 * - receiptUrl: receipt url
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateExpenseLineRequest {

    private LocalDate expenseDate;
    private String category;
    private String description;
    private BigDecimal amount;
    private String currency;
    private String receiptUrl;
}
