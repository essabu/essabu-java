# Trade Module Reference

The Trade module covers CRM (customers, contacts, opportunities, activities, campaigns), sales and purchasing (orders, suppliers), contracts with clauses and amendments, products, warehousing, stock management, delivery notes, and goods receipts.

## Client Access

```java
EssabuClient essabu = new EssabuClient("your-api-key");
TradeClient trade = essabu.trade();
```

## Available API Classes

| Class | Accessor | Description |
|-------|----------|-------------|
| `CustomerApi` | `trade.customers()` | Customers and customer groups |
| `ContactApi` | `trade.contacts()` | CRM contacts |
| `OpportunityApi` | `trade.opportunities()` | Sales opportunities |
| `ProductApi` | `trade.products()` | Products, categories, price lists |
| `SalesOrderApi` | `trade.salesOrders()` | Sales orders |
| `PurchaseOrderApi` | `trade.purchaseOrders()` | Purchase orders |
| `SupplierApi` | `trade.suppliers()` | Suppliers and supplier invoices |
| `ContractApi` | `trade.contracts()` | Contracts, clauses, amendments, documents |
| `CampaignApi` | `trade.campaigns()` | Marketing campaigns |
| `ActivityApi` | `trade.activities()` | CRM activities |
| `WarehouseApi` | `trade.warehouses()` | Warehouses and transfer orders |
| `StockApi` | `trade.stock()` | Stock levels, movements, lots, serials |
| `DeliveryNoteApi` | `trade.deliveryNotes()` | Delivery notes |
| `GoodsReceiptApi` | `trade.goodsReceipts()` | Goods receipts |
| `ReportApi` | `trade.reports()` | Pipeline and sales reports |

---

## CustomerApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/trade/customers` | List customers |
| `getById(UUID) -> Map` | `GET /api/trade/customers/{id}` | Get customer |
| `create(Map) -> Map` | `POST /api/trade/customers` | Create customer |
| `update(UUID, Map) -> Map` | `PUT /api/trade/customers/{id}` | Update customer |
| `delete(UUID) -> void` | `DELETE /api/trade/customers/{id}` | Delete customer |
| `listGroups(PageRequest) -> PageResponse<Map>` | `GET /api/trade/customer-groups` | List customer groups |
| `getGroupById(UUID) -> Map` | `GET /api/trade/customer-groups/{id}` | Get group |
| `createGroup(Map) -> Map` | `POST /api/trade/customer-groups` | Create group |
| `updateGroup(UUID, Map) -> Map` | `PUT /api/trade/customer-groups/{id}` | Update group |
| `deleteGroup(UUID) -> void` | `DELETE /api/trade/customer-groups/{id}` | Delete group |

```java
Map customer = trade.customers().create(Map.of(
    "name", "Acme Corp", "email", "contact@acme.com", "phone", "+1234567890"
));
```

## ContactApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/crm/contacts` | List contacts |
| `getById(UUID) -> Map` | `GET /api/crm/contacts/{id}` | Get contact |
| `create(Map) -> Map` | `POST /api/crm/contacts` | Create contact |
| `update(UUID, Map) -> Map` | `PUT /api/crm/contacts/{id}` | Update contact |
| `delete(UUID) -> void` | `DELETE /api/crm/contacts/{id}` | Delete contact |

## OpportunityApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/crm/opportunities` | List opportunities |
| `getById(UUID) -> Map` | `GET /api/crm/opportunities/{id}` | Get opportunity |
| `create(Map) -> Map` | `POST /api/crm/opportunities` | Create opportunity |
| `update(UUID, Map) -> Map` | `PUT /api/crm/opportunities/{id}` | Update opportunity |
| `delete(UUID) -> void` | `DELETE /api/crm/opportunities/{id}` | Delete opportunity |

## ProductApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/trade/products` | List products |
| `getById(UUID) -> Map` | `GET /api/trade/products/{id}` | Get product |
| `create(Map) -> Map` | `POST /api/trade/products` | Create product |
| `update(UUID, Map) -> Map` | `PUT /api/trade/products/{id}` | Update product |
| `delete(UUID) -> void` | `DELETE /api/trade/products/{id}` | Delete product |
| `listCategories(PageRequest) -> PageResponse<Map>` | `GET /api/trade/product-categories` | List categories |
| `getCategoryById(UUID) -> Map` | `GET /api/trade/product-categories/{id}` | Get category |
| `createCategory(Map) -> Map` | `POST /api/trade/product-categories` | Create category |
| `updateCategory(UUID, Map) -> Map` | `PUT /api/trade/product-categories/{id}` | Update category |
| `deleteCategory(UUID) -> void` | `DELETE /api/trade/product-categories/{id}` | Delete category |
| `listPriceLists(PageRequest) -> PageResponse<Map>` | `GET /api/trade/price-lists` | List price lists |
| `getPriceListById(UUID) -> Map` | `GET /api/trade/price-lists/{id}` | Get price list |
| `createPriceList(Map) -> Map` | `POST /api/trade/price-lists` | Create price list |
| `updatePriceList(UUID, Map) -> Map` | `PUT /api/trade/price-lists/{id}` | Update price list |
| `deletePriceList(UUID) -> void` | `DELETE /api/trade/price-lists/{id}` | Delete price list |

## SupplierApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/trade/suppliers` | List suppliers |
| `getById(UUID) -> Map` | `GET /api/trade/suppliers/{id}` | Get supplier |
| `create(Map) -> Map` | `POST /api/trade/suppliers` | Create supplier |
| `update(UUID, Map) -> Map` | `PUT /api/trade/suppliers/{id}` | Update supplier |
| `delete(UUID) -> void` | `DELETE /api/trade/suppliers/{id}` | Delete supplier |
| `listInvoices(PageRequest) -> PageResponse<Map>` | `GET /api/trade/supplier-invoices` | List invoices |
| `getInvoiceById(UUID) -> Map` | `GET /api/trade/supplier-invoices/{id}` | Get invoice |
| `createInvoice(Map) -> Map` | `POST /api/trade/supplier-invoices` | Create invoice |
| `updateInvoice(UUID, Map) -> Map` | `PUT /api/trade/supplier-invoices/{id}` | Update invoice |
| `deleteInvoice(UUID) -> void` | `DELETE /api/trade/supplier-invoices/{id}` | Delete invoice |

## ContractApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/contract/contracts` | List contracts |
| `getById(UUID) -> Map` | `GET /api/contract/contracts/{id}` | Get contract |
| `create(Map) -> Map` | `POST /api/contract/contracts` | Create contract |
| `update(UUID, Map) -> Map` | `PUT /api/contract/contracts/{id}` | Update contract |
| `delete(UUID) -> void` | `DELETE /api/contract/contracts/{id}` | Delete contract |
| `listClauses(PageRequest) -> PageResponse<Map>` | `GET /api/contract/clauses` | List clauses |
| `createClause(Map) -> Map` | `POST /api/contract/clauses` | Create clause |
| `updateClause(UUID, Map) -> Map` | `PUT /api/contract/clauses/{id}` | Update clause |
| `deleteClause(UUID) -> void` | `DELETE /api/contract/clauses/{id}` | Delete clause |
| `listAmendments(PageRequest) -> PageResponse<Map>` | `GET /api/contract/amendments` | List amendments |
| `createAmendment(Map) -> Map` | `POST /api/contract/amendments` | Create amendment |
| `listDocuments(PageRequest) -> PageResponse<Map>` | `GET /api/contract/documents` | List documents |
| `createDocument(Map) -> Map` | `POST /api/contract/documents` | Create document |
| `listDocumentVersions(PageRequest) -> PageResponse<Map>` | `GET /api/contract/document-versions` | List versions |

## WarehouseApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/trade/warehouses` | List warehouses |
| `getById(UUID) -> Map` | `GET /api/trade/warehouses/{id}` | Get warehouse |
| `create(Map) -> Map` | `POST /api/trade/warehouses` | Create warehouse |
| `update(UUID, Map) -> Map` | `PUT /api/trade/warehouses/{id}` | Update warehouse |
| `delete(UUID) -> void` | `DELETE /api/trade/warehouses/{id}` | Delete warehouse |
| `listTransfers(PageRequest) -> PageResponse<Map>` | `GET /api/trade/transfer-orders` | List transfers |
| `getTransferById(UUID) -> Map` | `GET /api/trade/transfer-orders/{id}` | Get transfer |
| `createTransfer(Map) -> Map` | `POST /api/trade/transfer-orders` | Create transfer |
| `updateTransfer(UUID, Map) -> Map` | `PUT /api/trade/transfer-orders/{id}` | Update transfer |

## StockApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `listLevels(PageRequest) -> PageResponse<Map>` | `GET /api/trade/stock-levels` | List stock levels |
| `listMovements(PageRequest) -> PageResponse<Map>` | `GET /api/trade/stock-movements` | List movements |
| `createMovement(Map) -> Map` | `POST /api/trade/stock-movements` | Create movement |
| `listLots(PageRequest) -> PageResponse<Map>` | `GET /api/trade/stock-lots` | List stock lots |
| `createLot(Map) -> Map` | `POST /api/trade/stock-lots` | Create lot |
| `listSerialNumbers(PageRequest) -> PageResponse<Map>` | `GET /api/trade/serial-numbers` | List serial numbers |
| `listReorderRules(PageRequest) -> PageResponse<Map>` | `GET /api/trade/reorder-rules` | List reorder rules |
| `createReorderRule(Map) -> Map` | `POST /api/trade/reorder-rules` | Create reorder rule |
| `updateReorderRule(UUID, Map) -> Map` | `PUT /api/trade/reorder-rules/{id}` | Update rule |
| `deleteReorderRule(UUID) -> void` | `DELETE /api/trade/reorder-rules/{id}` | Delete rule |
| `listInventoryCounts(PageRequest) -> PageResponse<Map>` | `GET /api/trade/inventory-counts` | List counts |
| `createInventoryCount(Map) -> Map` | `POST /api/trade/inventory-counts` | Create count |

## Standard CRUD APIs

| Class | Endpoint Base |
|-------|--------------|
| `SalesOrderApi` | `/api/trade/sales-orders` |
| `PurchaseOrderApi` | `/api/trade/purchase-orders` |
| `CampaignApi` | `/api/crm/campaigns` |
| `ActivityApi` | `/api/crm/activities` |
| `DeliveryNoteApi` | `/api/trade/delivery-notes` |

`GoodsReceiptApi` provides `list`, `getById`, `create`, `update` at `/api/trade/goods-receipts` (no delete).

## ReportApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `getPipelineReport(Map params) -> Map` | `GET /api/crm/reports/pipeline` | Pipeline report |
| `getSalesReport(Map params) -> Map` | `GET /api/crm/reports/sales` | Sales report |

## Error Scenarios

| HTTP Status | Cause |
|-------------|-------|
| `400` | Invalid request data |
| `401` | Missing or expired authentication token |
| `403` | Insufficient permissions |
| `404` | Resource not found |
| `409` | Conflict (duplicate customer email, overlapping contract) |
| `422` | Business rule violation (insufficient stock, invalid order state) |
