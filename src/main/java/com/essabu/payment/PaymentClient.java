package com.essabu.payment;

import com.essabu.common.internal.HttpClientWrapper;

/**
 * Client for the Payment service module.
 * Provides access to payment intents, transactions, subscriptions, lending, and more.
 */
public final class PaymentClient {

    private final HttpClientWrapper http;

    private volatile PaymentIntentApi paymentIntentApi;
    private volatile TransactionApi transactionApi;
    private volatile RefundApi refundApi;
    private volatile PayoutApi payoutApi;
    private volatile SubscriptionApi subscriptionApi;
    private volatile LoanApi loanApi;
    private volatile KycApi kycApi;
    private volatile PaymentAccountApi paymentAccountApi;
    private volatile ReportApi reportApi;

    public PaymentClient(HttpClientWrapper http) {
        this.http = http;
    }

    public PaymentIntentApi intents() {
        if (paymentIntentApi == null) { synchronized (this) { if (paymentIntentApi == null) paymentIntentApi = new PaymentIntentApi(http); } }
        return paymentIntentApi;
    }

    public TransactionApi transactions() {
        if (transactionApi == null) { synchronized (this) { if (transactionApi == null) transactionApi = new TransactionApi(http); } }
        return transactionApi;
    }

    public RefundApi refunds() {
        if (refundApi == null) { synchronized (this) { if (refundApi == null) refundApi = new RefundApi(http); } }
        return refundApi;
    }

    public PayoutApi payouts() {
        if (payoutApi == null) { synchronized (this) { if (payoutApi == null) payoutApi = new PayoutApi(http); } }
        return payoutApi;
    }

    public SubscriptionApi subscriptions() {
        if (subscriptionApi == null) { synchronized (this) { if (subscriptionApi == null) subscriptionApi = new SubscriptionApi(http); } }
        return subscriptionApi;
    }

    public LoanApi loans() {
        if (loanApi == null) { synchronized (this) { if (loanApi == null) loanApi = new LoanApi(http); } }
        return loanApi;
    }

    public KycApi kyc() {
        if (kycApi == null) { synchronized (this) { if (kycApi == null) kycApi = new KycApi(http); } }
        return kycApi;
    }

    public PaymentAccountApi accounts() {
        if (paymentAccountApi == null) { synchronized (this) { if (paymentAccountApi == null) paymentAccountApi = new PaymentAccountApi(http); } }
        return paymentAccountApi;
    }

    public ReportApi reports() {
        if (reportApi == null) { synchronized (this) { if (reportApi == null) reportApi = new ReportApi(http); } }
        return reportApi;
    }
}
