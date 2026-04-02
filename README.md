# Essabu Java SDK

Unified Java SDK for the [Essabu](https://essabu.com) platform. Provides a single client to interact with all Essabu services: HR, Accounting, Identity, Trade, Payment, E-Invoice, Project, and Asset.

## Requirements

- Java 21+
- Maven 3.8+

## Installation

Add the dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.essabu</groupId>
    <artifactId>essabu-java</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

## Quick Start

### Standalone Usage

```java
import com.essabu.Essabu;
import com.essabu.common.model.PageRequest;

Essabu essabu = Essabu.builder()
    .apiKey("your-api-key")
    .tenantId("your-tenant-id")
    .baseUrl("https://api.essabu.com") // optional, this is the default
    .build();

// List employees
var employees = essabu.hr().employees().list(
    UUID.fromString("company-uuid"),
    PageRequest.builder().page(0).size(20).build()
);

// Create an invoice
var invoice = essabu.accounting().invoices().create(Map.of(
    "customerId", "customer-uuid",
    "items", List.of(Map.of("description", "Consulting", "amount", 1500))
));

// Authenticate a user
var loginResponse = essabu.identity().auth().login(Map.of(
    "email", "user@example.com",
    "password", "secret"
));
```

### Spring Boot Integration

Add the SDK dependency and configure properties:

```yaml
# application.yml
essabu:
  api-key: your-api-key
  tenant-id: your-tenant-id
  base-url: https://api.essabu.com
```

Then inject the `Essabu` bean:

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

## Modules

| Module | Accessor | Description |
|--------|----------|-------------|
| HR | `essabu.hr()` | Employees, contracts, leaves, payroll, shifts, recruitment, performance, training |
| Accounting | `essabu.accounting()` | Accounts, invoices, payments, wallets, journals, quotes, credit notes, inventory |
| Identity | `essabu.identity()` | Auth, users, roles, permissions, tenants, companies, branches |
| Trade | `essabu.trade()` | Customers, contacts, opportunities, products, orders, suppliers, contracts, stock |
| Payment | `essabu.payment()` | Payment intents, transactions, refunds, payouts, subscriptions, loans, KYC |
| E-Invoice | `essabu.einvoice()` | Electronic invoicing, submission, verification |
| Project | `essabu.project()` | Projects, tasks, milestones, resource allocations, reports |
| Asset | `essabu.asset()` | Assets, vehicles, maintenance, fleet (fuel/trip logs) |

## Error Handling

The SDK throws specific exceptions for different HTTP error codes:

```java
import com.essabu.common.exception.*;

try {
    essabu.hr().employees().getById(UUID.randomUUID());
} catch (NotFoundException e) {
    // HTTP 404
} catch (ValidationException e) {
    // HTTP 422
} catch (UnauthorizedException e) {
    // HTTP 401
} catch (ForbiddenException e) {
    // HTTP 403
} catch (RateLimitException e) {
    // HTTP 429 (after retry exhaustion)
} catch (ServerException e) {
    // HTTP 5xx (after retry exhaustion)
} catch (EssabuApiException e) {
    // Any other API error
    System.out.println("Status: " + e.getStatusCode());
    System.out.println("Body: " + e.getResponseBody());
}
```

## Retry Behavior

The SDK automatically retries on 5xx errors and 429 (rate limit) with exponential backoff:
- Max 3 retries
- Initial delay: 500ms, doubling each retry

## License

MIT - see [LICENSE](LICENSE) for details.
