/*
 * SpringBootExample.java - Essabu Java SDK with Spring Boot
 *
 * This example demonstrates how to use the Essabu SDK in a Spring Boot application
 * with auto-configuration. Instead of manually building the client, the SDK
 * auto-configures an Essabu bean based on properties in application.yml:
 *
 *   essabu:
 *     api-key: ess_live_your_api_key
 *     tenant-id: your-tenant-uuid
 *
 * The example shows two common use cases:
 *
 * 1. Listing projects with pagination - Demonstrates reading paginated data from
 *    the Project module and iterating through the results.
 *
 * 2. Creating a payment intent - Demonstrates creating a payment intent in the
 *    Payment module with an amount, currency, and description. The intent can then
 *    be confirmed to execute the charge.
 *
 * Prerequisites:
 * - Spring Boot 3.3+ application with the essabu-java dependency
 * - essabu.api-key and essabu.tenant-id configured in application.yml
 * - The Essabu bean is thread-safe and can be shared across all components
 *
 * Note: The @Service annotation is commented out to keep this as a standalone
 * compilable example. Uncomment it when integrating into your Spring Boot project.
 */

import com.essabu.Essabu;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;

/**
 * Example demonstrating Essabu SDK usage in a Spring Boot application.
 *
 * Configuration in application.yml:
 * <pre>
 * essabu:
 *   api-key: ess_live_your_api_key
 *   tenant-id: your-tenant-uuid
 * </pre>
 *
 * The Essabu bean is auto-configured and can be injected directly.
 */
// @Service
public class SpringBootExample {

    private final Essabu essabu;

    public SpringBootExample(Essabu essabu) {
        this.essabu = essabu;
    }

    public void listProjects() {
        PageRequest page = PageRequest.builder().page(0).size(20).build();
        PageResponse<Map> projects = essabu.project().projects().list(page);
        projects.getContent().forEach(p ->
                System.out.println("Project: " + p.get("name"))
        );
    }

    public void createPaymentIntent() {
        Map intent = essabu.payment().intents().create(Map.of(
                "amount", 50000,
                "currency", "XAF",
                "description", "Order #12345"
        ));
        System.out.println("Payment intent: " + intent.get("id"));
    }
}
