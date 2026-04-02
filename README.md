# Essabu Java SDK

[![Maven Central](https://img.shields.io/maven-central/v/com.essabu/essabu-java)](https://central.sonatype.com/artifact/com.essabu/essabu-java)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Java 21+](https://img.shields.io/badge/Java-21%2B-orange)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3%2B-brightgreen)](https://spring.io/projects/spring-boot)

The official Java SDK for the [Essabu](https://essabu.com) platform. It provides a single,
unified client that covers every Essabu service: **HR**, **Accounting**, **Identity**, **Trade**,
**Payment**, **E-Invoice**, **Project**, and **Asset**. The SDK handles authentication,
pagination, error mapping, automatic retries with exponential backoff, and Spring Boot
auto-configuration so you can focus on building your application instead of managing
HTTP plumbing. Whether you are running a standalone Java application or a full Spring Boot
microservice, the SDK fits naturally into your stack. Every module is lazily initialized
on first access, keeping startup fast and memory usage low. The fluent builder API makes
configuration straightforward, and the comprehensive exception hierarchy lets you handle
every error case with precision.

---

## Table of Contents

- [Requirements](#requirements)
- [Installation](#installation)
- [Quick Start](#quick-start)
- [Spring Boot Auto-Configuration](#spring-boot-auto-configuration)
- [Configuration Reference](#configuration-reference)
- [Modules](#modules)
  - [HR](#hr)
  - [Accounting](#accounting)
  - [Identity](#identity)
  - [Trade](#trade)
  - [Payment](#payment)
  - [E-Invoice](#e-invoice)
  - [Project](#project)
  - [Asset](#asset)
- [Pagination](#pagination)
- [Error Handling](#error-handling)
- [Retry Behavior](#retry-behavior)
- [Webhook Handling](#webhook-handling)
- [Examples](#examples)
- [Contributing](#contributing)
- [License](#license)

---

## Requirements

- Java 21+
- Maven 3.8+ or Gradle 8+
- An Essabu API key ([Dashboard](https://app.essabu.com) > Settings > API Keys)

## Installation

### Maven

Add the Essabu Java SDK dependency to your Maven `pom.xml`. This single artifact includes all modules and their transitive dependencies are resolved automatically by Maven.

```xml
<dependency>
    <groupId>com.essabu</groupId>
    <artifactId>essabu-java</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

### Gradle (Groovy)

Add the dependency to your `build.gradle` file. The SDK requires Java 21 or later, so ensure your `sourceCompatibility` is set accordingly.

```groovy
implementation 'com.essabu:essabu-java:1.0.0-SNAPSHOT'
```

### Gradle (Kotlin DSL)

Add the dependency to your `build.gradle.kts` file. This is equivalent to the Groovy syntax above but uses the Kotlin DSL format.

```kotlin
implementation("com.essabu:essabu-java:1.0.0-SNAPSHOT")
```

## Quick Start

This example demonstrates initializing the SDK client and performing basic operations across all modules. You need your API key and tenant UUID, both available from the Essabu dashboard. Each module is accessed through a dedicated method on the client, and all methods return structured `Map` responses or `PageResponse` wrappers for paginated results.

```java
import com.essabu.Essabu;
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

Essabu essabu = Essabu.builder()
    .apiKey("ess_live_xxxxxxxxxxxx")
    .tenantId("your-tenant-uuid")
    .build();

// ----- HR -----
var employees = essabu.hr().employees().list(
    companyId, PageRequest.builder().page(0).size(20).build()
);

// ----- Accounting -----
var invoice = essabu.accounting().invoices().create(Map.of(
    "customerId", customerId,
    "items", List.of(Map.of("description", "Consulting", "amount", 1500))
));
essabu.accounting().invoices().finalize(invoiceId);

// ----- Identity -----
var tokens = essabu.identity().auth().login(Map.of(
    "email", "user@example.com", "password", "secret"
));

// ----- Trade -----
var customer = essabu.trade().customers().create(Map.of(
    "name", "Acme Corp", "email", "contact@acme.com"
));

// ----- Payment -----
var intent = essabu.payment().intents().create(Map.of(
    "amount", 5000, "currency", "USD", "customerId", customerId
));
essabu.payment().intents().confirm(intentId);

// ----- E-Invoice -----
var einv = essabu.einvoice().invoices().submit(Map.of(
    "invoiceId", invoiceId, "buyerTin", "123456789"
));

// ----- Project -----
var project = essabu.project().projects().create(Map.of(
    "name", "Website Redesign", "startDate", "2026-04-01"
));

// ----- Asset -----
var vehicle = essabu.asset().vehicles().create(Map.of(
    "make", "Toyota", "model", "Hilux", "year", 2025
));
```

## Spring Boot Auto-Configuration

Add the SDK dependency and set properties in `application.yml`:

The SDK provides Spring Boot auto-configuration that creates and registers an `Essabu` bean automatically. Set your API key and tenant ID in `application.yml` or `application.properties`. All timeout, retry, and URL settings have sensible defaults and are optional. The bean is a singleton and thread-safe.

```yaml
essabu:
  api-key: ess_live_xxxxxxxxxxxx
  tenant-id: your-tenant-uuid
  base-url: https://api.essabu.com    # optional, default
  connect-timeout: 10s                 # optional, default 10s
  read-timeout: 30s                    # optional, default 30s
  max-retries: 3                       # optional, default 3
  retry-delay: 500ms                   # optional, default 500ms
```

Then inject the bean:

Inject the auto-configured `Essabu` bean into any Spring-managed component via constructor injection. The bean is ready to use immediately -- no manual initialization required. All module clients are lazily created on first access through their respective accessor methods.

```java
@Service
public class MyService {

    private final Essabu essabu;

    public MyService(Essabu essabu) {
        this.essabu = essabu;
    }

    public void doWork() {
        var customers = essabu.trade().customers().list(
            PageRequest.builder().page(0).size(10).build()
        );
    }
}
```

## Configuration Reference

| Property | Type | Default | Description |
|----------|------|---------|-------------|
| `essabu.api-key` | `String` | *required* | Your Essabu API key |
| `essabu.tenant-id` | `String` | *required* | Your tenant UUID |
| `essabu.base-url` | `String` | `https://api.essabu.com` | API base URL |
| `essabu.connect-timeout` | `Duration` | `10s` | HTTP connection timeout |
| `essabu.read-timeout` | `Duration` | `30s` | HTTP read timeout |
| `essabu.max-retries` | `int` | `3` | Max retries for 429/5xx |
| `essabu.retry-delay` | `Duration` | `500ms` | Initial retry delay (doubles each retry) |

For standalone (non-Spring) usage, configure via the builder:

Configure the Essabu client using the fluent builder for standalone Java applications (outside Spring Boot). All parameters except `apiKey` and `tenantId` are optional and default to the values shown in the configuration reference table above. The `retryDelay` doubles with each retry attempt (exponential backoff). Throws `IllegalArgumentException` if the API key or tenant ID is null or blank.

```java
Essabu essabu = Essabu.builder()
    .apiKey("ess_live_xxxxxxxxxxxx")
    .tenantId("your-tenant-uuid")
    .baseUrl("https://api.essabu.com")
    .connectTimeout(Duration.ofSeconds(10))
    .readTimeout(Duration.ofSeconds(30))
    .maxRetries(3)
    .retryDelay(Duration.ofMillis(500))
    .build();
```

## Modules

### HR

`essabu.hr()` -- Comprehensive human resource management.

| Sub-API | Accessor | Highlights |
|---------|----------|------------|
| Employees | `hr.employees()` | CRUD, leave balances |
| Contracts | `hr.contracts()` | Employment contracts |
| Leaves | `hr.leaves()` | Requests, approve/reject workflow |
| Payroll | `hr.payroll()` | Runs, payslips, PDF download |
| Shifts | `hr.shifts()` | Shifts, schedules, swap requests |
| Recruitment | `hr.recruitment()` | Job postings, applications, interviews |
| Performance | `hr.performance()` | Reviews, cycles, goals |
| Benefits | `hr.benefits()` | Plans, employee enrollment |
| Config | `hr.config()` | Leave policies, holidays, workflows |

Plus: Departments, Positions, Attendance, Documents, Training, Skills, Onboarding, Timesheets, Disciplinary, Loans, Expense Reports.

[Full reference on the Wiki](https://github.com/essabu/essabu-java/wiki/HR-Module)

### Accounting

`essabu.accounting()` -- Complete financial management.

| Sub-API | Accessor | Highlights |
|---------|----------|------------|
| Accounts | `accounting.accounts()` | Chart of accounts, balances |
| Invoices | `accounting.invoices()` | Create, finalize, send, PDF, payment link |
| Payments | `accounting.payments()` | Recording, terms, schedules |
| Journals | `accounting.journals()` | Journals and journal entries |
| Quotes | `accounting.quotes()` | Quotes, convert to invoice, PDF |
| Reports | `accounting.reports()` | Trial balance, balance sheet, P&L, cash flow, aged receivables/payables |
| Inventory | `accounting.inventory()` | Items, suppliers, POs, stock locations, movements |

Plus: Wallets, Credit Notes, Tax Rates, Fiscal Years, Currencies, Coupons, Insurance, Billing, Recurring Invoices.

[Full reference on the Wiki](https://github.com/essabu/essabu-java/wiki/Accounting-Module)

### Identity

`essabu.identity()` -- Authentication and access control.

| Sub-API | Accessor | Highlights |
|---------|----------|------------|
| Auth | `identity.auth()` | Login, register, 2FA, password reset |
| Users | `identity.users()` | User CRUD |
| Roles | `identity.roles()` | Role management |
| Permissions | `identity.permissions()` | Permission management |
| API Keys | `identity.apiKeys()` | Create, revoke API keys |

Plus: Tenants, Companies, Branches, Profiles, Sessions.

[Full reference on the Wiki](https://github.com/essabu/essabu-java/wiki/Identity-Module)

### Trade

`essabu.trade()` -- CRM, sales, purchasing, and inventory.

| Sub-API | Accessor | Highlights |
|---------|----------|------------|
| Customers | `trade.customers()` | Customers and groups |
| Contacts | `trade.contacts()` | CRM contacts |
| Opportunities | `trade.opportunities()` | Sales pipeline |
| Products | `trade.products()` | Products, categories, price lists |
| Stock | `trade.stock()` | Levels, movements, lots, serials, reorder rules |
| Contracts | `trade.contracts()` | Clauses, amendments, documents |

Plus: Sales Orders, Purchase Orders, Suppliers, Campaigns, Activities, Warehouses, Delivery Notes, Goods Receipts, Reports.

[Full reference on the Wiki](https://github.com/essabu/essabu-java/wiki/Trade-Module)

### Payment

`essabu.payment()` -- Payment processing and lending.

| Sub-API | Accessor | Highlights |
|---------|----------|------------|
| Intents | `payment.intents()` | Create, confirm, cancel |
| Transactions | `payment.transactions()` | Read-only history |
| Refunds | `payment.refunds()` | Process refunds |
| Subscriptions | `payment.subscriptions()` | Billing cycles, usage reporting |
| Loans | `payment.loans()` | Products, applications, collaterals, accounts |
| KYC | `payment.kyc()` | Profiles, document upload |

Plus: Payouts, Settlements, Payment Accounts, SDK Keys, Reports.

[Full reference on the Wiki](https://github.com/essabu/essabu-java/wiki/Payment-Module)

### E-Invoice

`essabu.einvoice()` -- Electronic invoicing and tax compliance.

| Sub-API | Accessor | Highlights |
|---------|----------|------------|
| Invoices | `einvoice.invoices()` | Submit, cancel, status, PDF/XML download |
| Verification | `einvoice.verification()` | Public verify by code or QR |

[Full reference on the Wiki](https://github.com/essabu/essabu-java/wiki/EInvoice-Module)

### Project

`essabu.project()` -- Project and task management.

| Sub-API | Accessor | Highlights |
|---------|----------|------------|
| Projects | `project.projects()` | CRUD |
| Tasks | `project.tasks()` | Tasks and comments |
| Milestones | `project.milestones()` | CRUD |
| Resources | `project.resourceAllocations()` | Allocation management |
| Reports | `project.reports()` | Summary, resource utilization |

[Full reference on the Wiki](https://github.com/essabu/essabu-java/wiki/Project-Module)

### Asset

`essabu.asset()` -- Asset and fleet management.

| Sub-API | Accessor | Highlights |
|---------|----------|------------|
| Assets | `asset.assets()` | Fixed assets with depreciation |
| Vehicles | `asset.vehicles()` | Vehicle registry |
| Maintenance | `asset.maintenance()` | Logs and recurring schedules |
| Fleet | `asset.fleet()` | Fuel logs, trip logs |

[Full reference on the Wiki](https://github.com/essabu/essabu-java/wiki/Asset-Module)

## Pagination

Use `PageRequest` and `PageResponse` for all list endpoints:

Build a `PageRequest` with a zero-based page index, page size (maximum 100), and an optional sort directive in "field,direction" format. The returned `PageResponse` wraps the result list along with metadata including total elements, total pages, and a `hasNext()` helper for iteration. Throws `BadRequestException` if the page size exceeds the maximum or the sort field is invalid.

```java
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

PageRequest page = PageRequest.builder()
    .page(0)                    // 0-based page index
    .size(25)                   // items per page (max 100)
    .sort("createdAt,desc")     // sort field and direction
    .build();

PageResponse<Map> result = essabu.hr().employees().list(companyId, page);

List<Map> items = result.getContent();
int total = result.getTotalElements();
boolean hasMore = result.hasNext();
```

Iterate all pages:

Loop through all pages of a paginated result set by incrementing the page index until `hasNext()` returns false. This pattern is useful for batch processing or data synchronization. Be mindful of rate limits when iterating large datasets -- consider adding a delay between requests if you receive `RateLimitException`.

```java
int page = 0;
PageResponse<Map> result;
do {
    result = essabu.hr().employees().list(companyId,
        PageRequest.builder().page(page++).size(50).build());
    result.getContent().forEach(this::process);
} while (result.hasNext());
```

## Error Handling

The SDK maps HTTP errors to a specific exception hierarchy:

The SDK translates every non-2xx HTTP response into a typed exception. Catch specific exceptions for fine-grained handling, or catch the base `EssabuApiException` as a fallback. Each exception provides the HTTP status code, response body, and a unique request ID for debugging with Essabu support. The exceptions are ordered from most specific to least specific in the catch chain below.

```java
import com.essabu.common.exception.*;

try {
    essabu.hr().employees().getById(UUID.randomUUID());
} catch (NotFoundException e) {
    // 404 - Resource not found
} catch (ValidationException e) {
    // 422 - Business rule violation
    System.out.println(e.getErrors()); // field-level errors
} catch (UnauthorizedException e) {
    // 401 - Invalid or expired API key
} catch (ForbiddenException e) {
    // 403 - Insufficient permissions
} catch (ConflictException e) {
    // 409 - Duplicate resource or state conflict
} catch (RateLimitException e) {
    // 429 - Rate limit exceeded (after retry exhaustion)
} catch (BadRequestException e) {
    // 400 - Malformed request
} catch (ServerException e) {
    // 5xx - Server error (after retry exhaustion)
} catch (EssabuApiException e) {
    // Catch-all for any other API error
    System.out.println("Status: " + e.getStatusCode());
    System.out.println("Body: " + e.getResponseBody());
    System.out.println("Request ID: " + e.getRequestId());
}
```

| Exception | HTTP Status | When |
|-----------|-------------|------|
| `BadRequestException` | 400 | Malformed request, missing fields |
| `UnauthorizedException` | 401 | Invalid or expired API key/token |
| `ForbiddenException` | 403 | Insufficient permissions |
| `NotFoundException` | 404 | Resource not found |
| `ConflictException` | 409 | Duplicate or state conflict |
| `ValidationException` | 422 | Business rule violation |
| `RateLimitException` | 429 | Rate limit exceeded |
| `ServerException` | 5xx | Server-side error |

## Retry Behavior

The SDK automatically retries **429** (rate limit) and **5xx** (server error) responses with exponential backoff:

- **Max retries**: 3 (configurable)
- **Initial delay**: 500ms, doubling each attempt (500ms, 1s, 2s)
- **4xx errors** (except 429) are **never retried** -- they are thrown immediately

## Webhook Handling

Process incoming Essabu webhook events:

Handle webhook events sent by Essabu to your application endpoint. First, verify the signature using the `X-Essabu-Signature` header and your webhook secret to ensure the payload has not been tampered with. Then parse the event to extract the `type` (e.g., "invoice.paid", "employee.created") and `data` payload. Always return HTTP 200 to acknowledge receipt; Essabu will retry unacknowledged webhooks up to 5 times with exponential backoff.

```java
@PostMapping("/webhooks/essabu")
public ResponseEntity<Void> handleWebhook(
        @RequestBody String payload,
        @RequestHeader("X-Essabu-Signature") String signature) {

    // 1. Verify signature
    if (!EssabuWebhook.verify(payload, signature, "your-webhook-secret")) {
        return ResponseEntity.status(401).build();
    }

    // 2. Parse and dispatch
    Map<String, Object> event = EssabuWebhook.parse(payload);
    String type = (String) event.get("type");
    Map<String, Object> data = (Map<String, Object>) event.get("data");

    switch (type) {
        case "invoice.paid" -> handleInvoicePaid(data);
        case "employee.created" -> handleEmployeeCreated(data);
        case "payment_intent.confirmed" -> handlePaymentConfirmed(data);
    }

    return ResponseEntity.ok().build();
}
```

## Examples

| Example | File | Description |
|---------|------|-------------|
| Basic Usage | [`BasicUsageExample.java`](examples/BasicUsageExample.java) | Client init, CRUD across modules |
| Spring Boot | [`SpringBootExample.java`](examples/SpringBootExample.java) | Auto-config, injection, service layer |

See the full [examples/](examples/) directory and the [Wiki Examples page](https://github.com/essabu/essabu-java/wiki/Examples) for more.

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feat/my-feature`)
3. Commit your changes (`git commit -m 'feat: add my feature'`)
4. Push to the branch (`git push origin feat/my-feature`)
5. Open a Pull Request

Please follow [Conventional Commits](https://www.conventionalcommits.org/) for commit messages.

## License

MIT -- see [LICENSE](LICENSE) for details.
