package com.essabu.einvoice;

import com.essabu.common.internal.HttpClientWrapper;

/**
 * Client for the E-Invoice service module.
 * Provides access to electronic invoicing and public verification operations.
 */
public final class EInvoiceClient {

    private final HttpClientWrapper http;

    private volatile EInvoiceApi einvoiceApi;
    private volatile VerificationApi verificationApi;

    public EInvoiceClient(HttpClientWrapper http) {
        this.http = http;
    }

    public EInvoiceApi invoices() {
        if (einvoiceApi == null) { synchronized (this) { if (einvoiceApi == null) einvoiceApi = new EInvoiceApi(http); } }
        return einvoiceApi;
    }

    public VerificationApi verification() {
        if (verificationApi == null) { synchronized (this) { if (verificationApi == null) verificationApi = new VerificationApi(http); } }
        return verificationApi;
    }
}
