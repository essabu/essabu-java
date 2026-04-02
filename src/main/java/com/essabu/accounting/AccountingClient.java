package com.essabu.accounting;

import com.essabu.common.internal.HttpClientWrapper;

/**
 * Client for the Accounting service module.
 * Provides access to all accounting-related API resources.
 */
public final class AccountingClient {

    private final HttpClientWrapper http;

    private volatile AccountApi accountApi;
    private volatile InvoiceApi invoiceApi;
    private volatile PaymentApi paymentApi;
    private volatile WalletApi walletApi;
    private volatile JournalApi journalApi;
    private volatile QuoteApi quoteApi;
    private volatile CreditNoteApi creditNoteApi;
    private volatile TaxRateApi taxRateApi;
    private volatile FiscalYearApi fiscalYearApi;
    private volatile CurrencyApi currencyApi;
    private volatile InventoryApi inventoryApi;
    private volatile CouponApi couponApi;
    private volatile ReportApi reportApi;
    private volatile ConfigApi configApi;
    private volatile InsuranceApi insuranceApi;
    private volatile BillingApi billingApi;
    private volatile RecurringInvoiceApi recurringInvoiceApi;

    public AccountingClient(HttpClientWrapper http) {
        this.http = http;
    }

    public AccountApi accounts() {
        if (accountApi == null) { synchronized (this) { if (accountApi == null) accountApi = new AccountApi(http); } }
        return accountApi;
    }

    public InvoiceApi invoices() {
        if (invoiceApi == null) { synchronized (this) { if (invoiceApi == null) invoiceApi = new InvoiceApi(http); } }
        return invoiceApi;
    }

    public PaymentApi payments() {
        if (paymentApi == null) { synchronized (this) { if (paymentApi == null) paymentApi = new PaymentApi(http); } }
        return paymentApi;
    }

    public WalletApi wallets() {
        if (walletApi == null) { synchronized (this) { if (walletApi == null) walletApi = new WalletApi(http); } }
        return walletApi;
    }

    public JournalApi journals() {
        if (journalApi == null) { synchronized (this) { if (journalApi == null) journalApi = new JournalApi(http); } }
        return journalApi;
    }

    public QuoteApi quotes() {
        if (quoteApi == null) { synchronized (this) { if (quoteApi == null) quoteApi = new QuoteApi(http); } }
        return quoteApi;
    }

    public CreditNoteApi creditNotes() {
        if (creditNoteApi == null) { synchronized (this) { if (creditNoteApi == null) creditNoteApi = new CreditNoteApi(http); } }
        return creditNoteApi;
    }

    public TaxRateApi taxRates() {
        if (taxRateApi == null) { synchronized (this) { if (taxRateApi == null) taxRateApi = new TaxRateApi(http); } }
        return taxRateApi;
    }

    public FiscalYearApi fiscalYears() {
        if (fiscalYearApi == null) { synchronized (this) { if (fiscalYearApi == null) fiscalYearApi = new FiscalYearApi(http); } }
        return fiscalYearApi;
    }

    public CurrencyApi currencies() {
        if (currencyApi == null) { synchronized (this) { if (currencyApi == null) currencyApi = new CurrencyApi(http); } }
        return currencyApi;
    }

    public InventoryApi inventory() {
        if (inventoryApi == null) { synchronized (this) { if (inventoryApi == null) inventoryApi = new InventoryApi(http); } }
        return inventoryApi;
    }

    public CouponApi coupons() {
        if (couponApi == null) { synchronized (this) { if (couponApi == null) couponApi = new CouponApi(http); } }
        return couponApi;
    }

    public ReportApi reports() {
        if (reportApi == null) { synchronized (this) { if (reportApi == null) reportApi = new ReportApi(http); } }
        return reportApi;
    }

    public ConfigApi config() {
        if (configApi == null) { synchronized (this) { if (configApi == null) configApi = new ConfigApi(http); } }
        return configApi;
    }

    public InsuranceApi insurance() {
        if (insuranceApi == null) { synchronized (this) { if (insuranceApi == null) insuranceApi = new InsuranceApi(http); } }
        return insuranceApi;
    }

    public BillingApi billing() {
        if (billingApi == null) { synchronized (this) { if (billingApi == null) billingApi = new BillingApi(http); } }
        return billingApi;
    }

    public RecurringInvoiceApi recurringInvoices() {
        if (recurringInvoiceApi == null) { synchronized (this) { if (recurringInvoiceApi == null) recurringInvoiceApi = new RecurringInvoiceApi(http); } }
        return recurringInvoiceApi;
    }
}
