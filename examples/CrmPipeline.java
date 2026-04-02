package examples;

import com.essabu.Essabu;
import com.essabu.common.exception.EssabuApiException;
import com.essabu.common.exception.EssabuValidationException;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.trade.model.commerce.request.CreateCustomerRequest;
import com.essabu.trade.model.commerce.request.CreateSalesOrderRequest;
import com.essabu.trade.model.commerce.response.CustomerResponse;
import com.essabu.trade.model.commerce.response.SalesOrderResponse;

import java.util.UUID;

/**
 * Example: CRM pipeline flow using the Essabu Trade module.
 *
 * Demonstrates:
 * - Creating a customer
 * - Listing customers with pagination
 * - Creating a sales order for a customer
 * - Confirming a sales order
 * - Tracking the sales pipeline
 */
public class CrmPipeline {

    public static void main(String[] args) {
        Essabu essabu = Essabu.builder()
                .apiKey("sk_live_your_api_key")
                .tenantId("your-tenant-id")
                .build();

        UUID companyId = UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeeee");

        try {
            // 1. Create a new customer (lead)
            CreateCustomerRequest customerRequest = CreateCustomerRequest.builder()
                    .companyId(companyId)
                    .name("Acme Corporation")
                    .email("contact@acme.com")
                    .phone("+243810000000")
                    .address("123 Business Ave, Kinshasa")
                    .build();

            CustomerResponse customer = essabu.trade().customers().create(customerRequest);
            System.out.println("Customer created: " + customer.getId());
            System.out.println("Name: " + customer.getName());

            // 2. List all customers for the company
            PageResponse<CustomerResponse> customers = essabu.trade().customers()
                    .getAll(companyId, PageRequest.first());
            System.out.println("Total customers: " + customers.getTotalElements());
            customers.getContent().forEach(c ->
                    System.out.println("  - " + c.getName() + " (" + c.getEmail() + ")"));

            // 3. Create a sales order for the customer
            CreateSalesOrderRequest orderRequest = CreateSalesOrderRequest.builder()
                    .companyId(companyId)
                    .customerId(customer.getId())
                    .currency("USD")
                    .build();

            SalesOrderResponse order = essabu.trade().salesOrders().create(orderRequest);
            System.out.println("Sales order created: " + order.getId());

            // 4. Confirm the sales order (move from draft to confirmed)
            SalesOrderResponse confirmed = essabu.trade().salesOrders().confirm(order.getId());
            System.out.println("Sales order confirmed: " + confirmed.getStatus());

            // 5. List all sales orders for the company
            PageResponse<SalesOrderResponse> orders = essabu.trade().salesOrders()
                    .getAll(companyId, PageRequest.builder()
                            .page(0)
                            .size(10)
                            .sort("createdAt")
                            .direction("desc")
                            .build());
            System.out.println("Total sales orders: " + orders.getTotalElements());
            orders.getContent().forEach(o ->
                    System.out.println("  - " + o.getId() + " [" + o.getStatus() + "]"));

            // 6. Retrieve a specific customer
            CustomerResponse fetched = essabu.trade().customers().getById(customer.getId());
            System.out.println("Customer details: " + fetched.getName());

        } catch (EssabuValidationException e) {
            System.err.println("Validation failed:");
            e.getFieldErrors().forEach((field, msg) ->
                    System.err.println("  " + field + ": " + msg));
        } catch (EssabuApiException e) {
            System.err.println("API error (HTTP " + e.getStatusCode() + "): " + e.getMessage());
        }
    }
}
