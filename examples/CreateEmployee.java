package examples;

import com.essabu.Essabu;
import com.essabu.common.exception.EssabuApiException;
import com.essabu.common.exception.EssabuValidationException;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.hr.model.core.request.CreateEmployeeRequest;
import com.essabu.hr.model.core.response.EmployeeResponse;

/**
 * Example: Create and manage employees using the Essabu HR module.
 *
 * Demonstrates:
 * - Creating an employee
 * - Listing employees with pagination
 * - Retrieving a single employee
 * - Handling validation errors
 */
public class CreateEmployee {

    public static void main(String[] args) {
        // 1. Initialize the SDK
        Essabu essabu = Essabu.builder()
                .apiKey("sk_live_your_api_key")
                .tenantId("your-tenant-id")
                .build();

        try {
            // 2. Create a new employee
            CreateEmployeeRequest request = CreateEmployeeRequest.builder()
                    .firstName("Jean")
                    .lastName("Dupont")
                    .email("jean.dupont@example.com")
                    .phone("+243810000000")
                    .build();

            EmployeeResponse employee = essabu.hr().employees().create(request);
            System.out.println("Employee created: " + employee.getId());
            System.out.println("Name: " + employee.getFirstName() + " " + employee.getLastName());

            // 3. List all employees (first page, 20 items)
            PageResponse<EmployeeResponse> employees = essabu.hr().employees().list(PageRequest.first());
            System.out.println("Total employees: " + employees.getTotalElements());

            for (EmployeeResponse emp : employees.getContent()) {
                System.out.println("  - " + emp.getFirstName() + " " + emp.getLastName());
            }

            // 4. List with custom pagination and sorting
            PageRequest customPage = PageRequest.builder()
                    .page(0)
                    .size(50)
                    .sort("createdAt")
                    .direction("desc")
                    .build();
            essabu.hr().employees().list(customPage);

            // 5. Retrieve a specific employee
            EmployeeResponse fetched = essabu.hr().employees().get(employee.getId());
            System.out.println("Fetched: " + fetched.getFirstName());

            // 6. Retrieve leave balances for the employee
            var leaveBalances = essabu.hr().employees().getLeaveBalances(employee.getId());
            leaveBalances.forEach(lb ->
                    System.out.println("  Leave type: " + lb));

        } catch (EssabuValidationException e) {
            // Validation errors include field-level details
            System.err.println("Validation failed (HTTP " + e.getStatusCode() + "):");
            e.getFieldErrors().forEach((field, message) ->
                    System.err.println("  " + field + ": " + message));
        } catch (EssabuApiException e) {
            System.err.println("API error (HTTP " + e.getStatusCode() + "): " + e.getMessage());
        }
    }
}
