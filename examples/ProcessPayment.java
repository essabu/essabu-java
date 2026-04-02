package examples;

import com.essabu.Essabu;
import com.essabu.common.exception.EssabuApiException;
import com.essabu.common.exception.EssabuValidationException;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.payment.model.payment.request.CreatePaymentIntentRequest;
import com.essabu.payment.model.payment.response.PaymentIntentResponse;

import java.util.UUID;

/**
 * Example: Process payments using the Essabu Payment module.
 *
 * Demonstrates:
 * - Creating a payment intent
 * - Confirming a payment
 * - Retrieving payment status
 * - Cancelling a payment
 * - Listing payment intents
 */
public class ProcessPayment {

    public static void main(String[] args) {
        Essabu essabu = Essabu.builder()
                .apiKey("sk_live_your_api_key")
                .tenantId("your-tenant-id")
                .build();

        UUID companyId = UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeeee");

        try {
            // 1. Create a payment intent
            CreatePaymentIntentRequest request = CreatePaymentIntentRequest.builder()
                    .companyId(companyId)
                    .amount(15000L)      // Amount in cents (150.00 USD)
                    .currency("USD")
                    .description("Invoice #INV-2024-001 payment")
                    .build();

            PaymentIntentResponse intent = essabu.payment().paymentIntents().create(request);
            System.out.println("Payment intent created: " + intent.getId());
            System.out.println("Status: " + intent.getStatus());

            // 2. Confirm the payment (after customer authorization)
            PaymentIntentResponse confirmed = essabu.payment().paymentIntents().confirm(intent.getId());
            System.out.println("Payment confirmed: " + confirmed.getStatus());

            // 3. Retrieve the payment intent to check status
            PaymentIntentResponse fetched = essabu.payment().paymentIntents().getById(intent.getId());
            System.out.println("Current status: " + fetched.getStatus());

            // 4. List payment intents for the company
            PageResponse<PaymentIntentResponse> intents = essabu.payment().paymentIntents()
                    .getByCompany(companyId, PageRequest.of(0, 20));
            System.out.println("Total payment intents: " + intents.getTotalElements());
            intents.getContent().forEach(pi ->
                    System.out.println("  - " + pi.getId() + " [" + pi.getStatus() + "]"));

            // 5. Cancel a payment intent (if not yet confirmed)
            // PaymentIntentResponse cancelled = essabu.payment().paymentIntents().cancel(intent.getId());

        } catch (EssabuValidationException e) {
            System.err.println("Validation failed:");
            e.getFieldErrors().forEach((field, msg) ->
                    System.err.println("  " + field + ": " + msg));
        } catch (EssabuApiException e) {
            System.err.println("API error (HTTP " + e.getStatusCode() + "): " + e.getMessage());
        }
    }
}
