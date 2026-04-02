package examples;

import com.essabu.Essabu;
import com.essabu.common.exception.EssabuApiException;
import com.essabu.common.exception.EssabuValidationException;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;
import com.essabu.payment.model.lending.request.ApproveLoanRequest;
import com.essabu.payment.model.lending.request.CreateLoanApplicationRequest;
import com.essabu.payment.model.lending.request.RepayLoanRequest;
import com.essabu.payment.model.lending.response.LoanApplicationResponse;
import com.essabu.payment.model.lending.response.LoanRepaymentResponse;
import com.essabu.payment.model.lending.response.LoanScheduleResponse;

import java.util.List;
import java.util.UUID;

/**
 * Example: Complete loan lifecycle using the Essabu Payment (Lending) module.
 *
 * Demonstrates:
 * - Creating a loan application
 * - Submitting for review
 * - Approving the loan
 * - Disbursing funds
 * - Recording a repayment
 * - Viewing the repayment schedule
 */
public class LoanApplication {

    public static void main(String[] args) {
        Essabu essabu = Essabu.builder()
                .apiKey("sk_live_your_api_key")
                .tenantId("your-tenant-id")
                .build();

        UUID companyId = UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeeee");

        try {
            // 1. Create a loan application
            CreateLoanApplicationRequest request = CreateLoanApplicationRequest.builder()
                    .companyId(companyId)
                    .amount(500000L)         // 5,000.00 in cents
                    .currency("USD")
                    .purpose("Business expansion")
                    .termMonths(12)
                    .build();

            LoanApplicationResponse loan = essabu.payment().loanApplications().create(request);
            System.out.println("Loan application created: " + loan.getId());
            System.out.println("Status: " + loan.getStatus());

            // 2. Submit the application for review
            LoanApplicationResponse submitted = essabu.payment().loanApplications().submit(loan.getId());
            System.out.println("Submitted for review: " + submitted.getStatus());

            // 3. Approve the loan (typically done by an admin)
            ApproveLoanRequest approveRequest = ApproveLoanRequest.builder()
                    .approvedAmount(500000L)
                    .interestRate(8.5)
                    .build();

            LoanApplicationResponse approved = essabu.payment().loanApplications()
                    .approve(loan.getId(), approveRequest);
            System.out.println("Loan approved: " + approved.getStatus());

            // 4. Disburse the funds
            LoanApplicationResponse disbursed = essabu.payment().loanApplications().disburse(loan.getId());
            System.out.println("Funds disbursed: " + disbursed.getStatus());

            // 5. View the repayment schedule
            List<LoanScheduleResponse> schedule = essabu.payment().loanApplications()
                    .getSchedule(loan.getId());
            System.out.println("Repayment schedule (" + schedule.size() + " installments):");
            schedule.forEach(installment ->
                    System.out.println("  - " + installment));

            // 6. Record a repayment
            RepayLoanRequest repayRequest = RepayLoanRequest.builder()
                    .amount(45000L)  // Monthly installment
                    .build();

            LoanRepaymentResponse repayment = essabu.payment().loanApplications()
                    .repay(loan.getId(), repayRequest);
            System.out.println("Repayment recorded: " + repayment);

            // 7. List all loan applications for the company
            PageResponse<LoanApplicationResponse> loans = essabu.payment().loanApplications()
                    .getByCompany(companyId, PageRequest.first());
            System.out.println("Total loan applications: " + loans.getTotalElements());
            loans.getContent().forEach(l ->
                    System.out.println("  - " + l.getId() + " [" + l.getStatus() + "]"));

        } catch (EssabuValidationException e) {
            System.err.println("Validation failed:");
            e.getFieldErrors().forEach((field, msg) ->
                    System.err.println("  " + field + ": " + msg));
        } catch (EssabuApiException e) {
            System.err.println("API error (HTTP " + e.getStatusCode() + "): " + e.getMessage());
        }
    }
}
