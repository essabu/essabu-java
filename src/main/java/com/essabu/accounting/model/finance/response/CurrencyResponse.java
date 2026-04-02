package com.essabu.accounting.model.finance.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Response payload representing a currency returned by the Essabu Accounting API.
 *
 * Contains all currency information returned by the Accounting REST API
 * after a successful retrieval, creation, or update operation.
 * This object is deserialized automatically from the JSON response body
 * and provides typed access to all fields of the currency resource.
 * When the resource includes a status field, it is accompanied by
 * statusLabel and statusColor for direct display in user interfaces.
 *
 * Fields included:
 * - id: id
 * - code: code
 * - name: name
 * - symbol: symbol
 * - decimalPlaces: decimal places
 * - isActive: is active
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyResponse {
    private UUID id;
    private String code;
    private String name;
    private String symbol;
    private int decimalPlaces;
    private boolean isActive;
}
