package com.essabu.asset.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of possible values for depreciation method in the Asset module.
 *
 * This enum defines the complete set of valid depreciation method values
 * that can be returned by or sent to the Essabu Asset API.
 * Each value maps to a lowercase string representation used in JSON
 * serialization and deserialization. The mapping is handled automatically
 * by Jackson via the JsonValue annotation on the getValue method.
 *
 * Values:
 * - STRAIGHT_LINE: equal depreciation amount distributed evenly across the useful life
 * - DECLINING_BALANCE: higher depreciation in earlier years, decreasing over time
 * - DOUBLE_DECLINING: accelerated method applying twice the straight-line rate to the declining book value
 * - SUM_OF_YEARS: accelerated method based on the sum of the years digits of the asset useful life
 * - UNITS_OF_PRODUCTION: depreciation based on actual usage or output of the asset
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public enum DepreciationMethod {
    STRAIGHT_LINE("straight_line"), DECLINING_BALANCE("declining_balance"),
    DOUBLE_DECLINING("double_declining"), SUM_OF_YEARS("sum_of_years"),
    UNITS_OF_PRODUCTION("units_of_production");
    private final String value;
    DepreciationMethod(String value) { this.value = value; }
    @JsonValue public String getValue() { return value; }
}
