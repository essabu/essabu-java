package com.essabu.accounting.model.commercial.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Request payload for creating a price list item via the Essabu Accounting API.
 *
 * This data transfer object carries the parameters required to create
 * a price list item resource through the Accounting REST API. It is serialized
 * to JSON automatically before being sent in the HTTP request body.
 * All validation is performed server-side by the API, which will return
 * appropriate error responses if required fields are missing or invalid.
 * Use the builder pattern to construct instances of this class with the
 * desired field values before passing it to the corresponding API method.
 *
 * Fields:
 * - priceListId: price list id
 * - serviceId: service id
 * - serviceName: service name
 * - unitPrice: unit price
 * - currency: currency
 *
 * @author Essabu Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePriceListItemRequest {
    private UUID priceListId;
    private UUID serviceId;
    private String serviceName;
    private long unitPrice;
    private String currency;
}
