package examples;

import com.essabu.Essabu;
import com.essabu.accounting.model.transactions.request.CreateInvoiceRequest;
import com.essabu.accounting.model.transactions.response.InvoiceResponse;
import com.essabu.common.exception.EssabuApiException;
import com.essabu.common.exception.EssabuNotFoundException;
import com.essabu.common.exception.EssabuValidationException;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

/**
 * Example: Create, finalize, and manage invoices using the Essabu Accounting module.
 *
 * Demonstrates:
 * - Creating a draft invoice
 * - Finalizing an invoice
 * - Sending an invoice by email
 * - Marking an invoice as paid
 * - Downloading the PDF
 * - Listing invoices with pagination
 */
public class CreateInvoice {

    public static void main(String[] args) {
        Essabu essabu = Essabu.builder()
                .apiKey("sk_live_your_api_key")
                .tenantId("your-tenant-id")
                .build();

        UUID companyId = UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeeee");

        try {
            // 1. Create a draft invoice
            CreateInvoiceRequest request = CreateInvoiceRequest.builder()
                    .companyId(companyId)
                    .customerId(UUID.fromString("11111111-2222-3333-4444-555555555555"))
                    .currency("USD")
                    .build();

            InvoiceResponse invoice = essabu.accounting().invoices().create(request);
            System.out.println("Invoice created: " + invoice.getId());

            // 2. Finalize the invoice (locks it, assigns number)
            InvoiceResponse finalized = essabu.accounting().invoices().finalize(invoice.getId());
            System.out.println("Invoice finalized: " + finalized.getStatus());

            // 3. Send the invoice to the customer by email
            essabu.accounting().invoices().send(finalized.getId());
            System.out.println("Invoice sent to customer");

            // 4. Mark the invoice as paid
            InvoiceResponse paid = essabu.accounting().invoices().markAsPaid(finalized.getId());
            System.out.println("Invoice marked as paid: " + paid.getStatus());

            // 5. Download the PDF
            byte[] pdf = essabu.accounting().invoices().downloadPdf(finalized.getId());
            Files.write(Path.of("invoice-" + finalized.getId() + ".pdf"), pdf);
            System.out.println("PDF saved (" + pdf.length + " bytes)");

            // 6. List invoices for the company
            PageResponse<InvoiceResponse> invoices = essabu.accounting().invoices()
                    .list(companyId, PageRequest.of(0, 10));
            System.out.println("Total invoices: " + invoices.getTotalElements());
            invoices.getContent().forEach(inv ->
                    System.out.println("  - " + inv.getId() + " [" + inv.getStatus() + "]"));

        } catch (EssabuNotFoundException e) {
            System.err.println("Resource not found: " + e.getMessage());
        } catch (EssabuValidationException e) {
            System.err.println("Validation failed:");
            e.getFieldErrors().forEach((field, msg) ->
                    System.err.println("  " + field + ": " + msg));
        } catch (EssabuApiException e) {
            System.err.println("API error (HTTP " + e.getStatusCode() + "): " + e.getMessage());
        } catch (IOException e) {
            System.err.println("File I/O error: " + e.getMessage());
        }
    }
}
