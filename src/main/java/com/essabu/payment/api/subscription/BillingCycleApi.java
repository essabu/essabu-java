package com.essabu.payment.api.subscription;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.payment.model.subscription.response.BillingCycleResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing billing cycle resources in the Essabu Payment module.
 *
 * Provides typed methods to interact with the billing cycle REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Base path: /api/payment/billing-cycles
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class BillingCycleApi extends BaseApi {

    private static final String BASE_PATH = "/api/payment/billing-cycles";

    public BillingCycleApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Lists the billing cycles of a subscription.
     */
    public List<BillingCycleResponse> getBySubscription(UUID subscriptionId) {
        String path = withParam(BASE_PATH, "subscriptionId", subscriptionId);
        return http.get(path, new TypeReference<>() {});
    }
}
