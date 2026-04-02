package com.essabu.accounting.model.core.enums;

/**
 * Enumeration of possible values for accounting standard in the Accounting module.
 *
 * This enum defines the complete set of valid accounting standard values
 * that can be returned by or sent to the Essabu Accounting API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - SYSCOHADA: syscohada
 * - SYCEBNL: sycebnl
 * - PCB: pcb
 * - CIMA: cima
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum AccountingStandard {
    SYSCOHADA, SYCEBNL, PCB, CIMA
}
