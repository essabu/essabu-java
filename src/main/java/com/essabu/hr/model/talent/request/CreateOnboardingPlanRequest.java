package com.essabu.hr.model.talent.request;

import com.essabu.hr.model.talent.enums.OnboardingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Request payload for creating a onboarding plan via the Essabu HR API.
 *
 * This data transfer object carries the parameters required to create
 * a onboarding plan resource through the HR REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - employeeId: employee id
 * - type: type
 * - startDate: start date
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOnboardingPlanRequest {

    private UUID employeeId;
    private OnboardingType type;
    private LocalDate startDate;
}
