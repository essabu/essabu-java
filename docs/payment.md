# Payment Module Reference

The Payment module handles payment processing (intents, transactions, refunds, payouts), subscriptions with billing cycles and usage tracking, lending (loan products, applications, collaterals), KYC verification, payment accounts, and financial reporting.

## Client Access

Initialize the Payment client by calling `payment()` on your Essabu instance. The client is lazily created on first access and cached for subsequent calls. Requires an API key with payment module permissions; otherwise all operations will throw `ForbiddenException`.

```java
EssabuClient essabu = new EssabuClient("your-api-key");
PaymentClient payment = essabu.payment();
```

## Available API Classes

| Class | Accessor | Description |
|-------|----------|-------------|
| `PaymentIntentApi` | `payment.intents()` | Payment intents with confirm/cancel |
| `TransactionApi` | `payment.transactions()` | Transaction history (read-only) |
| `RefundApi` | `payment.refunds()` | Refund operations |
| `PayoutApi` | `payment.payouts()` | Payouts and settlements |
| `SubscriptionApi` | `payment.subscriptions()` | Subscriptions, billing, usage |
| `LoanApi` | `payment.loans()` | Lending operations |
| `KycApi` | `payment.kyc()` | KYC profiles and documents |
| `PaymentAccountApi` | `payment.accounts()` | Payment accounts and SDK keys |
| `ReportApi` | `payment.reports()` | Lending reports |

---

## PaymentIntentApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/payment/intents` | List payment intents |
| `getById(UUID) -> Map` | `GET /api/payment/intents/{id}` | Get intent |
| `create(Map) -> Map` | `POST /api/payment/intents` | Create payment intent |
| `confirm(UUID) -> Map` | `POST /api/payment/intents/{id}/confirm` | Confirm intent |
| `cancel(UUID) -> Map` | `POST /api/payment/intents/{id}/cancel` | Cancel intent |

Create a payment intent to initiate a payment flow, then confirm it to execute the charge. Requires `amount` (in the smallest currency unit, e.g., cents), `currency` (ISO 4217 code), and a `customerId`. The intent remains in a pending state until confirmed or cancelled. Throws `ConflictException` if the intent has already been confirmed or cancelled.

```java
// Create and confirm a payment
Map intent = payment.intents().create(Map.of(
    "amount", 5000, "currency", "USD", "customerId", customerId
));
payment.intents().confirm(intentId);
```

## TransactionApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/payment/transactions` | List transactions |
| `getById(UUID) -> Map` | `GET /api/payment/transactions/{id}` | Get transaction |

## RefundApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/payment/refunds` | List refunds |
| `getById(UUID) -> Map` | `GET /api/payment/refunds/{id}` | Get refund |
| `create(Map) -> Map` | `POST /api/payment/refunds` | Create refund |

Issue a full or partial refund against a completed transaction. Requires the `transactionId`, `amount` to refund (must not exceed the original transaction amount), and an optional `reason`. Returns the created refund with its status and processing details. Throws `ValidationException` if the refund amount exceeds the remaining refundable amount.

```java
Map refund = payment.refunds().create(Map.of(
    "transactionId", txId, "amount", 1000, "reason", "Customer request"
));
```

## PayoutApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/payment/payouts` | List payouts |
| `getById(UUID) -> Map` | `GET /api/payment/payouts/{id}` | Get payout |
| `create(Map) -> Map` | `POST /api/payment/payouts` | Create payout |
| `listSettlements(PageRequest) -> PageResponse<Map>` | `GET /api/payment/settlements` | List settlements |
| `getSettlementById(UUID) -> Map` | `GET /api/payment/settlements/{id}` | Get settlement |

## SubscriptionApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/payment/subscriptions` | List subscriptions |
| `getById(UUID) -> Map` | `GET /api/payment/subscriptions/{id}` | Get subscription |
| `create(Map) -> Map` | `POST /api/payment/subscriptions` | Create subscription |
| `update(UUID, Map) -> Map` | `PUT /api/payment/subscriptions/{id}` | Update subscription |
| `cancel(UUID) -> Map` | `POST /api/payment/subscriptions/{id}/cancel` | Cancel subscription |
| `listBillingCycles(PageRequest) -> PageResponse<Map>` | `GET /api/payment/billing-cycles` | List billing cycles |
| `reportUsage(Map) -> Map` | `POST /api/payment/usage` | Report usage |
| `getUsageSummary(UUID subscriptionId) -> Map` | `GET /api/payment/usage/summary?subscriptionId=` | Usage summary |
| `listInvoices(PageRequest) -> PageResponse<Map>` | `GET /api/payment/invoices` | List SaaS invoices |
| `getInvoiceById(UUID) -> Map` | `GET /api/payment/invoices/{id}` | Get SaaS invoice |

Create a subscription by linking a customer to a pricing plan. The `reportUsage` method records metered usage events with a `subscriptionId`, `quantity`, and ISO 8601 `timestamp` for usage-based billing. Cancelling a subscription takes effect at the end of the current billing cycle. Throws `ConflictException` if the subscription is already cancelled.

```java
// Create a subscription and report usage
Map sub = payment.subscriptions().create(Map.of(
    "planId", planId, "customerId", customerId
));
payment.subscriptions().reportUsage(Map.of(
    "subscriptionId", subId, "quantity", 150, "timestamp", "2026-03-26T10:00:00Z"
));
```

## LoanApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `listProducts(PageRequest) -> PageResponse<Map>` | `GET /api/lending/loan-products` | List loan products |
| `getProductById(UUID) -> Map` | `GET /api/lending/loan-products/{id}` | Get product |
| `createProduct(Map) -> Map` | `POST /api/lending/loan-products` | Create product |
| `updateProduct(UUID, Map) -> Map` | `PUT /api/lending/loan-products/{id}` | Update product |
| `deleteProduct(UUID) -> void` | `DELETE /api/lending/loan-products/{id}` | Delete product |
| `listApplications(PageRequest) -> PageResponse<Map>` | `GET /api/lending/loan-applications` | List applications |
| `getApplicationById(UUID) -> Map` | `GET /api/lending/loan-applications/{id}` | Get application |
| `createApplication(Map) -> Map` | `POST /api/lending/loan-applications` | Create application |
| `updateApplication(UUID, Map) -> Map` | `PUT /api/lending/loan-applications/{id}` | Update application |
| `listCollaterals(PageRequest) -> PageResponse<Map>` | `GET /api/lending/collaterals` | List collaterals |
| `createCollateral(Map) -> Map` | `POST /api/lending/collaterals` | Create collateral |
| `listAccounts(PageRequest) -> PageResponse<Map>` | `GET /api/lending/accounts` | List loan accounts |
| `getAccountById(UUID) -> Map` | `GET /api/lending/accounts/{id}` | Get loan account |
| `createAccount(Map) -> Map` | `POST /api/lending/accounts` | Create loan account |

## KycApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `listProfiles(PageRequest) -> PageResponse<Map>` | `GET /api/lending/kyc-profiles` | List KYC profiles |
| `getProfileById(UUID) -> Map` | `GET /api/lending/kyc-profiles/{id}` | Get KYC profile |
| `createProfile(Map) -> Map` | `POST /api/lending/kyc-profiles` | Create KYC profile |
| `listDocuments(PageRequest) -> PageResponse<Map>` | `GET /api/lending/kyc-documents` | List KYC documents |
| `uploadDocument(Map) -> Map` | `POST /api/lending/kyc-documents` | Upload KYC document |

## PaymentAccountApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/payment/accounts` | List accounts |
| `getById(UUID) -> Map` | `GET /api/payment/accounts/{id}` | Get account |
| `create(Map) -> Map` | `POST /api/payment/accounts` | Create account |
| `update(UUID, Map) -> Map` | `PUT /api/payment/accounts/{id}` | Update account |
| `listSdkKeys(PageRequest) -> PageResponse<Map>` | `GET /api/payment/sdk-keys` | List SDK keys |
| `createSdkKey(Map) -> Map` | `POST /api/payment/sdk-keys` | Create SDK key |
| `revokeSdkKey(UUID) -> void` | `DELETE /api/payment/sdk-keys/{id}` | Revoke SDK key |

## ReportApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `getLoanPortfolio(Map params) -> Map` | `GET /api/lending/reports/portfolio` | Loan portfolio report |
| `getDelinquencyReport(Map params) -> Map` | `GET /api/lending/reports/delinquency` | Delinquency report |

## Error Scenarios

| HTTP Status | Cause |
|-------------|-------|
| `400` | Invalid request (bad amount, missing currency) |
| `401` | Missing or expired authentication token |
| `403` | Insufficient permissions |
| `404` | Intent, transaction, or subscription not found |
| `409` | Conflict (intent already confirmed, subscription already cancelled) |
| `422` | Business rule violation (insufficient balance, KYC not verified) |
