# Asset Module Reference

The Asset module provides asset management including fixed assets, vehicles, maintenance (logs and schedules), and fleet management (fuel logs and trip logs).

## Client Access

Initialize the Asset client by calling `asset()` on your Essabu instance. The client is lazily created on first access and cached for subsequent calls. Requires an API key with asset module permissions; otherwise all operations will throw `ForbiddenException`.

```java
EssabuClient essabu = new EssabuClient("your-api-key");
AssetClient asset = essabu.asset();
```

## Available API Classes

| Class | Accessor | Description |
|-------|----------|-------------|
| `AssetApi` | `asset.assets()` | Fixed asset CRUD |
| `VehicleApi` | `asset.vehicles()` | Vehicle management |
| `MaintenanceApi` | `asset.maintenance()` | Maintenance logs and schedules |
| `FleetApi` | `asset.fleet()` | Fuel logs and trip logs |

---

## AssetApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/asset/assets` | List assets |
| `getById(UUID) -> Map` | `GET /api/asset/assets/{id}` | Get asset |
| `create(Map) -> Map` | `POST /api/asset/assets` | Create asset |
| `update(UUID, Map) -> Map` | `PUT /api/asset/assets/{id}` | Update asset |
| `delete(UUID) -> void` | `DELETE /api/asset/assets/{id}` | Delete asset |

Register a new fixed asset by providing its `name`, `category`, `purchaseDate`, `purchasePrice`, `depreciationMethod` (e.g., "straight-line" or "declining-balance"), and `usefulLifeMonths`. The system automatically calculates depreciation schedules based on the chosen method. Returns the created asset with its generated UUID and computed depreciation values. Throws `ValidationException` if the depreciation method is unsupported or the useful life is zero.

```java
Map assetItem = asset.assets().create(Map.of(
    "name", "Office Laptop",
    "category", "IT Equipment",
    "purchaseDate", "2026-01-15",
    "purchasePrice", 1500.00,
    "depreciationMethod", "straight-line",
    "usefulLifeMonths", 36
));
```

## VehicleApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `list(PageRequest) -> PageResponse<Map>` | `GET /api/asset/vehicles` | List vehicles |
| `getById(UUID) -> Map` | `GET /api/asset/vehicles/{id}` | Get vehicle |
| `create(Map) -> Map` | `POST /api/asset/vehicles` | Create vehicle |
| `update(UUID, Map) -> Map` | `PUT /api/asset/vehicles/{id}` | Update vehicle |
| `delete(UUID) -> void` | `DELETE /api/asset/vehicles/{id}` | Delete vehicle |

Register a new vehicle in the fleet by providing `make`, `model`, `year`, `licensePlate`, and initial `mileage`. The license plate must be unique across the tenant. Returns the created vehicle with its generated UUID and timestamps. Throws `ConflictException` if a vehicle with the same license plate already exists.

```java
Map vehicle = asset.vehicles().create(Map.of(
    "make", "Toyota", "model", "Hilux", "year", 2025,
    "licensePlate", "ABC-1234", "mileage", 0
));
```

## MaintenanceApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `listLogs(PageRequest) -> PageResponse<Map>` | `GET /api/asset/maintenance-logs` | List logs |
| `getLogById(UUID) -> Map` | `GET /api/asset/maintenance-logs/{id}` | Get log |
| `createLog(Map) -> Map` | `POST /api/asset/maintenance-logs` | Create log |
| `updateLog(UUID, Map) -> Map` | `PUT /api/asset/maintenance-logs/{id}` | Update log |
| `deleteLog(UUID) -> void` | `DELETE /api/asset/maintenance-logs/{id}` | Delete log |
| `listSchedules(PageRequest) -> PageResponse<Map>` | `GET /api/asset/maintenance-schedules` | List schedules |
| `getScheduleById(UUID) -> Map` | `GET /api/asset/maintenance-schedules/{id}` | Get schedule |
| `createSchedule(Map) -> Map` | `POST /api/asset/maintenance-schedules` | Create schedule |
| `updateSchedule(UUID, Map) -> Map` | `PUT /api/asset/maintenance-schedules/{id}` | Update schedule |
| `deleteSchedule(UUID) -> void` | `DELETE /api/asset/maintenance-schedules/{id}` | Delete schedule |

Log a completed maintenance event by providing the `assetId`, maintenance `type` (e.g., "oil-change", "tire-rotation"), `date`, `cost`, and optional `notes`. You can also create recurring maintenance schedules with an `intervalDays` and `nextDueDate` to receive automatic reminders. Returns the created log or schedule with its generated UUID. Throws `NotFoundException` if the referenced asset does not exist.

```java
// Log a maintenance event
Map log = asset.maintenance().createLog(Map.of(
    "assetId", vehicleId, "type", "oil-change",
    "date", "2026-03-26", "cost", 85.00, "notes", "Regular service"
));

// Create a recurring schedule
Map schedule = asset.maintenance().createSchedule(Map.of(
    "assetId", vehicleId, "type", "oil-change",
    "intervalDays", 90, "nextDueDate", "2026-06-26"
));
```

## FleetApi

| Method | Endpoint | Description |
|--------|----------|-------------|
| `listFuelLogs(PageRequest) -> PageResponse<Map>` | `GET /api/asset/fuel-logs` | List fuel logs |
| `getFuelLogById(UUID) -> Map` | `GET /api/asset/fuel-logs/{id}` | Get fuel log |
| `createFuelLog(Map) -> Map` | `POST /api/asset/fuel-logs` | Create fuel log |
| `updateFuelLog(UUID, Map) -> Map` | `PUT /api/asset/fuel-logs/{id}` | Update fuel log |
| `deleteFuelLog(UUID) -> void` | `DELETE /api/asset/fuel-logs/{id}` | Delete fuel log |
| `listTripLogs(PageRequest) -> PageResponse<Map>` | `GET /api/asset/trip-logs` | List trip logs |
| `getTripLogById(UUID) -> Map` | `GET /api/asset/trip-logs/{id}` | Get trip log |
| `createTripLog(Map) -> Map` | `POST /api/asset/trip-logs` | Create trip log |
| `updateTripLog(UUID, Map) -> Map` | `PUT /api/asset/trip-logs/{id}` | Update trip log |
| `deleteTripLog(UUID) -> void` | `DELETE /api/asset/trip-logs/{id}` | Delete trip log |

Record a fuel purchase by providing the `vehicleId`, `liters` purchased, `costPerLiter`, current `odometer` reading, and `date`. Trip logs track vehicle usage with `startOdometer`, `endOdometer`, `driverId`, and trip start/end timestamps in ISO 8601 format. Returns the created log with its UUID. Throws `ValidationException` if the end odometer is less than the start odometer, or if the odometer reading is less than the vehicle's last recorded value.

```java
// Log a fuel purchase
Map fuelLog = asset.fleet().createFuelLog(Map.of(
    "vehicleId", vehicleId, "liters", 45.0,
    "costPerLiter", 1.85, "odometer", 15230, "date", "2026-03-26"
));

// Log a trip
Map tripLog = asset.fleet().createTripLog(Map.of(
    "vehicleId", vehicleId, "driverId", driverId,
    "startOdometer", 15230, "endOdometer", 15380,
    "startDate", "2026-03-26T08:00:00Z", "endDate", "2026-03-26T17:00:00Z"
));
```

## Error Scenarios

| HTTP Status | Cause |
|-------------|-------|
| `400` | Invalid request data (missing asset name, invalid date) |
| `401` | Missing or expired authentication token |
| `403` | Insufficient permissions |
| `404` | Asset, vehicle, or log not found |
| `409` | Conflict (duplicate license plate) |
| `422` | Business rule violation (end odometer less than start) |
