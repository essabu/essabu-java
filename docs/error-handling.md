# Error Handling

## Exception Hierarchy

All SDK exceptions extend `EssabuApiException`:

```
EssabuApiException (abstract)
  +-- EssabuValidationException   (400, 422)
  +-- EssabuUnauthorizedException (401)
  +-- EssabuForbiddenException    (403)
  +-- EssabuNotFoundException     (404)
  +-- EssabuRateLimitException    (429)
  +-- EssabuServerException       (5xx)
```

## Usage

### Catch All API Errors

```java
try {
    var employee = essabu.hr().employees().getById("emp-123");
} catch (EssabuApiException e) {
    System.err.println("API error: " + e.getMessage());
    System.err.println("Status code: " + e.getStatusCode());
}
```

### Catch Specific Errors

```java
try {
    var employee = essabu.hr().employees().create(request);
} catch (EssabuValidationException e) {
    // Field-level validation errors
    e.getFieldErrors().forEach((field, message) ->
        System.err.println(field + ": " + message));
} catch (EssabuNotFoundException e) {
    System.err.println("Resource not found: " + e.getMessage());
} catch (EssabuRateLimitException e) {
    // Retry after the specified duration
    Duration retryAfter = e.getRetryAfter();
    System.err.println("Rate limited. Retry after: " + retryAfter);
} catch (EssabuUnauthorizedException e) {
    System.err.println("Invalid or expired API key");
}
```

## Automatic Retry

The SDK automatically retries requests on 5xx server errors with exponential backoff:
- 1st retry after 1 second
- 2nd retry after 2 seconds
- 3rd retry after 4 seconds

The maximum number of retries is configurable via `retryOnServerError()`.

Rate limit errors (429) are **not** retried automatically. The `EssabuRateLimitException` includes a `retryAfter` duration from the server's `Retry-After` header.
