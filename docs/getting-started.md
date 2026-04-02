# Getting Started

## Prerequisites

- Java 21 or later
- Maven 3.8 or later
- An Essabu API key (obtain from the Essabu dashboard)

## Installation

Add the Essabu Java SDK dependency to your Maven project. This single dependency includes all modules (HR, Accounting, Identity, Trade, Payment, E-Invoice, Project, and Asset). No additional transitive dependencies are required beyond what Maven resolves automatically.

```xml
<dependency>
    <groupId>com.essabu</groupId>
    <artifactId>essabu-java</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

## Creating a Client

Instantiate the Essabu client using the fluent builder API. You must provide your API key and tenant ID, both of which can be found in the Essabu dashboard under Settings. The builder validates that required fields are present and throws `IllegalArgumentException` if any are missing.

```java
import com.essabu.Essabu;

Essabu essabu = Essabu.builder()
    .apiKey("ess_live_xxxxxxxxxxxx")
    .tenantId("your-tenant-uuid")
    .build();
```

The `baseUrl` defaults to `https://api.essabu.com`. Override it for staging or local development:

Override the base URL when targeting a staging or local environment. This is useful during development and integration testing. All other settings (timeouts, retries) remain at their defaults unless explicitly configured.

```java
Essabu essabu = Essabu.builder()
    .apiKey("ess_test_xxxxxxxxxxxx")
    .tenantId("your-tenant-uuid")
    .baseUrl("http://localhost:8080")
    .build();
```

## Module Access

Each module is lazily initialized on first access:

Access any Essabu module through its dedicated accessor method on the client instance. Modules are lazily initialized on first call, so only the modules you actually use consume memory. Each accessor returns a typed client that provides access to all sub-APIs within that module.

```java
essabu.hr()          // HR module
essabu.accounting()  // Accounting module
essabu.identity()    // Identity module
essabu.trade()       // Trade module
essabu.payment()     // Payment module
essabu.einvoice()    // E-Invoice module
essabu.project()     // Project module
essabu.asset()       // Asset module
```

## Pagination

Use `PageRequest` for paginated endpoints:

All list endpoints accept a `PageRequest` object that controls pagination, page size, and sorting. Pages are zero-indexed, and the maximum page size is 100 items. The returned `PageResponse` contains the items, total element count, total pages, and navigation helpers like `hasNext()`. Throws `BadRequestException` if the page size exceeds the maximum allowed value.

```java
import com.essabu.common.model.PageRequest;
import com.essabu.common.model.PageResponse;

PageRequest page = PageRequest.builder()
    .page(0)
    .size(25)
    .sort("createdAt,desc")
    .build();

PageResponse<Map> result = essabu.hr().employees().list(companyId, page);
System.out.println("Total: " + result.getTotalElements());
result.getContent().forEach(emp -> System.out.println(emp.get("firstName")));
```
