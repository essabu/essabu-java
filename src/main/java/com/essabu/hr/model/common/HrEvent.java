package com.essabu.hr.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Represents an HR domain event received via webhook from the Essabu HR API.
 *
 * This is the standard event envelope used for all webhook notifications
 * sent by the Essabu HR system. Each event contains a unique identifier,
 * an event type string that categorizes the change, the tenant that generated
 * the event, a timestamp of when the event occurred, and a flexible data map
 * containing the event-specific payload details.
 *
 * The event type follows a dot-notation convention such as "employee.created",
 * "leave.approved", "payroll.paid", etc. The data map structure varies based
 * on the event type and contains the relevant entity identifiers and changed
 * field values for the specific event.
 *
 * Fields:
 * - id: unique identifier for this event instance
 * - type: event type in dot-notation format (e.g., "employee.created")
 * - tenantId: identifier of the tenant that generated the event
 * - timestamp: date and time when the event occurred
 * - data: event-specific payload as a key-value map
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HrEvent {

    /**
     * Unique event identifier.
     */
    private String id;

    /**
     * Event type (e.g., "employee.created", "leave.approved", "payroll.paid").
     */
    private String type;

    /**
     * Tenant identifier that generated the event.
     */
    private String tenantId;

    /**
     * Timestamp when the event occurred.
     */
    private LocalDateTime timestamp;

    /**
     * Event payload data.
     */
    private Map<String, Object> data;
}
