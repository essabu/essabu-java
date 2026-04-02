package com.essabu.einvoice;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.einvoice.api.invoice.InvoiceApi;
import com.essabu.einvoice.api.invoice.SubmissionApi;
import com.essabu.einvoice.api.verification.ComplianceApi;
import com.essabu.einvoice.api.verification.StatisticsApi;
import com.essabu.einvoice.api.verification.VerificationApi;

/**
 * E-Invoice module client providing access to all E-Invoice API endpoints.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class EInvoiceClient {

    private final HttpClientWrapper http;

    private volatile InvoiceApi invoiceApi;
    private volatile SubmissionApi submissionApi;
    private volatile VerificationApi verificationApi;
    private volatile ComplianceApi complianceApi;
    private volatile StatisticsApi statisticsApi;

    public EInvoiceClient(HttpClientWrapper http) {
        this.http = http;
    }

    public InvoiceApi invoices() { if (invoiceApi == null) { synchronized (this) { if (invoiceApi == null) { invoiceApi = new InvoiceApi(http); } } } return invoiceApi; }
    public SubmissionApi submissions() { if (submissionApi == null) { synchronized (this) { if (submissionApi == null) { submissionApi = new SubmissionApi(http); } } } return submissionApi; }
    public VerificationApi verification() { if (verificationApi == null) { synchronized (this) { if (verificationApi == null) { verificationApi = new VerificationApi(http); } } } return verificationApi; }
    public ComplianceApi compliance() { if (complianceApi == null) { synchronized (this) { if (complianceApi == null) { complianceApi = new ComplianceApi(http); } } } return complianceApi; }
    public StatisticsApi statistics() { if (statisticsApi == null) { synchronized (this) { if (statisticsApi == null) { statisticsApi = new StatisticsApi(http); } } } return statisticsApi; }
}
