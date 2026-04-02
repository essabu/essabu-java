package examples;

import com.essabu.accounting.model.common.AccountingEvent;
import com.essabu.accounting.webhook.WebhookListener;
import com.essabu.accounting.webhook.WebhookVerifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Example: Handle webhooks from Essabu in a Spring Boot application.
 *
 * Demonstrates:
 * - Implementing the WebhookListener interface
 * - Setting up webhook signature verification
 * - Routing events by type
 * - Spring Boot auto-configuration
 *
 * Configuration in application.yml:
 * <pre>
 * essabu:
 *   api-key: ${ESSABU_API_KEY}
 *   tenant-id: ${ESSABU_TENANT_ID}
 *   accounting:
 *     webhook:
 *       path: /api/accounting-events
 *       secret: ${ESSABU_WEBHOOK_SECRET}
 * </pre>
 */
@SpringBootApplication
public class WebhookHandler {

    public static void main(String[] args) {
        SpringApplication.run(WebhookHandler.class, args);
    }

    /**
     * Register the webhook listener bean.
     * The SDK auto-configuration injects it into the SpringWebhookController.
     */
    @Bean
    public WebhookListener accountingWebhookListener() {
        return new AccountingWebhookHandler();
    }

    /**
     * Custom webhook listener implementation that routes events by type.
     */
    static class AccountingWebhookHandler implements WebhookListener {

        @Override
        public void onEvent(AccountingEvent event) {
            System.out.println("Received event: " + event.getType());
            System.out.println("Payload: " + event.getPayload());

            // Route events by type
            switch (event.getType()) {
                case "invoice.created" -> handleInvoiceCreated(event);
                case "invoice.paid" -> handleInvoicePaid(event);
                case "invoice.overdue" -> handleInvoiceOverdue(event);
                case "payment.received" -> handlePaymentReceived(event);
                case "payment.failed" -> handlePaymentFailed(event);
                default -> System.out.println("Unhandled event type: " + event.getType());
            }
        }

        private void handleInvoiceCreated(AccountingEvent event) {
            System.out.println("New invoice created!");
            // Extract invoice details from event.getPayload()
            // Send notification, update dashboard, etc.
        }

        private void handleInvoicePaid(AccountingEvent event) {
            System.out.println("Invoice has been paid!");
            // Update internal records, send receipt, etc.
        }

        private void handleInvoiceOverdue(AccountingEvent event) {
            System.out.println("Invoice is overdue!");
            // Send reminder email, escalate, etc.
        }

        private void handlePaymentReceived(AccountingEvent event) {
            System.out.println("Payment received!");
            // Reconcile accounts, update balance, etc.
        }

        private void handlePaymentFailed(AccountingEvent event) {
            System.err.println("Payment failed!");
            // Retry payment, notify customer, etc.
        }
    }
}
