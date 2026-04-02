package com.essabu.hr.model.talent.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for document type in the HR module.
 *
 * This enum defines the complete set of valid document type values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - CONTRACT: contract
 * - ID_CARD: id card
 * - DIPLOMA: diploma
 * - MEDICAL: medical
 * - PAYSLIP: payslip
 * - CERTIFICATE: certificate
 * - OTHER: other
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum DocumentType {

    CONTRACT("contract"),
    ID_CARD("id_card"),
    DIPLOMA("diploma"),
    MEDICAL("medical"),
    PAYSLIP("payslip"),
    CERTIFICATE("certificate"),
    OTHER("other");

    private final String value;

    DocumentType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static DocumentType fromValue(String value) {
        for (DocumentType t : values()) {
            if (t.value.equals(value)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown DocumentType: " + value);
    }
}
