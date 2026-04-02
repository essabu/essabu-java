import com.essabu.Essabu;
import com.essabu.common.exception.EssabuApiException;
import com.essabu.common.exception.NotFoundException;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.util.Map;
import java.util.UUID;

/**
 * Basic usage example demonstrating the Essabu Java SDK.
 */
public class BasicUsageExample {

    public static void main(String[] args) {
        // 1. Create the client
        Essabu essabu = Essabu.builder()
                .apiKey("ess_live_your_api_key_here")
                .tenantId("your-tenant-uuid")
                .build();

        PageRequest page = PageRequest.builder().page(0).size(10).build();

        // 2. HR: List employees
        UUID companyId = UUID.fromString("00000000-0000-0000-0000-000000000001");
        PageResponse<Map> employees = essabu.hr().employees().list(companyId, page);
        System.out.println("Employees found: " + employees.getTotalElements());

        // 3. Accounting: Create an invoice
        Map invoice = essabu.accounting().invoices().create(Map.of(
                "customerId", "customer-uuid",
                "currency", "XAF"
        ));
        System.out.println("Invoice created: " + invoice.get("id"));

        // 4. Trade: List customers
        PageResponse<Map> customers = essabu.trade().customers().list(page);
        System.out.println("Customers found: " + customers.getTotalElements());

        // 5. Error handling
        try {
            essabu.hr().employees().getById(UUID.randomUUID());
        } catch (NotFoundException e) {
            System.out.println("Employee not found (expected): " + e.getStatusCode());
        } catch (EssabuApiException e) {
            System.out.println("API error: " + e.getStatusCode() + " - " + e.getMessage());
        }
    }
}
