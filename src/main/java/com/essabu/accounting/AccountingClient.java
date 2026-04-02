package com.essabu.accounting;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.accounting.api.core.*;
import com.essabu.accounting.api.transactions.*;
import com.essabu.accounting.api.finance.*;
import com.essabu.accounting.api.commercial.*;
import com.essabu.accounting.api.inventory.*;

/**
 * Accounting module client providing access to all Accounting API endpoints.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class AccountingClient {

    private final HttpClientWrapper http;

    private volatile AccountApi accountApi;
    private volatile BalanceApi balanceApi;
    private volatile JournalApi journalApi;
    private volatile JournalEntryApi journalEntryApi;
    private volatile InvoiceApi invoiceApi;
    private volatile QuoteApi quoteApi;
    private volatile CreditNoteApi creditNoteApi;
    private volatile PaymentApi paymentApi;
    private volatile PaymentTermApi paymentTermApi;
    private volatile TaxRateApi taxRateApi;
    private volatile CurrencyApi currencyApi;
    private volatile ExchangeRateApi exchangeRateApi;
    private volatile ExchangeRateProviderApi exchangeRateProviderApi;
    private volatile FiscalYearApi fiscalYearApi;
    private volatile PeriodApi periodApi;
    private volatile ConfigApi configApi;
    private volatile ReportApi reportApi;
    private volatile WalletApi walletApi;
    private volatile WalletTransactionApi walletTransactionApi;
    private volatile InsurancePartnerApi insurancePartnerApi;
    private volatile InsuranceContractApi insuranceContractApi;
    private volatile InsuranceClaimApi insuranceClaimApi;
    private volatile PriceListApi priceListApi;
    private volatile PriceListOverrideApi priceListOverrideApi;
    private volatile SupplierApi supplierApi;
    private volatile InventoryApi inventoryApi;
    private volatile PurchaseOrderApi purchaseOrderApi;
    private volatile BatchApi batchApi;
    private volatile StockMovementApi stockMovementApi;
    private volatile StockCountApi stockCountApi;
    private volatile StockLocationApi stockLocationApi;
    private volatile WebhookApi webhookApi;

    public AccountingClient(HttpClientWrapper http) {
        this.http = http;
    }

    public AccountApi accounts() { if (accountApi == null) { synchronized (this) { if (accountApi == null) { accountApi = new AccountApi(http); } } } return accountApi; }
    public BalanceApi balances() { if (balanceApi == null) { synchronized (this) { if (balanceApi == null) { balanceApi = new BalanceApi(http); } } } return balanceApi; }
    public JournalApi journals() { if (journalApi == null) { synchronized (this) { if (journalApi == null) { journalApi = new JournalApi(http); } } } return journalApi; }
    public JournalEntryApi journalEntries() { if (journalEntryApi == null) { synchronized (this) { if (journalEntryApi == null) { journalEntryApi = new JournalEntryApi(http); } } } return journalEntryApi; }
    public InvoiceApi invoices() { if (invoiceApi == null) { synchronized (this) { if (invoiceApi == null) { invoiceApi = new InvoiceApi(http); } } } return invoiceApi; }
    public QuoteApi quotes() { if (quoteApi == null) { synchronized (this) { if (quoteApi == null) { quoteApi = new QuoteApi(http); } } } return quoteApi; }
    public CreditNoteApi creditNotes() { if (creditNoteApi == null) { synchronized (this) { if (creditNoteApi == null) { creditNoteApi = new CreditNoteApi(http); } } } return creditNoteApi; }
    public PaymentApi payments() { if (paymentApi == null) { synchronized (this) { if (paymentApi == null) { paymentApi = new PaymentApi(http); } } } return paymentApi; }
    public PaymentTermApi paymentTerms() { if (paymentTermApi == null) { synchronized (this) { if (paymentTermApi == null) { paymentTermApi = new PaymentTermApi(http); } } } return paymentTermApi; }
    public TaxRateApi taxRates() { if (taxRateApi == null) { synchronized (this) { if (taxRateApi == null) { taxRateApi = new TaxRateApi(http); } } } return taxRateApi; }
    public CurrencyApi currencies() { if (currencyApi == null) { synchronized (this) { if (currencyApi == null) { currencyApi = new CurrencyApi(http); } } } return currencyApi; }
    public ExchangeRateApi exchangeRates() { if (exchangeRateApi == null) { synchronized (this) { if (exchangeRateApi == null) { exchangeRateApi = new ExchangeRateApi(http); } } } return exchangeRateApi; }
    public ExchangeRateProviderApi exchangeRateProviders() { if (exchangeRateProviderApi == null) { synchronized (this) { if (exchangeRateProviderApi == null) { exchangeRateProviderApi = new ExchangeRateProviderApi(http); } } } return exchangeRateProviderApi; }
    public FiscalYearApi fiscalYears() { if (fiscalYearApi == null) { synchronized (this) { if (fiscalYearApi == null) { fiscalYearApi = new FiscalYearApi(http); } } } return fiscalYearApi; }
    public PeriodApi periods() { if (periodApi == null) { synchronized (this) { if (periodApi == null) { periodApi = new PeriodApi(http); } } } return periodApi; }
    public ConfigApi config() { if (configApi == null) { synchronized (this) { if (configApi == null) { configApi = new ConfigApi(http); } } } return configApi; }
    public ReportApi reports() { if (reportApi == null) { synchronized (this) { if (reportApi == null) { reportApi = new ReportApi(http); } } } return reportApi; }
    public WalletApi wallets() { if (walletApi == null) { synchronized (this) { if (walletApi == null) { walletApi = new WalletApi(http); } } } return walletApi; }
    public WalletTransactionApi walletTransactions() { if (walletTransactionApi == null) { synchronized (this) { if (walletTransactionApi == null) { walletTransactionApi = new WalletTransactionApi(http); } } } return walletTransactionApi; }
    public InsurancePartnerApi insurancePartners() { if (insurancePartnerApi == null) { synchronized (this) { if (insurancePartnerApi == null) { insurancePartnerApi = new InsurancePartnerApi(http); } } } return insurancePartnerApi; }
    public InsuranceContractApi insuranceContracts() { if (insuranceContractApi == null) { synchronized (this) { if (insuranceContractApi == null) { insuranceContractApi = new InsuranceContractApi(http); } } } return insuranceContractApi; }
    public InsuranceClaimApi insuranceClaims() { if (insuranceClaimApi == null) { synchronized (this) { if (insuranceClaimApi == null) { insuranceClaimApi = new InsuranceClaimApi(http); } } } return insuranceClaimApi; }
    public PriceListApi priceLists() { if (priceListApi == null) { synchronized (this) { if (priceListApi == null) { priceListApi = new PriceListApi(http); } } } return priceListApi; }
    public PriceListOverrideApi priceListOverrides() { if (priceListOverrideApi == null) { synchronized (this) { if (priceListOverrideApi == null) { priceListOverrideApi = new PriceListOverrideApi(http); } } } return priceListOverrideApi; }
    public SupplierApi suppliers() { if (supplierApi == null) { synchronized (this) { if (supplierApi == null) { supplierApi = new SupplierApi(http); } } } return supplierApi; }
    public InventoryApi inventory() { if (inventoryApi == null) { synchronized (this) { if (inventoryApi == null) { inventoryApi = new InventoryApi(http); } } } return inventoryApi; }
    public PurchaseOrderApi purchaseOrders() { if (purchaseOrderApi == null) { synchronized (this) { if (purchaseOrderApi == null) { purchaseOrderApi = new PurchaseOrderApi(http); } } } return purchaseOrderApi; }
    public BatchApi batches() { if (batchApi == null) { synchronized (this) { if (batchApi == null) { batchApi = new BatchApi(http); } } } return batchApi; }
    public StockMovementApi stockMovements() { if (stockMovementApi == null) { synchronized (this) { if (stockMovementApi == null) { stockMovementApi = new StockMovementApi(http); } } } return stockMovementApi; }
    public StockCountApi stockCounts() { if (stockCountApi == null) { synchronized (this) { if (stockCountApi == null) { stockCountApi = new StockCountApi(http); } } } return stockCountApi; }
    public StockLocationApi stockLocations() { if (stockLocationApi == null) { synchronized (this) { if (stockLocationApi == null) { stockLocationApi = new StockLocationApi(http); } } } return stockLocationApi; }
    public WebhookApi webhooks() { if (webhookApi == null) { synchronized (this) { if (webhookApi == null) { webhookApi = new WebhookApi(http); } } } return webhookApi; }
}
