package com.essabu.einvoice.model.invoice;

/**
 * Enumeration of possible values for e invoice status in the E-Invoice module.
 *
 * This enum defines the complete set of valid e invoice status values
 * that can be returned by or sent to the Essabu E-Invoice API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - PENDING: pending
 * - SUBMITTED: submitted
 * - ACCEPTED: accepted
 * - REJECTED: rejected
 * - CANCELLED: cancelled
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum EInvoiceStatus {

    PENDING("Pending", "yellow"),
    SUBMITTED("Submitted", "blue"),
    ACCEPTED("Accepted", "green"),
    REJECTED("Rejected", "red"),
    CANCELLED("Cancelled", "gray");

    private final String label;
    private final String color;

    EInvoiceStatus(String label, String color) {
        this.label = label;
        this.color = color;
    }

    public String label() {
        return label;
    }

    public String color() {
        return color;
    }
}
