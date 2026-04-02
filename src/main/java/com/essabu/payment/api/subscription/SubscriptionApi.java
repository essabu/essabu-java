package com.essabu.payment.api.subscription;

import com.essabu.common.BaseApi;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.payment.model.subscription.request.CreateSubscriptionRequest;
import com.essabu.payment.model.subscription.request.UpgradeSubscriptionRequest;
import com.essabu.payment.model.subscription.response.SubscriptionPlanResponse;
import com.essabu.payment.model.subscription.response.SubscriptionResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.UUID;

/**
 * API client for managing subscription resources in the Essabu Payment module.
 *
 * Provides typed methods to interact with the subscription REST API endpoints
 * including creation, retrieval, update, deletion, and listing with pagination.
 * All methods handle JSON serialization and deserialization, authentication
 * headers, and error mapping automatically. Network errors and server failures
 * are retried according to the client configuration. Rate limit responses are
 * detected and surfaced as specific exceptions with retry-after information.
 *
 * Available operations:
 * - create: create operation
 * - upgrade: upgrade operation
 * - cancel: cancel operation
 *
 * Base path: /api/payment/subscriptions
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class SubscriptionApi extends BaseApi {

    private static final String BASE_PATH = "/api/payment/subscriptions";

    public SubscriptionApi(HttpClientWrapper http) {
        super(http);
    }

    /**
     * Creates a new subscription.
     */
    public SubscriptionResponse create(CreateSubscriptionRequest request) {
        return http.post(BASE_PATH, request, SubscriptionResponse.class);
    }

    /**
     * Retrieves the subscription of a company.
     */
    public SubscriptionResponse getByCompany(UUID companyId) {
        String path = withParam(BASE_PATH, "companyId", companyId);
        return http.get(path, SubscriptionResponse.class);
    }

    /**
     * Upgrades a subscription.
     */
    public SubscriptionResponse upgrade(UUID id, UpgradeSubscriptionRequest request) {
        return http.put(BASE_PATH + "/" + id + "/upgrade", request, SubscriptionResponse.class);
    }

    /**
     * Cancels a subscription.
     */
    public SubscriptionResponse cancel(UUID id) {
        return http.post(BASE_PATH + "/" + id + "/cancel", null, SubscriptionResponse.class);
    }

    /**
     * Lists the available subscription plans.
     */
    public List<SubscriptionPlanResponse> getPlans() {
        return http.get(BASE_PATH + "/plans", new TypeReference<>() {});
    }
}
