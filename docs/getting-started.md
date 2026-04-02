# Getting Started

## Installation

### Maven

```xml
<dependency>
    <groupId>com.essabu</groupId>
    <artifactId>essabu-java</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

### Gradle

```groovy
implementation 'com.essabu:essabu-java:1.0.0-SNAPSHOT'
```

## Quick Start

```java
import com.essabu.Essabu;

Essabu essabu = Essabu.builder()
    .apiKey("your-api-key")
    .tenantId("your-tenant-id")
    .build();

// Create an employee
var employee = essabu.hr().employees().create(
    CreateEmployeeRequest.builder()
        .firstName("John")
        .lastName("Doe")
        .email("john.doe@company.com")
        .build()
);

// Create an invoice
var invoice = essabu.accounting().invoices().create(
    CreateInvoiceRequest.builder()
        .customerId("cust-123")
        .amount(new BigDecimal("1500.00"))
        .build()
);
```

## Spring Boot

If you are using Spring Boot, the SDK auto-configures itself. Just add properties:

```yaml
essabu:
  api-key: ${ESSABU_API_KEY}
  tenant-id: ${ESSABU_TENANT_ID}
```

Then inject the client:

```java
@Service
public class MyService {
    private final Essabu essabu;

    public MyService(Essabu essabu) {
        this.essabu = essabu;
    }
}
```

## Requirements

- Java 21+
- Jackson 2.18+
- Spring Boot 3.4+ (optional, for auto-configuration)
