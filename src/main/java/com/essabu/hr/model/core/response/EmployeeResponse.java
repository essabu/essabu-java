package com.essabu.hr.model.core.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response payload representing a employee returned by the Essabu HR API.
 *
 * Contains all employee information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the employee resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - firstName: first name
 * - lastName: last name
 * - email: email
 * - phone: phone
 * - dateOfBirth: date of birth
 * - hireDate: hire date
 * - departmentId: department id
 * - departmentName: department name
 * - positionId: position id
 * - positionName: position name
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
 * - managerName: manager name
 * - status: status
 * - statusLabel: status label
 * - statusColor: status color
 * - slug: slug
 * - createdAt: created at
 * - updatedAt: updated at
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private LocalDate hireDate;
    private UUID departmentId;
    private String departmentName;
    private UUID positionId;
    private String positionName;
    private String address;
    private String city;
    private String country;
    private BigDecimal salary;
    private String currency;
    private String photo;
    private String gender;
    private String nationality;
    private String socialSecurityNumber;
    private String maritalStatus;
    private Integer dependents;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private UUID managerId;
    private String managerName;
    private String status;
    private String statusLabel;
    private String statusColor;
    private String slug;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
