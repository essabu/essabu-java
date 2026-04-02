# Accounting Module Reference

The Accounting module covers chart of accounts, invoicing, payments, wallets, journals, quotes, credit notes, tax rates, fiscal years, currencies, inventory, coupons, insurance, usage-based billing, recurring invoices, and financial reports.

## Client Access

```java
EssabuClient essabu = new EssabuClient("your-api-key");
AccountingClient accounting = essabu.accounting();
```

## Available API Classes

| Class | Accessor | Description |
|-------|----------|-------------|
| `AccountApi` | `accounting.accounts()` | Chart of accounts and balances |
| `InvoiceApi` | `accounting.invoices()` | Invoices, branding, locales |
| `PaymentApi` | `accounting.payments()` | Payments, terms, schedules |
| `WalletApi` | `accounting.wallets()` | Wallets and wallet transactions |
| `JournalApi` | `accounting.journals()` | Journals and journal entries |
| `QuoteApi` | `accounting.quotes()` | Quotes with PDF and conversion |
| `CreditNoteApi` | `accounting.creditNotes()` | Credit notes |
| `TaxRateApi` | `accounting.taxRates()` | Tax rates |
| `FiscalYearApi` | `accounting.fiscalYears()` | Fiscal years and periods |
| `CurrencyApi` | `accounting.currencies()` | Currencies, exchange rates, providers |
| `InventoryApi` | `accounting.inventory()` | Items, suppliers, POs, stock |
| `CouponApi` | `accounting.coupons()` | Discount coupons |
| `ReportApi` | `accounting.reports()` | Financial reports |
| `ConfigApi` | `accounting.config()` | Accounting config and price lists |
| `InsuranceApi` | `accounting.insurance()` | Insurance partners, contracts, claims |
| `BillingApi` | `accounting.billing()` | Usage-based billing |
| `RecurringInvoiceApi` | `accounting.recurringInvoices()` | Recurring invoice templates |

---

## AccountApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/accounts` | List chart of accounts |
| `getById(UUID) -> Map` | `GET /api/accounting/accounts/{id}` | Get account |
| `create(Map) -> Map` | `POST /api/accounting/accounts` | Create account |
| `update(UUID, Map) -> Map` | `PUT /api/accounting/accounts/{id}` | Update account |
| `delete(UUID) -> void` | `DELETE /api/accounting/accounts/{id}` | Delete account |
| `listBalances(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/balances` | List all balances |
| `getBalance(UUID accountId) -> Map` | `GET /api/accounting/balances/{accountId}` | Get account balance |

```java
Map account = accounting.accounts().create(Map.of(
    "code", "4100", "name", "Sales Revenue", "type", "revenue"
));
Map balance = accounting.accounts().getBalance(accountId);
```

## InvoiceApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/invoices` | List invoices |
| `getById(UUID) -> Map` | `GET /api/accounting/invoices/{id}` | Get invoice |
| `create(Map) -> Map` | `POST /api/accounting/invoices` | Create invoice |
| `update(UUID, Map) -> Map` | `PUT /api/accounting/invoices/{id}` | Update invoice |
| `delete(UUID) -> void` | `DELETE /api/accounting/invoices/{id}` | Delete invoice |
| `finalize(UUID) -> Map` | `POST /api/accounting/invoices/{id}/finalize` | Finalize invoice |
| `downloadPdf(UUID) -> byte[]` | `GET /api/accounting/invoices/{id}/pdf` | Download PDF |
| `sendByEmail(UUID, Map) -> Map` | `POST /api/accounting/invoices/{id}/send` | Send by email |
| `applyCoupon(UUID, Map) -> Map` | `POST /api/accounting/invoices/{id}/apply-coupon` | Apply coupon |
| `getPaymentLink(UUID) -> Map` | `GET /api/accounting/invoices/{id}/payment-link` | Get payment link |
| `listBrandings(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/invoice-branding` | List brandings |
| `createBranding(Map) -> Map` | `POST /api/accounting/invoice-branding` | Create branding |
| `updateBranding(UUID, Map) -> Map` | `PUT /api/accounting/invoice-branding/{id}` | Update branding |
| `listLocales(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/invoice-locales` | List locales |
| `createLocale(Map) -> Map` | `POST /api/accounting/invoice-locales` | Create locale |

```java
// Full invoicing workflow
Map invoice = accounting.invoices().create(Map.of(
    "customerId", customerId, "items", List.of(Map.of("description", "Service", "amount", 100.00))
));
accounting.invoices().finalize(invoiceId);
accounting.invoices().sendByEmail(invoiceId, Map.of("to", "client@example.com"));
byte[] pdf = accounting.invoices().downloadPdf(invoiceId);
```

## PaymentApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/payments` | List payments |
| `getById(UUID) -> Map` | `GET /api/accounting/payments/{id}` | Get payment |
| `create(Map) -> Map` | `POST /api/accounting/payments` | Record payment |
| `update(UUID, Map) -> Map` | `PUT /api/accounting/payments/{id}` | Update payment |
| `delete(UUID) -> void` | `DELETE /api/accounting/payments/{id}` | Delete payment |
| `listTerms(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/payment-terms` | List payment terms |
| `getTermById(UUID) -> Map` | `GET /api/accounting/payment-terms/{id}` | Get payment term |
| `createTerm(Map) -> Map` | `POST /api/accounting/payment-terms` | Create payment term |
| `updateTerm(UUID, Map) -> Map` | `PUT /api/accounting/payment-terms/{id}` | Update payment term |
| `deleteTerm(UUID) -> void` | `DELETE /api/accounting/payment-terms/{id}` | Delete payment term |
| `listSchedules(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/payment-schedules` | List schedules |
| `getScheduleById(UUID) -> Map` | `GET /api/accounting/payment-schedules/{id}` | Get schedule |
| `createSchedule(Map) -> Map` | `POST /api/accounting/payment-schedules` | Create schedule |

## WalletApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/wallets` | List wallets |
| `getById(UUID) -> Map` | `GET /api/accounting/wallets/{id}` | Get wallet |
| `create(Map) -> Map` | `POST /api/accounting/wallets` | Create wallet |
| `update(UUID, Map) -> Map` | `PUT /api/accounting/wallets/{id}` | Update wallet |
| `delete(UUID) -> void` | `DELETE /api/accounting/wallets/{id}` | Delete wallet |
| `listTransactions(UUID walletId, PageRequest) -> PageResponse<Map>` | `GET /api/accounting/wallet-transactions?walletId=` | List transactions |
| `getTransactionById(UUID) -> Map` | `GET /api/accounting/wallet-transactions/{id}` | Get transaction |
| `createTransaction(Map) -> Map` | `POST /api/accounting/wallet-transactions` | Create transaction |

## JournalApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/journals` | List journals |
| `getById(UUID) -> Map` | `GET /api/accounting/journals/{id}` | Get journal |
| `create(Map) -> Map` | `POST /api/accounting/journals` | Create journal |
| `update(UUID, Map) -> Map` | `PUT /api/accounting/journals/{id}` | Update journal |
| `delete(UUID) -> void` | `DELETE /api/accounting/journals/{id}` | Delete journal |
| `listEntries(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/journal-entries` | List entries |
| `getEntryById(UUID) -> Map` | `GET /api/accounting/journal-entries/{id}` | Get entry |
| `createEntry(Map) -> Map` | `POST /api/accounting/journal-entries` | Create entry |
| `updateEntry(UUID, Map) -> Map` | `PUT /api/accounting/journal-entries/{id}` | Update entry |
| `deleteEntry(UUID) -> void` | `DELETE /api/accounting/journal-entries/{id}` | Delete entry |

```java
// Create a journal entry
Map entry = accounting.journals().createEntry(Map.of(
    "journalId", journalId,
    "date", "2026-03-26",
    "lines", List.of(
        Map.of("accountId", debitAccountId, "debit", 1000.00),
        Map.of("accountId", creditAccountId, "credit", 1000.00)
    )
));
```

## QuoteApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/quotes` | List quotes |
| `getById(UUID) -> Map` | `GET /api/accounting/quotes/{id}` | Get quote |
| `create(Map) -> Map` | `POST /api/accounting/quotes` | Create quote |
| `update(UUID, Map) -> Map` | `PUT /api/accounting/quotes/{id}` | Update quote |
| `delete(UUID) -> void` | `DELETE /api/accounting/quotes/{id}` | Delete quote |
| `convertToInvoice(UUID) -> Map` | `POST /api/accounting/quotes/{id}/convert-to-invoice` | Convert to invoice |
| `downloadPdf(UUID) -> byte[]` | `GET /api/accounting/quotes/{id}/pdf` | Download PDF |

## FiscalYearApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/fiscal-years` | List fiscal years |
| `getById(UUID) -> Map` | `GET /api/accounting/fiscal-years/{id}` | Get fiscal year |
| `create(Map) -> Map` | `POST /api/accounting/fiscal-years` | Create fiscal year |
| `update(UUID, Map) -> Map` | `PUT /api/accounting/fiscal-years/{id}` | Update fiscal year |
| `delete(UUID) -> void` | `DELETE /api/accounting/fiscal-years/{id}` | Delete fiscal year |
| `listPeriods(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/periods` | List periods |
| `getPeriodById(UUID) -> Map` | `GET /api/accounting/periods/{id}` | Get period |
| `createPeriod(Map) -> Map` | `POST /api/accounting/periods` | Create period |
| `closePeriod(UUID) -> Map` | `POST /api/accounting/periods/{id}/close` | Close period |

## CurrencyApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/currencies` | List currencies |
| `getById(UUID) -> Map` | `GET /api/accounting/currencies/{id}` | Get currency |
| `create(Map) -> Map` | `POST /api/accounting/currencies` | Create currency |
| `update(UUID, Map) -> Map` | `PUT /api/accounting/currencies/{id}` | Update currency |
| `delete(UUID) -> void` | `DELETE /api/accounting/currencies/{id}` | Delete currency |
| `listRates(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/exchange-rates` | List exchange rates |
| `createRate(Map) -> Map` | `POST /api/accounting/exchange-rates` | Create exchange rate |
| `listProviders(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/exchange-rate-providers` | List rate providers |
| `getProviderById(UUID) -> Map` | `GET /api/accounting/exchange-rate-providers/{id}` | Get provider |
| `createProvider(Map) -> Map` | `POST /api/accounting/exchange-rate-providers` | Create provider |
| `updateProvider(UUID, Map) -> Map` | `PUT /api/accounting/exchange-rate-providers/{id}` | Update provider |

## InventoryApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `listItems(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/inventory` | List items |
| `getItemById(UUID) -> Map` | `GET /api/accounting/inventory/{id}` | Get item |
| `createItem(Map) -> Map` | `POST /api/accounting/inventory` | Create item |
| `updateItem(UUID, Map) -> Map` | `PUT /api/accounting/inventory/{id}` | Update item |
| `deleteItem(UUID) -> void` | `DELETE /api/accounting/inventory/{id}` | Delete item |
| `listSuppliers(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/suppliers` | List suppliers |
| `getSupplierById(UUID) -> Map` | `GET /api/accounting/suppliers/{id}` | Get supplier |
| `createSupplier(Map) -> Map` | `POST /api/accounting/suppliers` | Create supplier |
| `updateSupplier(UUID, Map) -> Map` | `PUT /api/accounting/suppliers/{id}` | Update supplier |
| `deleteSupplier(UUID) -> void` | `DELETE /api/accounting/suppliers/{id}` | Delete supplier |
| `listPurchaseOrders(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/purchase-orders` | List POs |
| `getPurchaseOrderById(UUID) -> Map` | `GET /api/accounting/purchase-orders/{id}` | Get PO |
| `createPurchaseOrder(Map) -> Map` | `POST /api/accounting/purchase-orders` | Create PO |
| `updatePurchaseOrder(UUID, Map) -> Map` | `PUT /api/accounting/purchase-orders/{id}` | Update PO |
| `deletePurchaseOrder(UUID) -> void` | `DELETE /api/accounting/purchase-orders/{id}` | Delete PO |
| `listStockLocations(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/stock-locations` | List locations |
| `getStockLocationById(UUID) -> Map` | `GET /api/accounting/stock-locations/{id}` | Get location |
| `createStockLocation(Map) -> Map` | `POST /api/accounting/stock-locations` | Create location |
| `listStockMovements(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/stock-movements` | List movements |
| `createStockMovement(Map) -> Map` | `POST /api/accounting/stock-movements` | Create movement |
| `listStockCounts(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/stock-counts` | List counts |
| `createStockCount(Map) -> Map` | `POST /api/accounting/stock-counts` | Create count |
| `listBatches(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/batches` | List batches |
| `getBatchById(UUID) -> Map` | `GET /api/accounting/batches/{id}` | Get batch |
| `createBatch(Map) -> Map` | `POST /api/accounting/batches` | Create batch |

## InsuranceApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `listPartners(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/insurance-partners` | List partners |
| `getPartnerById(UUID) -> Map` | `GET /api/accounting/insurance-partners/{id}` | Get partner |
| `createPartner(Map) -> Map` | `POST /api/accounting/insurance-partners` | Create partner |
| `updatePartner(UUID, Map) -> Map` | `PUT /api/accounting/insurance-partners/{id}` | Update partner |
| `deletePartner(UUID) -> void` | `DELETE /api/accounting/insurance-partners/{id}` | Delete partner |
| `listContracts(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/insurance-contracts` | List contracts |
| `getContractById(UUID) -> Map` | `GET /api/accounting/insurance-contracts/{id}` | Get contract |
| `createContract(Map) -> Map` | `POST /api/accounting/insurance-contracts` | Create contract |
| `updateContract(UUID, Map) -> Map` | `PUT /api/accounting/insurance-contracts/{id}` | Update contract |
| `deleteContract(UUID) -> void` | `DELETE /api/accounting/insurance-contracts/{id}` | Delete contract |
| `listClaims(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/insurance-claims` | List claims |
| `getClaimById(UUID) -> Map` | `GET /api/accounting/insurance-claims/{id}` | Get claim |
| `createClaim(Map) -> Map` | `POST /api/accounting/insurance-claims` | Create claim |
| `updateClaim(UUID, Map) -> Map` | `PUT /api/accounting/insurance-claims/{id}` | Update claim |

## BillingApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `listConfigs(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/usage-billing-configs` | List billing configs |
| `getConfigById(UUID) -> Map` | `GET /api/accounting/usage-billing-configs/{id}` | Get config |
| `createConfig(Map) -> Map` | `POST /api/accounting/usage-billing-configs` | Create config |
| `updateConfig(UUID, Map) -> Map` | `PUT /api/accounting/usage-billing-configs/{id}` | Update config |
| `listMeters(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/usage-meters` | List meters |
| `getMeterById(UUID) -> Map` | `GET /api/accounting/usage-meters/{id}` | Get meter |
| `createMeter(Map) -> Map` | `POST /api/accounting/usage-meters` | Create meter |
| `listRecords(PageRequest) -> PageResponse<Map>` | `GET /api/accounting/usage-records` | List records |
| `createRecord(Map) -> Map` | `POST /api/accounting/usage-records` | Create record |
| `generateBill(Map) -> Map` | `POST /api/accounting/usage-billing/generate` | Generate bill |

## ReportApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `getTrialBalance(Map params) -> Map` | `GET /api/accounting/reports/trial-balance` | Trial balance |
| `getBalanceSheet(Map params) -> Map` | `GET /api/accounting/reports/balance-sheet` | Balance sheet |
| `getIncomeStatement(Map params) -> Map` | `GET /api/accounting/reports/income-statement` | Income statement |
| `getCashFlow(Map params) -> Map` | `GET /api/accounting/reports/cash-flow` | Cash flow |
| `getGeneralLedger(Map params) -> Map` | `GET /api/accounting/reports/general-ledger` | General ledger |
| `getAgedReceivables(Map params) -> Map` | `GET /api/accounting/reports/aged-receivables` | Aged receivables |
| `getAgedPayables(Map params) -> Map` | `GET /api/accounting/reports/aged-payables` | Aged payables |

## Standard CRUD APIs

| Class | Endpoint Base |
|-------|--------------|
| `CreditNoteApi` | `/api/accounting/credit-notes` |
| `TaxRateApi` | `/api/accounting/tax-rates` |
| `CouponApi` | `/api/accounting/coupons` |
| `RecurringInvoiceApi` | `/api/accounting/recurring-invoices` |

## ConfigApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `getConfig() -> Map` | `GET /api/accounting/config` | Get accounting config |
| `updateConfig(Map) -> Map` | `PUT /api/accounting/config` | Update config |
| `listPriceLists() -> Map` | `GET /api/accounting/price-lists` | List price lists |
| `createPriceList(Map) -> Map` | `POST /api/accounting/price-lists` | Create price list |

## Error Scenarios

| HTTP Status | Cause |
|-------------|-------|
| `400` | Invalid request data |
| `401` | Missing or expired authentication token |
| `403` | Insufficient permissions |
| `404` | Resource not found |
| `409` | Conflict (e.g., duplicate invoice number) |
| `422` | Business rule violation (e.g., period already closed) |
