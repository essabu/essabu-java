package com.essabu.hr.model.workforce.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for contract type in the HR module.
 *
 * This enum defines the complete set of valid contract type values
 * that can be returned by or sent to the Essabu HR API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - PERMANENT: permanent
 * - FIXED_TERM: fixed term
 * - TEMPORARY: temporary
 * - FREELANCE: freelance
 * - PART_TIME: part time
 * - INTERN: intern
 * - APPRENTICE: apprentice
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum ContractType {

    PERMANENT("permanent"),
    FIXED_TERM("fixed_term"),
    TEMPORARY("temporary"),
    FREELANCE("freelance"),
    PART_TIME("part_time"),
    INTERN("intern"),
    APPRENTICE("apprentice");

    private final String value;

    ContractType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static ContractType fromValue(String value) {
        for (ContractType t : values()) {
            if (t.value.equals(value)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown ContractType: " + value);
    }
}
