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
