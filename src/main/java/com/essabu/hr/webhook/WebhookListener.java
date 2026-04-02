package com.essabu.hr.webhook;

import com.essabu.hr.model.common.HrEvent;

/**
 * Listener interface for receiving HR webhook events from the Essabu HR API.
 *
 * Implement this interface to define custom handling logic for HR domain events
 * delivered via webhooks. The onEvent method is called for every validated
 * webhook event received by the SpringWebhookController. Implementations
 * should inspect the event type to determine the appropriate handling logic
 * and extract relevant data from the event payload map.
 *
 * This interface is designed to be implemented by the consuming application
 * and registered as a Spring bean so that the auto-configuration can inject
 * it into the webhook controller. Only one listener implementation should
 * be active at a time; if multiple event-type-specific handlers are needed,
 * implement routing logic within the onEvent method based on the event type.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public interface WebhookListener {

    /**
     * Called when an HR domain event is received via webhook.
     *
     * @param event the deserialized HR event
     */
    void onEvent(HrEvent event);
}
