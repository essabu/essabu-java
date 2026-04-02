# Modules Reference

Complete reference for all 8 Essabu SDK modules, their sub-resources, and available methods.

## HR Module -- `essabu.hr()`

Human resources management across the employee lifecycle.

### Core

| Sub-resource | Accessor | Key Methods |
|--------------|----------|-------------|
| **Employees** | `.employees()` | `create`, `get`, `list`, `update`, `delete`, `getLeaveBalances`, `getHistory`, `getDocuments`, `getOrgTree`, `getOrgChart` |
| **Departments** | `.departments()` | `create`, `get`, `list`, `update`, `delete` |
| **Positions** | `.positions()` | `create`, `get`, `list`, `update`, `delete` |

### Workforce

| Sub-resource | Accessor | Key Methods |
|--------------|----------|-------------|
| **Contracts** | `.contracts()` | `create`, `get`, `list`, `update`, `delete` |
| **Attendance** | `.attendances()` | `create`, `get`, `list`, `update`, `delete` |
| **Leaves** | `.leaves()` | `create`, `get`, `list`, `update`, `delete` |
| **Shifts** | `.shifts()` | `create`, `get`, `list`, `update`, `delete` |
| **Shift Schedules** | `.shiftSchedules()` | `create`, `get`, `list`, `update`, `delete` |
| **Training** | `.trainings()` | `create`, `get`, `list`, `update`, `delete` |
| **Timesheets** | `.timesheets()` | `create`, `get`, `list`, `update`, `delete` |

### Compensation

| Sub-resource | Accessor | Key Methods |
|--------------|----------|-------------|
| **Payroll** | `.payrolls()` | `create`, `get`, `list`, `update`, `delete` |
| **Expenses** | `.expenses()` | `create`, `get`, `list`, `update`, `delete` |
| **Benefits** | `.benefits()` | `create`, `get`, `list`, `update`, `delete` |
| **Loans** | `.loans()` | `create`, `get`, `list`, `update`, `delete` |

### Talent

| Sub-resource | Accessor | Key Methods |
|--------------|----------|-------------|
| **Recruitment** | `.recruitment()` | `create`, `get`, `list`, `update`, `delete` |
| **Performance** | `.performance()` | `create`, `get`, `list`, `update`, `delete` |
| **Onboarding** | `.onboarding()` | `create`, `get`, `list`, `update`, `delete` |
| **Documents** | `.documents()` | `create`, `get`, `list`, `update`, `delete` |
| **Disciplinary** | `.disciplinary()` | `create`, `get`, `list`, `update`, `delete` |
| **Skills** | `.skills()` | `create`, `get`, `list`, `update`, `delete` |

### Admin

| Sub-resource | Accessor | Key Methods |
|--------------|----------|-------------|
| **Reports** | `.reports()` | `generate`, `list` |
| **Webhooks** | `.webhooks()` | `create`, `list`, `delete` |
| **Config** | `.config()` | `get`, `update` |
| **History** | `.history()` | `list` |

---

## Accounting Module -- `essabu.accounting()`

Financial management, invoicing, inventory, and insurance.

### Core

| Sub-resource | Accessor | Key Methods |
|--------------|----------|-------------|
| **Accounts** | `.accounts()` | `create`, `get`, `list`, `update`, `delete` |
| **Balances** | `.balances()` | `get`, `list` |
| **Config** | `.config()` | `get`, `update` |

### Transactions

| Sub-resource | Accessor | Key Methods |
|--------------|----------|-------------|
| **Invoices** | `.invoices()` | `create`, `get`, `list`, `update`, `delete`, `finalize`, `send`, `markAsPaid`, `cancel`, `downloadPdf`, `createRecurring`, `listRecurring`, `updateRecurring`, `deleteRecurring`, `activateRecurring`, `deactivateRecurring` |
| **Quotes** | `.quotes()` | `create`, `get`, `list`, `update`, `delete` |
| **Credit Notes** | `.creditNotes()` | `create`, `get`, `list`, `update`, `delete` |
| **Payments** | `.payments()` | `create`, `get`, `list`, `update`, `delete` |
| **Payment Terms** | `.paymentTerms()` | `create`, `get`, `list`, `update`, `delete` |
| **Journals** | `.journals()` | `create`, `get`, `list`, `update`, `delete` |
| **Journal Entries** | `.journalEntries()` | `create`, `get`, `list`, `update`, `delete` |

### Finance

| Sub-resource | Accessor | Key Methods |
|--------------|----------|-------------|
| **Tax Rates** | `.taxRates()` | `create`, `get`, `list`, `update`, `delete` |
| **Currencies** | `.currencies()` | `create`, `get`, `list`, `update`, `delete` |
| **Exchange Rates** | `.exchangeRates()` | `create`, `get`, `list`, `update`, `delete` |
| **Exchange Rate Providers** | `.exchangeRateProviders()` | `create`, `get`, `list`, `update`, `delete` |
| **Fiscal Years** | `.fiscalYears()` | `create`, `get`, `list`, `update`, `delete` |
| **Periods** | `.periods()` | `create`, `get`, `list`, `update`, `delete` |
| **Reports** | `.reports()` | `generate`, `list` |
| **Wallets** | `.wallets()` | `create`, `get`, `list`, `update`, `delete` |
| **Wallet Transactions** | `.walletTransactions()` | `create`, `get`, `list` |

### Commercial (Insurance & Pricing)

| Sub-resource | Accessor | Key Methods |
|--------------|----------|-------------|
| **Insurance Partners** | `.insurancePartners()` | `create`, `get`, `list`, `update`, `delete` |
| **Insurance Contracts** | `.insuranceContracts()` | `create`, `get`, `list`, `update`, `delete` |
| **Insurance Claims** | `.insuranceClaims()` | `create`, `get`, `list`, `update`, `delete` |
| **Price Lists** | `.priceLists()` | `create`, `get`, `list`, `update`, `delete` |
| **Price List Overrides** | `.priceListOverrides()` | `create`, `get`, `list`, `update`, `delete` |

### Inventory

| Sub-resource | Accessor | Key Methods |
|--------------|----------|-------------|
| **Suppliers** | `.suppliers()` | `create`, `get`, `list`, `update`, `delete` |
| **Inventory** | `.inventory()` | `get`, `list`, `update` |
| **Purchase Orders** | `.purchaseOrders()` | `create`, `get`, `list`, `update`, `delete` |
| **Batches** | `.batches()` | `create`, `get`, `list`, `update`, `delete` |
| **Stock Movements** | `.stockMovements()` | `create`, `get`, `list` |
| **Stock Counts** | `.stockCounts()` | `create`, `get`, `list`, `update`, `delete` |
| **Stock Locations** | `.stockLocations()` | `create`, `get`, `list`, `update`, `delete` |
| **Webhooks** | `.webhooks()` | `create`, `list`, `delete` |

---

## Identity Module -- `essabu.identity()`

Authentication, authorization, and tenant management.

### Auth

| Sub-resource | Accessor | Key Methods |
|--------------|----------|-------------|
| **Auth** | `.auth()` | `login`, `register`, `refresh`, `logout`, `verifyEmail`, `forgotPassword`, `resetPassword`, `enable2FA`, `verify2FA` |
| **Sessions** | `.sessions()` | `list`, `revoke` |
| **Login Attempts** | `.loginAttempts()` | `list` |

### Management

| Sub-resource | Accessor | Key Methods |
|--------------|----------|-------------|
| **Users** | `.users()` | `create`, `get`, `list`, `update`, `delete` |
| **Profiles** | `.profiles()` | `get`, `update` |
| **Companies** | `.companies()` | `create`, `get`, `list`, `update`, `delete` |
| **Company Groups** | `.companyGroups()` | `create`, `get`, `list`, `update`, `delete` |
| **Tenants** | `.tenants()` | `create`, `get`, `list`, `update`, `delete` |
| **Roles** | `.roles()` | `create`, `get`, `list`, `update`, `delete` |
| **Permissions** | `.permissions()` | `create`, `get`, `list`, `update`, `delete` |
| **Branches** | `.branches()` | `create`, `get`, `list`, `update`, `delete` |
| **API Keys** | `.apiKeys()` | `create`, `list`, `revoke` |

---

## Trade Module -- `essabu.trade()`

Commerce operations and customer management.

| Sub-resource | Accessor | Key Methods |
|--------------|----------|-------------|
| **Customers** | `.customers()` | `create`, `getById`, `getAll`, `update`, `createGroup`, `getAllGroups` |
| **Products** | `.products()` | `create`, `get`, `list`, `update`, `delete` |
| **Sales Orders** | `.salesOrders()` | `create`, `getById`, `getAll`, `confirm` |
| **Deliveries** | `.deliveries()` | `create`, `get`, `list`, `update`, `delete` |
| **Receipts** | `.receipts()` | `create`, `get`, `list`, `update`, `delete` |

---

## Payment Module -- `essabu.payment()`

Payment processing, subscriptions, and lending.

### Payment

| Sub-resource | Accessor | Key Methods |
|--------------|----------|-------------|
| **Payment Intents** | `.paymentIntents()` | `create`, `getById`, `getByCompany`, `confirm`, `cancel` |
| **Payment Transactions** | `.paymentTransactions()` | `get`, `list` |
| **Payment Accounts** | `.paymentAccounts()` | `create`, `get`, `list`, `update` |
| **Payouts** | `.payouts()` | `create`, `get`, `list` |
| **Refunds** | `.refunds()` | `create`, `get`, `list` |
| **SDK API Keys** | `.sdkApiKeys()` | `create`, `list`, `revoke` |
| **Settlements** | `.settlements()` | `get`, `list` |
| **Webhooks** | `.webhooks()` | `create`, `list`, `delete` |

### Subscriptions

| Sub-resource | Accessor | Key Methods |
|--------------|----------|-------------|
| **Subscriptions** | `.subscriptions()` | `create`, `get`, `list`, `update`, `cancel` |
| **Billing Cycles** | `.billingCycles()` | `get`, `list` |
| **SaaS Invoices** | `.saasInvoices()` | `get`, `list` |
| **Usage** | `.usages()` | `record`, `get`, `list` |

### Lending

| Sub-resource | Accessor | Key Methods |
|--------------|----------|-------------|
| **Loan Applications** | `.loanApplications()` | `create`, `getById`, `getByCompany`, `update`, `submit`, `approve`, `reject`, `disburse`, `repay`, `getSchedule` |
| **Loan Products** | `.loanProducts()` | `create`, `get`, `list`, `update`, `delete` |
| **Collaterals** | `.collaterals()` | `create`, `get`, `list`, `update`, `delete` |
| **Financial Accounts** | `.financialAccounts()` | `create`, `get`, `list`, `update` |
| **KYC Profiles** | `.kycProfiles()` | `create`, `get`, `update` |
| **KYC Documents** | `.kycDocuments()` | `upload`, `get`, `list` |

---

## E-Invoice Module -- `essabu.einvoice()`

Electronic invoicing and government compliance.

### Invoice

| Sub-resource | Accessor | Key Methods |
|--------------|----------|-------------|
| **Invoices** | `.invoices()` | `create`, `get`, `list`, `update`, `delete`, `normalize` |
| **Submissions** | `.submissions()` | `submit`, `checkStatus`, `list` |

### Verification

| Sub-resource | Accessor | Key Methods |
|--------------|----------|-------------|
| **Verification** | `.verification()` | `verify`, `get`, `list` |
| **Compliance** | `.compliance()` | `check`, `get`, `list` |
| **Statistics** | `.statistics()` | `get`, `getSummary` |

---

## Project Module -- `essabu.project()`

Project management and resource allocation.

| Sub-resource | Accessor | Key Methods |
|--------------|----------|-------------|
| **Projects** | `.projects()` | `create`, `get`, `list`, `update`, `delete` |
| **Milestones** | `.milestones()` | `create`, `get`, `list`, `update`, `delete` |
| **Tasks** | `.tasks()` | `create`, `get`, `list`, `update`, `delete` |
| **Task Comments** | `.taskComments()` | `create`, `get`, `list`, `update`, `delete` |
| **Resource Allocations** | `.resourceAllocations()` | `create`, `get`, `list`, `update`, `delete` |
| **Reports** | `.reports()` | `generate`, `list` |

---

## Asset Module -- `essabu.asset()`

Asset management, depreciation, and fleet tracking.

| Sub-resource | Accessor | Key Methods |
|--------------|----------|-------------|
| **Assets** | `.assets()` | `create`, `get`, `list`, `update`, `delete` |
| **Depreciation** | `.depreciations()` | `create`, `get`, `list`, `update`, `delete` |
| **Maintenance Schedules** | `.maintenanceSchedules()` | `create`, `get`, `list`, `update`, `delete` |
| **Maintenance Logs** | `.maintenanceLogs()` | `create`, `get`, `list`, `update`, `delete` |
| **Vehicles** | `.vehicles()` | `create`, `get`, `list`, `update`, `delete` |
| **Fuel Logs** | `.fuelLogs()` | `create`, `get`, `list`, `update`, `delete` |
| **Trip Logs** | `.tripLogs()` | `create`, `get`, `list`, `update`, `delete` |

---

## Common Patterns

### Pagination

All list endpoints accept `PageRequest` and return `PageResponse<T>`:

```java
PageRequest page = PageRequest.builder()
    .page(0)        // Zero-based page index
    .size(20)       // Items per page
    .sort("createdAt")
    .direction("desc")
    .build();

PageResponse<EmployeeResponse> response = essabu.hr().employees().list(page);

// Response fields
response.getContent();       // List<T> of items
response.getTotalElements(); // Total item count
response.getTotalPages();    // Total page count
response.getNumber();        // Current page number
```

### Error Handling

All methods may throw `EssabuApiException` subtypes:

| Exception | HTTP | When |
|-----------|------|------|
| `EssabuValidationException` | 400/422 | Invalid request data |
| `EssabuUnauthorizedException` | 401 | Bad or expired API key |
| `EssabuForbiddenException` | 403 | Missing permissions |
| `EssabuNotFoundException` | 404 | Resource does not exist |
| `EssabuRateLimitException` | 429 | Too many requests |
| `EssabuServerException` | 5xx | Server error (auto-retried) |
