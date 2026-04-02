package com.essabu.einvoice.model.verification;

/**
 * Enumeration of possible values for verification result in the E-Invoice module.
 *
 * This enum defines the complete set of valid verification result values
 * that can be returned by or sent to the Essabu E-Invoice API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - VALID: valid
 * - INVALID: invalid
 * - NOT_FOUND: not found
 * - EXPIRED: expired
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum VerificationResult {

    VALID("Validated", "green"),
    INVALID("Invalide", "red"),
    NOT_FOUND("Not Found", "gray"),
    EXPIRED("Expired", "yellow");

    private final String label;
    private final String color;

    VerificationResult(String label, String color) {
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
