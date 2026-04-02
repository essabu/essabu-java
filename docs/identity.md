# Identity Module Reference

The Identity module handles authentication, user management, roles and permissions, multi-tenancy, companies, branches, profiles, sessions, and API keys.

## Client Access

```java
EssabuClient essabu = new EssabuClient("your-api-key");
IdentityClient identity = essabu.identity();
```

## Available API Classes

| Class | Accessor | Description |
|-------|----------|-------------|
| `AuthApi` | `identity.auth()` | Authentication, registration, 2FA |
| `UserApi` | `identity.users()` | User management |
| `RoleApi` | `identity.roles()` | Role management |
| `PermissionApi` | `identity.permissions()` | Permission management |
| `TenantApi` | `identity.tenants()` | Tenant management |
| `CompanyApi` | `identity.companies()` | Companies and company groups |
| `BranchApi` | `identity.branches()` | Branch management |
| `ProfileApi` | `identity.profiles()` | User profile operations |
| `SessionApi` | `identity.sessions()` | Session management |
| `ApiKeyApi` | `identity.apiKeys()` | API key management |

---

## AuthApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `login(Map request) -> Map` | `POST /api/identity/auth/login` | Authenticate and get tokens |
| `refresh(Map request) -> Map` | `POST /api/identity/auth/refresh` | Refresh access token |
| `register(Map request) -> Map` | `POST /api/identity/auth/register` | Register a new account |
| `verifyEmail(Map request) -> Map` | `POST /api/identity/auth/verify-email` | Verify email address |
| `forgotPassword(Map request) -> Map` | `POST /api/identity/auth/forgot-password` | Request password reset |
| `resetPassword(Map request) -> Map` | `POST /api/identity/auth/reset-password` | Reset password |
| `logout() -> void` | `DELETE /api/identity/auth/logout` | Logout and invalidate token |
| `confirmRegistration(Map request) -> Map` | `POST /api/identity/auth/confirm-registration` | Confirm registration |
| `resendConfirmation(Map request) -> Map` | `POST /api/identity/auth/resend-confirmation` | Resend confirmation |
| `enable2FA(Map request) -> Map` | `POST /api/identity/auth/2fa/enable` | Enable two-factor auth |
| `verify2FA(Map request) -> Map` | `POST /api/identity/auth/2fa/verify` | Verify 2FA code |
| `generateRecoveryCodes() -> Map` | `POST /api/identity/auth/2fa/recovery-codes` | Generate recovery codes |
| `get2FAStatus() -> Map` | `GET /api/identity/auth/2fa/status` | Get 2FA status |

```java
// Login
Map tokens = identity.auth().login(Map.of("email", "user@example.com", "password", "secret"));

// Enable 2FA
Map qrCode = identity.auth().enable2FA(Map.of());
identity.auth().verify2FA(Map.of("code", "123456"));
```

## UserApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/identity/users` | List users |
| `getById(UUID) -> Map` | `GET /api/identity/users/{id}` | Get user |
| `create(Map) -> Map` | `POST /api/identity/users` | Create user |
| `update(UUID, Map) -> Map` | `PUT /api/identity/users/{id}` | Update user |
| `delete(UUID) -> void` | `DELETE /api/identity/users/{id}` | Delete user |

```java
Map user = identity.users().create(Map.of(
    "email", "new@example.com", "firstName", "Jane", "lastName", "Doe", "roleId", roleId
));
```

## RoleApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/identity/roles` | List roles |
| `getById(UUID) -> Map` | `GET /api/identity/roles/{id}` | Get role |
| `create(Map) -> Map` | `POST /api/identity/roles` | Create role |
| `update(UUID, Map) -> Map` | `PUT /api/identity/roles/{id}` | Update role |
| `delete(UUID) -> void` | `DELETE /api/identity/roles/{id}` | Delete role |

## PermissionApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/identity/permissions` | List permissions |
| `getById(UUID) -> Map` | `GET /api/identity/permissions/{id}` | Get permission |
| `create(Map) -> Map` | `POST /api/identity/permissions` | Create permission |
| `update(UUID, Map) -> Map` | `PUT /api/identity/permissions/{id}` | Update permission |
| `delete(UUID) -> void` | `DELETE /api/identity/permissions/{id}` | Delete permission |

## TenantApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/identity/tenants` | List tenants |
| `getById(UUID) -> Map` | `GET /api/identity/tenants/{id}` | Get tenant |
| `create(Map) -> Map` | `POST /api/identity/tenants` | Create tenant |
| `update(UUID, Map) -> Map` | `PUT /api/identity/tenants/{id}` | Update tenant |
| `delete(UUID) -> void` | `DELETE /api/identity/tenants/{id}` | Delete tenant |

## CompanyApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/identity/companies` | List companies |
| `getById(UUID) -> Map` | `GET /api/identity/companies/{id}` | Get company |
| `create(Map) -> Map` | `POST /api/identity/companies` | Create company |
| `update(UUID, Map) -> Map` | `PUT /api/identity/companies/{id}` | Update company |
| `delete(UUID) -> void` | `DELETE /api/identity/companies/{id}` | Delete company |
| `listGroups(PageRequest) -> PageResponse<Map>` | `GET /api/identity/company-groups` | List company groups |
| `getGroupById(UUID) -> Map` | `GET /api/identity/company-groups/{id}` | Get group |
| `createGroup(Map) -> Map` | `POST /api/identity/company-groups` | Create group |
| `updateGroup(UUID, Map) -> Map` | `PUT /api/identity/company-groups/{id}` | Update group |
| `deleteGroup(UUID) -> void` | `DELETE /api/identity/company-groups/{id}` | Delete group |

## BranchApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/identity/branches` | List branches |
| `getById(UUID) -> Map` | `GET /api/identity/branches/{id}` | Get branch |
| `create(Map) -> Map` | `POST /api/identity/branches` | Create branch |
| `update(UUID, Map) -> Map` | `PUT /api/identity/branches/{id}` | Update branch |
| `delete(UUID) -> void` | `DELETE /api/identity/branches/{id}` | Delete branch |

## ProfileApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `getMyProfile() -> Map` | `GET /api/identity/profiles/me` | Get current user profile |
| `updateMyProfile(Map) -> Map` | `PUT /api/identity/profiles/me` | Update current user profile |

```java
Map profile = identity.profiles().getMyProfile();
identity.profiles().updateMyProfile(Map.of("firstName", "Updated Name"));
```

## SessionApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/identity/sessions` | List active sessions |
| `revoke(UUID) -> void` | `DELETE /api/identity/sessions/{id}` | Revoke a session |
| `revokeAll() -> void` | `DELETE /api/identity/sessions` | Revoke all sessions |

## ApiKeyApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/identity/api-keys` | List API keys |
| `getById(UUID) -> Map` | `GET /api/identity/api-keys/{id}` | Get API key |
| `create(Map) -> Map` | `POST /api/identity/api-keys` | Create API key |
| `revoke(UUID) -> void` | `DELETE /api/identity/api-keys/{id}` | Revoke API key |

```java
Map apiKey = identity.apiKeys().create(Map.of("name", "CI/CD Key", "scopes", List.of("read", "write")));
identity.apiKeys().revoke(apiKeyId);
```

## Error Scenarios

| HTTP Status | Cause |
|-------------|-------|
| `400` | Invalid request data (bad email format, weak password) |
| `401` | Invalid credentials or expired token |
| `403` | Insufficient permissions |
| `404` | User, role, or resource not found |
| `409` | Conflict (duplicate email, role name already exists) |
| `429` | Rate limit exceeded (login attempts) |
