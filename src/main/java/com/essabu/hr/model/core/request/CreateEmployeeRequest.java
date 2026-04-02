package com.essabu.hr.model.core.request;

import com.essabu.hr.model.core.enums.Gender;
import com.essabu.hr.model.core.enums.MaritalStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Request payload for creating a employee via the Essabu HR API.
 *
 * This data transfer object carries the parameters required to create
 * a employee resource through the HR REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - firstName: first name
 * - lastName: last name
 * - email: email
 * - phone: phone
 * - dateOfBirth: date of birth
 * - hireDate: hire date
 * - departmentId: department id
 * - positionId: position id
 * - address: address
 * - city: city
 * - country: country
 * - salary: salary
 * - currency: currency
 * - photo: photo
 * - gender: gender
 * - nationality: nationality
 * - socialSecurityNumber: social security number
 * - maritalStatus: marital status
 * - dependents: dependents
 * - emergencyContactName: emergency contact name
 * - emergencyContactPhone: emergency contact phone
 * - managerId: manager id
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private LocalDate hireDate;
    private UUID departmentId;
    private UUID positionId;
    private String address;
    private String city;
    private String country;
    private BigDecimal salary;
    private String currency;
    private String photo;
    private Gender gender;
    private String nationality;
    private String socialSecurityNumber;
    private MaritalStatus maritalStatus;
    private Integer dependents;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private UUID managerId;
}
