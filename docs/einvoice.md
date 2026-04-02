# E-Invoice Module Reference

The E-Invoice module provides electronic invoicing capabilities including invoice submission to tax authorities, status tracking, PDF/XML download, cancellation, and public verification via code or QR.

## Client Access

```java
EssabuClient essabu = new EssabuClient("your-api-key");
EInvoiceClient einvoice = essabu.einvoice();
```

## Available API Classes

| Class | Accessor | Description |
|-------|----------|-------------|
| `EInvoiceApi` | `einvoice.invoices()` | Submit, list, track, download e-invoices |
| `VerificationApi` | `einvoice.verification()` | Public verification (code and QR) |

---

## EInvoiceApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/einvoice/invoices` | List e-invoices |
| `getById(UUID) -> Map` | `GET /api/einvoice/invoices/{id}` | Get e-invoice |
| `submit(Map request) -> Map` | `POST /api/einvoice/invoices` | Submit e-invoice |
| `cancel(UUID) -> Map` | `POST /api/einvoice/invoices/{id}/cancel` | Cancel e-invoice |
| `getSubmissionStatus(UUID) -> Map` | `GET /api/einvoice/invoices/{id}/status` | Check submission status |
| `downloadPdf(UUID) -> byte[]` | `GET /api/einvoice/invoices/{id}/pdf` | Download PDF |
| `downloadXml(UUID) -> byte[]` | `GET /api/einvoice/invoices/{id}/xml` | Download XML |

```java
// Submit an e-invoice
Map einv = einvoice.invoices().submit(Map.of(
    "invoiceId", invoiceId,
    "buyerTin", "123456789",
    "buyerName", "Acme Corp"
));

// Check status
Map status = einvoice.invoices().getSubmissionStatus(einvId);

// Download formats
byte[] pdf = einvoice.invoices().downloadPdf(einvId);
byte[] xml = einvoice.invoices().downloadXml(einvId);
```

## VerificationApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `verify(String verificationCode) -> Map` | `GET /api/public/einvoice/verify?code=` | Verify by code |
| `verifyByQrCode(String qrData) -> Map` | `POST /api/public/einvoice/verify-qr` | Verify by QR data |

```java
// Verify an e-invoice by code (public, no auth required)
Map result = einvoice.verification().verify("INV-2026-001-ABCDEF");

// Verify by QR code data
Map qrResult = einvoice.verification().verifyByQrCode(scannedQrData);
```

## Typical Workflow

1. Create an invoice in the Accounting module
2. Submit it as an e-invoice via `einvoice.invoices().submit()`
3. Check submission status via `getSubmissionStatus()`
4. Once accepted, download PDF/XML for records
5. Share the verification code with the buyer for independent verification

## Error Scenarios

| HTTP Status | Cause |
|-------------|-------|
| `400` | Invalid invoice data (missing required tax fields) |
| `401` | Missing or expired authentication token |
| `403` | Insufficient permissions |
| `404` | E-invoice not found |
| `409` | E-invoice already submitted or already cancelled |
| `422` | Validation failure from tax authority |
| `502` | Tax authority service unavailable |
