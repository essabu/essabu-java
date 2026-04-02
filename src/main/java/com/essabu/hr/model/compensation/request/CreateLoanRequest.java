package com.essabu.hr.model.compensation.request;

import com.essabu.hr.model.compensation.enums.LoanType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Request payload for creating a loan via the Essabu HR API.
 *
 * This data transfer object carries the parameters required to create
 * a loan resource through the HR REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - employeeId: employee id
 * - type: type
 * - amount: amount
 * - monthlyDeduction: monthly deduction
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
public class CreateLoanRequest {

    private UUID employeeId;
    private LoanType type;
    private BigDecimal amount;
    private BigDecimal monthlyDeduction;
    private LocalDate startDate;
    private LocalDate endDate;
}
