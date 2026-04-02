package com.essabu.hr.model.admin.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Request payload for updating a tenant config via the Essabu HR API.
 *
 * This data transfer object carries the parameters required to update
 * a tenant config resource through the HR REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - companyName: company name
 * - country: country
 * - currency: currency
 * - timezone: timezone
 * - language: language
 * - workDaysPerWeek: work days per week
 * - hoursPerDay: hours per day
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTenantConfigRequest {

    private String companyName;
    private String country;
    private String currency;
    private String timezone;
    private String language;
    private Integer workDaysPerWeek;
    private BigDecimal hoursPerDay;
}
