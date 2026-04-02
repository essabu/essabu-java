# Authentication

## API Key Authentication

All requests are authenticated using a Bearer token (API key) sent in the `Authorization` header.

```
Authorization: Bearer your-api-key
X-Tenant-Id: your-tenant-id
Accept: application/json
```

The SDK automatically adds these headers to every request.

## Obtaining an API Key

1. Log in to the Essabu Identity dashboard
2. Navigate to API Keys management
3. Create a new API key with the required scopes
4. Copy the key and store it securely

## Multi-Tenant Isolation

Every request includes the `X-Tenant-Id` header. This ensures data isolation between tenants. The tenant ID is set once during client initialization.

## Token Refresh

The SDK uses long-lived API keys. If using short-lived tokens, handle token refresh in your application and create a new client instance with the updated key.

## Security Best Practices

- Store API keys in environment variables or a secrets manager
- Never commit API keys to version control
- Use the minimum required scopes for each API key
- Rotate API keys periodically
- Monitor API key usage via the Identity dashboard
