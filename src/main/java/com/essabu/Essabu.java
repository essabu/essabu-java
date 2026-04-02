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

import java.time.Duration;

/**
 * Main entry point for the Essabu SDK.
 * Provides access to all Essabu services through a single unified client.
 *
 * <p>Usage:</p>
 * <pre>{@code
 *   Essabu essabu = Essabu.builder()
 *       .apiKey("your-api-key")
 *       .tenantId("your-tenant")
 *       .build();
 *
 *   // HR
 *   essabu.hr().employees().create(...);
 *   essabu.hr().payrolls().calculate(...);
 *
 *   // Accounting
 *   essabu.accounting().invoices().create(...);
 *   essabu.accounting().wallets().credit(...);
 *
 *   // Identity
 *   essabu.identity().auth().login(...);
 *
 *   // Trade
 *   essabu.trade().customers().create(...);
 *
 *   // Payment
 *   essabu.payment().loanApplications().create(...);
 *
 *   // E-Invoice
 *   essabu.einvoice().invoices().normalize(...);
 *
 *   // Project
 *   essabu.project().tasks().create(...);
 *
 *   // Asset
 *   essabu.asset().vehicles().create(...);
 * }</pre>
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class Essabu {

    private final HttpClientWrapper http;

    // Lazily initialized module clients
    private volatile HrClient hrClient;
    private volatile AccountingClient accountingClient;
    private volatile IdentityClient identityClient;
    private volatile TradeClient tradeClient;
    private volatile PaymentClient paymentClient;
    private volatile EInvoiceClient einvoiceClient;
    private volatile ProjectClient projectClient;
    private volatile AssetClient assetClient;

    /**
     * Creates an Essabu client from an existing configuration.
     * Can be used directly by auto-configuration or test setups.
     */
    public Essabu(EssabuConfig config) {
        this.http = new HttpClientWrapper(config);
    }

    /**
     * Creates a new builder for configuring the client.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Creates a client from an existing configuration (alias for constructor).
     */
    public static Essabu fromConfig(EssabuConfig config) {
        return new Essabu(config);
    }

    // --- Module accessors ---

    /**
     * Access the HR module (employees, payroll, attendance, leaves, etc.).
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
     * Access the Accounting module (invoices, journals, wallets, inventory, etc.).
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
     * Access the Trade module (customers, products, sales orders, deliveries, etc.).
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
     * Access the Payment module (payment intents, subscriptions, lending, etc.).
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
     * Access the E-Invoice module (invoices, submissions, verification, compliance, etc.).
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
     * Access the Project module (projects, tasks, milestones, resource allocation, etc.).
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
     * Access the Asset module (assets, depreciation, vehicles, maintenance, etc.).
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

    // --- Builder ---

    public static final class Builder {

        private String baseUrl = "https://api.essabu.com";
        private String apiKey;
        private String tenantId;
        private Duration connectTimeout = Duration.ofSeconds(5);
        private Duration readTimeout = Duration.ofSeconds(30);
        private int retryOnServerError = 3;

        private Builder() {
        }

        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public Builder connectTimeout(Duration connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        public Builder readTimeout(Duration readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        public Builder retryOnServerError(int retryOnServerError) {
            this.retryOnServerError = retryOnServerError;
            return this;
        }

        public Essabu build() {
            if (apiKey == null || apiKey.isBlank()) {
                throw new IllegalArgumentException("apiKey est obligatoire");
            }
            if (tenantId == null || tenantId.isBlank()) {
                throw new IllegalArgumentException("tenantId est obligatoire");
            }

            EssabuConfig config = EssabuConfig.builder()
                    .baseUrl(baseUrl)
                    .apiKey(apiKey)
                    .tenantId(tenantId)
                    .connectTimeout(connectTimeout)
                    .readTimeout(readTimeout)
                    .retryOnServerError(retryOnServerError)
                    .build();

            return new Essabu(config);
        }
    }
}
