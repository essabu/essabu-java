package com.essabu;

import com.essabu.accounting.AccountingClient;
import com.essabu.asset.AssetClient;
import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.einvoice.EInvoiceClient;
import com.essabu.hr.HrClient;
import com.essabu.identity.IdentityClient;
import com.essabu.payment.PaymentClient;
import com.essabu.project.ProjectClient;
import com.essabu.trade.TradeClient;

/**
 * Main entry point for the Essabu Java SDK.
 * <p>
 * Provides lazy-initialized accessors for each service module.
 * <pre>{@code
 * Essabu essabu = Essabu.builder()
 *     .apiKey("your-api-key")
 *     .tenantId("your-tenant-id")
 *     .build();
 *
 * var employees = essabu.hr().employees().list(pageRequest);
 * var invoice = essabu.accounting().invoices().getById(invoiceId);
 * }</pre>
 */
public final class Essabu {

    private final HttpClientWrapper http;

    private volatile HrClient hrClient;
    private volatile AccountingClient accountingClient;
    private volatile IdentityClient identityClient;
    private volatile TradeClient tradeClient;
    private volatile PaymentClient paymentClient;
    private volatile EInvoiceClient einvoiceClient;
    private volatile ProjectClient projectClient;
    private volatile AssetClient assetClient;

    private Essabu(EssabuConfig config) {
        this.http = new HttpClientWrapper(config.getBaseUrl(), config.getApiKey(), config.getTenantId());
    }

    /**
     * Create a new builder for configuring the Essabu SDK.
     */
    public static Builder builder() {
        return new Builder();
    }

    // -- Lazy module accessors --

    /**
     * Access the HR module (employees, contracts, leaves, payroll, shifts, etc.).
     */
    public HrClient hr() {
        if (hrClient == null) {
            synchronized (this) {
                if (hrClient == null) {
                    hrClient = new HrClient(http);
                }
            }
        }
        return hrClient;
    }

    /**
     * Access the Accounting module (accounts, invoices, payments, wallets, inventory, etc.).
     */
    public AccountingClient accounting() {
        if (accountingClient == null) {
            synchronized (this) {
                if (accountingClient == null) {
                    accountingClient = new AccountingClient(http);
                }
            }
        }
        return accountingClient;
    }

    /**
     * Access the Identity module (auth, users, roles, permissions, tenants, etc.).
     */
    public IdentityClient identity() {
        if (identityClient == null) {
            synchronized (this) {
                if (identityClient == null) {
                    identityClient = new IdentityClient(http);
                }
            }
        }
        return identityClient;
    }

    /**
     * Access the Trade module (customers, contacts, opportunities, products, orders, etc.).
     */
    public TradeClient trade() {
        if (tradeClient == null) {
            synchronized (this) {
                if (tradeClient == null) {
                    tradeClient = new TradeClient(http);
                }
            }
        }
        return tradeClient;
    }

    /**
     * Access the Payment module (intents, transactions, subscriptions, loans, payouts, etc.).
     */
    public PaymentClient payment() {
        if (paymentClient == null) {
            synchronized (this) {
                if (paymentClient == null) {
                    paymentClient = new PaymentClient(http);
                }
            }
        }
        return paymentClient;
    }

    /**
     * Access the E-Invoice module (electronic invoicing, submissions, verifications).
     */
    public EInvoiceClient einvoice() {
        if (einvoiceClient == null) {
            synchronized (this) {
                if (einvoiceClient == null) {
                    einvoiceClient = new EInvoiceClient(http);
                }
            }
        }
        return einvoiceClient;
    }

    /**
     * Access the Project module (projects, tasks, milestones, resource allocations).
     */
    public ProjectClient project() {
        if (projectClient == null) {
            synchronized (this) {
                if (projectClient == null) {
                    projectClient = new ProjectClient(http);
                }
            }
        }
        return projectClient;
    }

    /**
     * Access the Asset module (assets, vehicles, maintenance, fleet management).
     */
    public AssetClient asset() {
        if (assetClient == null) {
            synchronized (this) {
                if (assetClient == null) {
                    assetClient = new AssetClient(http);
                }
            }
        }
        return assetClient;
    }

    /**
     * Builder for constructing an {@link Essabu} instance.
     */
    public static final class Builder {
        private String apiKey;
        private String tenantId;
        private String baseUrl = "https://api.essabu.com";

        private Builder() {
        }

        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Essabu build() {
            if (apiKey == null || apiKey.isBlank()) {
                throw new IllegalArgumentException("apiKey is required");
            }
            EssabuConfig config = EssabuConfig.builder()
                    .apiKey(apiKey)
                    .tenantId(tenantId)
                    .baseUrl(baseUrl)
                    .build();
            return new Essabu(config);
        }
    }
}
