# Essabu Java SDK

[![Java](https://img.shields.io/badge/Java-21%2B-orange)](https://openjdk.org/)
[![Maven Central](https://img.shields.io/maven-central/v/com.essabu/essabu-java)](https://central.sonatype.com/artifact/com.essabu/essabu-java)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![CI](https://github.com/essabu/essabu-java/actions/workflows/ci.yml/badge.svg)](https://github.com/essabu/essabu-java/actions)

The official Java SDK for the [Essabu](https://essabu.com) platform. One package, all 8 modules -- HR, Accounting, Identity, Trade, Payment, E-Invoice, Project, and Asset management.

## Installation

### Maven

```xml
<dependency>
    <groupId>com.essabu</groupId>
    <artifactId>essabu-java</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

### Gradle (Groovy)

```groovy
implementation 'com.essabu:essabu-java:1.0.0-SNAPSHOT'
```

### Gradle (Kotlin DSL)

```kotlin
implementation("com.essabu:essabu-java:1.0.0-SNAPSHOT")
```

## Quick Start

```java
import com.essabu.Essabu;

Essabu essabu = Essabu.builder()
    .apiKey("sk_live_xxx")
    .tenantId("tenant-123")
    .build();
```

### HR -- Employees, payroll, attendance, leaves, recruitment

```java
var employee = essabu.hr().employees().create(
    CreateEmployeeRequest.builder()
        .firstName("Jean")
        .lastName("Dupont")
        .email("jean.dupont@example.com")
        .build()
);

var employees = essabu.hr().employees().list(PageRequest.first());
essabu.hr().payrolls().calculate(request);
essabu.hr().leaves().approve(leaveId);
```

### Accounting -- Invoices, journals, wallets, inventory, insurance

```java
var invoice = essabu.accounting().invoices().create(request);
essabu.accounting().invoices().finalize(invoice.getId());
essabu.accounting().invoices().send(invoice.getId());
essabu.accounting().invoices().markAsPaid(invoice.getId());

byte[] pdf = essabu.accounting().invoices().downloadPdf(invoice.getId());
```

### Identity -- Auth, users, roles, permissions, tenants

```java
var token = essabu.identity().auth().login(
    LoginRequest.builder()
        .email("user@example.com")
        .password("password")
        .build()
);

essabu.identity().auth().refresh(token.getRefreshToken());
essabu.identity().users().create(request);
```

### Trade -- Customers, products, sales orders, deliveries

```java
var customer = essabu.trade().customers().create(request);
var order = essabu.trade().salesOrders().create(orderRequest);
essabu.trade().salesOrders().confirm(order.getId());
```

### Payment -- Payment intents, subscriptions, lending, KYC

```java
var intent = essabu.payment().paymentIntents().create(
    CreatePaymentIntentRequest.builder()
        .companyId(companyId)
        .amount(15000L)
        .currency("USD")
        .build()
);

essabu.payment().paymentIntents().confirm(intent.getId());
essabu.payment().loanApplications().create(loanRequest);
```

### E-Invoice -- Electronic invoicing, government submission, compliance

```java
var submission = essabu.einvoice().submissions().submit(submitRequest);
essabu.einvoice().submissions().checkStatus(submission.getId());
```

### Project -- Projects, tasks, milestones, resource allocation

```java
var project = essabu.project().projects().create(request);
var task = essabu.project().tasks().create(taskRequest);
```

### Asset -- Assets, depreciation, vehicles, maintenance

```java
var vehicle = essabu.asset().vehicles().create(request);
essabu.asset().depreciations().calculate(assetId);
essabu.asset().fuelLogs().create(fuelLogRequest);
```

## Configuration

```java
Essabu essabu = Essabu.builder()
    .baseUrl("https://api.essabu.com")     // optional, default
    .apiKey("sk_live_xxx")                  // required
    .tenantId("tenant-123")                // required
    .connectTimeout(Duration.ofSeconds(5))  // optional, default 5s
    .readTimeout(Duration.ofSeconds(30))    // optional, default 30s
    .retryOnServerError(3)                  // optional, default 3
    .build();
```

## Spring Boot Auto-Configuration

The SDK includes Spring Boot auto-configuration. Add the dependency and configure via `application.yml`:

```yaml
essabu:
  api-key: ${ESSABU_API_KEY}
  tenant-id: ${ESSABU_TENANT_ID}
  base-url: https://api.essabu.com  # optional, default
```

Then inject `Essabu` anywhere:

```java
@Service
public class InvoiceService {
    private final Essabu essabu;

    public InvoiceService(Essabu essabu) {
        this.essabu = essabu;
    }

    public InvoiceResponse createInvoice(CreateInvoiceRequest request) {
        return essabu.accounting().invoices().create(request);
    }
}
```

## Error Handling

The SDK provides a typed exception hierarchy for precise error handling:

```java
try {
    essabu.hr().employees().create(request);
} catch (EssabuValidationException e) {
    // 400/422 - Validation errors with field-level details
    System.err.println("Status: " + e.getStatusCode());
    e.getFieldErrors().forEach((field, msg) ->
        System.err.println(field + ": " + msg));
} catch (EssabuUnauthorizedException e) {
    // 401 - Invalid or expired API key
} catch (EssabuForbiddenException e) {
    // 403 - Insufficient permissions
} catch (EssabuNotFoundException e) {
    // 404 - Resource not found
} catch (EssabuRateLimitException e) {
    // 429 - Rate limit exceeded
    System.err.println("Retry after: " + e.getRetryAfter());
} catch (EssabuServerException e) {
    // 5xx - Server error (automatically retried up to retryOnServerError times)
} catch (EssabuApiException e) {
    // Catch-all for any API error
    System.err.println("HTTP " + e.getStatusCode() + ": " + e.getMessage());
}
```

| Exception | HTTP Status | Description |
|-----------|-------------|-------------|
| `EssabuValidationException` | 400, 422 | Validation errors with `getFieldErrors()` |
| `EssabuUnauthorizedException` | 401 | Invalid or expired API key |
| `EssabuForbiddenException` | 403 | Insufficient permissions |
| `EssabuNotFoundException` | 404 | Resource not found |
| `EssabuRateLimitException` | 429 | Rate limit exceeded with `getRetryAfter()` |
| `EssabuServerException` | 5xx | Server error (auto-retried) |

## Webhook Handling

Implement the `WebhookListener` interface and register it as a Spring bean:

```java
@Bean
public WebhookListener accountingWebhookListener() {
    return event -> {
        switch (event.getType()) {
            case "invoice.created" -> handleInvoiceCreated(event);
            case "invoice.paid"    -> handleInvoicePaid(event);
            case "payment.failed"  -> handlePaymentFailed(event);
            default -> log.info("Unhandled: {}", event.getType());
        }
    };
}
```

Configure the webhook endpoint and secret:

```yaml
essabu:
  accounting:
    webhook:
      path: /api/accounting-events    # optional, default
      secret: ${ESSABU_WEBHOOK_SECRET}
```

The SDK automatically verifies webhook signatures using HMAC-SHA256 before dispatching events to your listener.

## Pagination

All list endpoints support pagination:

```java
// Default (page 0, size 20)
PageResponse<EmployeeResponse> page1 = essabu.hr().employees().list(PageRequest.first());

// Custom pagination with sorting
PageRequest request = PageRequest.builder()
    .page(0)
    .size(50)
    .sort("createdAt")
    .direction("desc")
    .build();

PageResponse<EmployeeResponse> page = essabu.hr().employees().list(request);
System.out.println("Total: " + page.getTotalElements());
page.getContent().forEach(emp -> System.out.println(emp.getFirstName()));
```

## Modules

| Module | Accessor | Sub-resources |
|--------|----------|---------------|
| **HR** | `essabu.hr()` | employees, departments, positions, contracts, attendance, leaves, shifts, payroll, expenses, recruitment, performance, onboarding, documents, benefits, loans, timesheets, skills |
| **Accounting** | `essabu.accounting()` | accounts, balances, journals, invoices, quotes, credit notes, payments, tax rates, currencies, exchange rates, fiscal years, wallets, insurance, price lists, suppliers, inventory, purchase orders, stock |
| **Identity** | `essabu.identity()` | auth, users, profiles, companies, tenants, roles, permissions, branches, API keys, sessions |
| **Trade** | `essabu.trade()` | customers, products, sales orders, deliveries, receipts |
| **Payment** | `essabu.payment()` | payment intents, transactions, accounts, payouts, refunds, settlements, subscriptions, billing cycles, loan applications, KYC |
| **E-Invoice** | `essabu.einvoice()` | invoices, submissions, verification, compliance, statistics |
| **Project** | `essabu.project()` | projects, milestones, tasks, task comments, resource allocations, reports |
| **Asset** | `essabu.asset()` | assets, depreciation, maintenance schedules/logs, vehicles, fuel logs, trip logs |

See [docs/modules.md](docs/modules.md) for a comprehensive API reference.

## Examples

Complete working examples are available in the [`examples/`](examples/) directory:

| Example | Description |
|---------|-------------|
| [CreateEmployee.java](examples/CreateEmployee.java) | Create and manage employees |
| [CreateInvoice.java](examples/CreateInvoice.java) | Create, finalize, and send invoices |
| [ProcessPayment.java](examples/ProcessPayment.java) | Process payment intents |
| [WebhookHandler.java](examples/WebhookHandler.java) | Spring Boot webhook handler |
| [Authentication.java](examples/Authentication.java) | Login, token refresh, registration, 2FA |
| [LoanApplication.java](examples/LoanApplication.java) | Complete loan lifecycle |
| [EInvoiceSubmit.java](examples/EInvoiceSubmit.java) | E-invoice government submission |
| [CrmPipeline.java](examples/CrmPipeline.java) | CRM pipeline with customers and orders |

## Requirements

- Java 21+
- Jackson 2.18+
- Spring Boot 3.4+ (optional, for auto-configuration and webhooks)

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feat/amazing-feature`)
3. Write tests for your changes
4. Ensure the project compiles: `mvn compile -DskipTests`
5. Run tests: `mvn test`
6. Commit your changes using [Conventional Commits](https://www.conventionalcommits.org/) (`feat:`, `fix:`, `docs:`, etc.)
7. Push to the branch (`git push origin feat/amazing-feature`)
8. Open a Pull Request

### Development Setup

```bash
# Clone
git clone https://github.com/essabu/essabu-java.git
cd essabu-java

# Build
mvn clean compile

# Run tests
mvn test

# Package
mvn package -DskipTests
```

## License

MIT - see [LICENSE](LICENSE) for details.
