# Getting Started

## Prerequisites

- Java 21 or later
- Maven 3.8 or later
- An Essabu API key (obtain from the Essabu dashboard)

## Installation

Add to your Maven `pom.xml`:

```xml
<dependency>
    <groupId>com.essabu</groupId>
    <artifactId>essabu-java</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

## Creating a Client

```java
import com.essabu.Essabu;

Essabu essabu = Essabu.builder()
    .apiKey("ess_live_xxxxxxxxxxxx")
    .tenantId("your-tenant-uuid")
    .build();
```

The `baseUrl` defaults to `https://api.essabu.com`. Override it for staging or local development:

```java
Essabu essabu = Essabu.builder()
    .apiKey("ess_test_xxxxxxxxxxxx")
    .tenantId("your-tenant-uuid")
    .baseUrl("http://localhost:8080")
    .build();
```

## Module Access

Each module is lazily initialized on first access:

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
