package com.essabu.hr.model.admin.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Response payload representing a public holiday returned by the Essabu HR API.
 *
 * Contains all public holiday information returned by the HR REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the public holiday resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - name: name
 * - date: date
 * - recurring: recurring
 * - year: year
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PublicHolidayResponse {
    private UUID id;
    private String name;
    private LocalDate date;
    private boolean recurring;
    private int year;
}
