package com.essabu.accounting.webhook;

import com.essabu.accounting.model.common.AccountingEvent;

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
     * Called when an accounting event is received via webhook.
     *
     * @param event the accounting event
     */
    void onEvent(AccountingEvent event);
}
