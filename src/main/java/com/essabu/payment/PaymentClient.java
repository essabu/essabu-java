package com.essabu.payment;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.payment.api.payment.*;
import com.essabu.payment.api.subscription.*;
import com.essabu.payment.api.lending.*;

/**
 * Payment module client providing access to all Payment API endpoints.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class PaymentClient {

    private final HttpClientWrapper http;

    // Payment module
    private volatile PaymentIntentApi paymentIntentApi;
    private volatile PaymentTransactionApi paymentTransactionApi;
    private volatile PaymentAccountApi paymentAccountApi;
    private volatile PayoutApi payoutApi;
    private volatile RefundApi refundApi;
    private volatile SdkApiKeyApi sdkApiKeyApi;
    private volatile SettlementApi settlementApi;
    private volatile WebhookApi webhookApi;

    // Subscription module
    private volatile BillingCycleApi billingCycleApi;
    private volatile SaasInvoiceApi saasInvoiceApi;
    private volatile SubscriptionApi subscriptionApi;
    private volatile UsageApi usageApi;

    // Lending module
    private volatile CollateralApi collateralApi;
    private volatile FinancialAccountApi financialAccountApi;
    private volatile KycDocumentApi kycDocumentApi;
    private volatile KycProfileApi kycProfileApi;
    private volatile LoanApplicationApi loanApplicationApi;
    private volatile LoanProductApi loanProductApi;

    public PaymentClient(HttpClientWrapper http) {
        this.http = http;
    }

    // Payment
    public PaymentIntentApi paymentIntents() { if (paymentIntentApi == null) { synchronized (this) { if (paymentIntentApi == null) { paymentIntentApi = new PaymentIntentApi(http); } } } return paymentIntentApi; }
    public PaymentTransactionApi paymentTransactions() { if (paymentTransactionApi == null) { synchronized (this) { if (paymentTransactionApi == null) { paymentTransactionApi = new PaymentTransactionApi(http); } } } return paymentTransactionApi; }
    public PaymentAccountApi paymentAccounts() { if (paymentAccountApi == null) { synchronized (this) { if (paymentAccountApi == null) { paymentAccountApi = new PaymentAccountApi(http); } } } return paymentAccountApi; }
    public PayoutApi payouts() { if (payoutApi == null) { synchronized (this) { if (payoutApi == null) { payoutApi = new PayoutApi(http); } } } return payoutApi; }
    public RefundApi refunds() { if (refundApi == null) { synchronized (this) { if (refundApi == null) { refundApi = new RefundApi(http); } } } return refundApi; }
    public SdkApiKeyApi sdkApiKeys() { if (sdkApiKeyApi == null) { synchronized (this) { if (sdkApiKeyApi == null) { sdkApiKeyApi = new SdkApiKeyApi(http); } } } return sdkApiKeyApi; }
    public SettlementApi settlements() { if (settlementApi == null) { synchronized (this) { if (settlementApi == null) { settlementApi = new SettlementApi(http); } } } return settlementApi; }
    public WebhookApi webhooks() { if (webhookApi == null) { synchronized (this) { if (webhookApi == null) { webhookApi = new WebhookApi(http); } } } return webhookApi; }

    // Subscription
    public SubscriptionApi subscriptions() { if (subscriptionApi == null) { synchronized (this) { if (subscriptionApi == null) { subscriptionApi = new SubscriptionApi(http); } } } return subscriptionApi; }
    public BillingCycleApi billingCycles() { if (billingCycleApi == null) { synchronized (this) { if (billingCycleApi == null) { billingCycleApi = new BillingCycleApi(http); } } } return billingCycleApi; }
    public SaasInvoiceApi saasInvoices() { if (saasInvoiceApi == null) { synchronized (this) { if (saasInvoiceApi == null) { saasInvoiceApi = new SaasInvoiceApi(http); } } } return saasInvoiceApi; }
    public UsageApi usages() { if (usageApi == null) { synchronized (this) { if (usageApi == null) { usageApi = new UsageApi(http); } } } return usageApi; }

    // Lending
    public LoanApplicationApi loanApplications() { if (loanApplicationApi == null) { synchronized (this) { if (loanApplicationApi == null) { loanApplicationApi = new LoanApplicationApi(http); } } } return loanApplicationApi; }
    public LoanProductApi loanProducts() { if (loanProductApi == null) { synchronized (this) { if (loanProductApi == null) { loanProductApi = new LoanProductApi(http); } } } return loanProductApi; }
    public CollateralApi collaterals() { if (collateralApi == null) { synchronized (this) { if (collateralApi == null) { collateralApi = new CollateralApi(http); } } } return collateralApi; }
    public FinancialAccountApi financialAccounts() { if (financialAccountApi == null) { synchronized (this) { if (financialAccountApi == null) { financialAccountApi = new FinancialAccountApi(http); } } } return financialAccountApi; }
    public KycProfileApi kycProfiles() { if (kycProfileApi == null) { synchronized (this) { if (kycProfileApi == null) { kycProfileApi = new KycProfileApi(http); } } } return kycProfileApi; }
    public KycDocumentApi kycDocuments() { if (kycDocumentApi == null) { synchronized (this) { if (kycDocumentApi == null) { kycDocumentApi = new KycDocumentApi(http); } } } return kycDocumentApi; }
}
