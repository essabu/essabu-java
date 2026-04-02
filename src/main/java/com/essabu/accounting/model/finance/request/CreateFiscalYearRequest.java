package com.essabu.accounting.model.finance.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Request payload for creating a fiscal year via the Essabu Accounting API.
 *
 * This data transfer object carries the parameters required to create
 * a fiscal year resource through the Accounting REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyId: company id
 * - name: name
 * - startDate: start date
 * - endDate: end date
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateFiscalYearRequest {
    private UUID companyId;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
}
