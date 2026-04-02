package com.essabu.einvoice.model.invoice;

/**
 * Enumeration of possible values for government system in the E-Invoice module.
 *
 * This enum defines the complete set of valid government system values
 * that can be returned by or sent to the Essabu E-Invoice API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - BENIN_MECEF: benin mecef
 * - DRC_VSD: drc vsd
 * - RWANDA_EBM: rwanda ebm
 * - SENEGAL_ASYCUDA: senegal asycuda
 * - IVORY_COAST_FDT: ivory coast fdt
 * - CAMEROON_CUD: cameroon cud
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum GovernmentSystem {

    BENIN_MECEF("Bénin - MECeF", "green"),
    DRC_VSD("RDC - VSD", "blue"),
    RWANDA_EBM("Rwanda - EBM", "purple"),
    SENEGAL_ASYCUDA("Sénégal - ASYCUDA", "orange"),
    IVORY_COAST_FDT("Côte d'Ivoire - FDT", "indigo"),
    CAMEROON_CUD("Cameroun - CUD", "yellow");

    private final String label;
    private final String color;

    GovernmentSystem(String label, String color) {
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
