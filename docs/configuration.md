# Configuration

## Builder Configuration

```java
Essabu essabu = Essabu.builder()
    .baseUrl("https://api.essabu.com")   // optional, default
    .apiKey("your-api-key")               // required
    .tenantId("your-tenant-id")           // required
    .connectTimeout(Duration.ofSeconds(5)) // optional, default 5s
    .readTimeout(Duration.ofSeconds(30))   // optional, default 30s
    .retryOnServerError(3)                 // optional, default 3
    .build();
```

## Spring Boot Configuration

```yaml
essabu:
  api-key: your-api-key
  tenant-id: your-tenant-id
  base-url: https://api.essabu.com        # optional
  connect-timeout: 5s                      # optional
  read-timeout: 30s                        # optional
  retry-on-server-error: 3                 # optional
```

## Configuration Properties

| Property | Type | Default | Description |
|----------|------|---------|-------------|
| `essabu.api-key` | String | - | API authentication key (required) |
| `essabu.tenant-id` | String | - | Tenant identifier (required) |
| `essabu.base-url` | String | `https://api.essabu.com` | API base URL |
| `essabu.connect-timeout` | Duration | `5s` | Connection timeout |
| `essabu.read-timeout` | Duration | `30s` | Read timeout |
| `essabu.retry-on-server-error` | int | `3` | Max retries on 5xx errors |

## Environment Variables

Spring Boot automatically maps environment variables:

```bash
export ESSABU_API_KEY=your-api-key
export ESSABU_TENANT_ID=your-tenant-id
export ESSABU_BASE_URL=https://api.essabu.com
```
