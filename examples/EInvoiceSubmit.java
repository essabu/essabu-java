package examples;

import com.essabu.Essabu;
import com.essabu.common.exception.EssabuApiException;
import com.essabu.common.exception.EssabuValidationException;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.einvoice.model.invoice.request.SubmitToGovernmentRequest;
import com.essabu.einvoice.model.invoice.response.GovernmentSubmissionResponse;

import java.util.UUID;

/**
 * Example: Electronic invoicing flow using the Essabu E-Invoice module.
 *
 * Demonstrates:
 * - Submitting an invoice to the government system
 * - Checking submission status
 * - Listing submissions for a company
 * - Compliance verification
 */
public class EInvoiceSubmit {

    public static void main(String[] args) {
        Essabu essabu = Essabu.builder()
                .apiKey("sk_live_your_api_key")
                .tenantId("your-tenant-id")
                .build();

        UUID companyId = UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeeee");
        UUID invoiceId = UUID.fromString("11111111-2222-3333-4444-555555555555");

        try {
            // 1. Submit a normalized invoice to the government
            SubmitToGovernmentRequest submitRequest = SubmitToGovernmentRequest.builder()
                    .invoiceId(invoiceId)
                    .build();

            GovernmentSubmissionResponse submission = essabu.einvoice().submissions().submit(submitRequest);
            System.out.println("Submission created: " + submission.getId());
            System.out.println("Status: " + submission.getStatus());

            // 2. Check the submission status (poll until accepted or rejected)
            GovernmentSubmissionResponse status = essabu.einvoice().submissions()
                    .checkStatus(submission.getId());
            System.out.println("Submission status: " + status.getStatus());

            // 3. List all submissions for the company
            PageResponse<GovernmentSubmissionResponse> submissions = essabu.einvoice().submissions()
                    .list(companyId, PageRequest.of(0, 20));
            System.out.println("Total submissions: " + submissions.getTotalElements());
            submissions.getContent().forEach(sub ->
                    System.out.println("  - " + sub.getId() + " [" + sub.getStatus() + "]"));

            // 4. List with default pagination
            PageResponse<GovernmentSubmissionResponse> firstPage = essabu.einvoice().submissions()
                    .list(companyId);
            System.out.println("First page: " + firstPage.getContent().size() + " submissions");

        } catch (EssabuValidationException e) {
            System.err.println("Validation failed:");
            e.getFieldErrors().forEach((field, msg) ->
                    System.err.println("  " + field + ": " + msg));
        } catch (EssabuApiException e) {
            System.err.println("API error (HTTP " + e.getStatusCode() + "): " + e.getMessage());
        }
    }
}
