package com.essabu.asset;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.asset.api.*;

/**
 * Asset module client providing access to all Asset API endpoints.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class AssetClient {

    private final HttpClientWrapper http;

    private volatile AssetApi assetApi;
    private volatile DepreciationApi depreciationApi;
    private volatile MaintenanceScheduleApi maintenanceScheduleApi;
    private volatile MaintenanceLogApi maintenanceLogApi;
    private volatile VehicleApi vehicleApi;
    private volatile FuelLogApi fuelLogApi;
    private volatile TripLogApi tripLogApi;

    public AssetClient(HttpClientWrapper http) {
        this.http = http;
    }

    public AssetApi assets() { if (assetApi == null) { synchronized (this) { if (assetApi == null) { assetApi = new AssetApi(http); } } } return assetApi; }
    public DepreciationApi depreciations() { if (depreciationApi == null) { synchronized (this) { if (depreciationApi == null) { depreciationApi = new DepreciationApi(http); } } } return depreciationApi; }
    public MaintenanceScheduleApi maintenanceSchedules() { if (maintenanceScheduleApi == null) { synchronized (this) { if (maintenanceScheduleApi == null) { maintenanceScheduleApi = new MaintenanceScheduleApi(http); } } } return maintenanceScheduleApi; }
    public MaintenanceLogApi maintenanceLogs() { if (maintenanceLogApi == null) { synchronized (this) { if (maintenanceLogApi == null) { maintenanceLogApi = new MaintenanceLogApi(http); } } } return maintenanceLogApi; }
    public VehicleApi vehicles() { if (vehicleApi == null) { synchronized (this) { if (vehicleApi == null) { vehicleApi = new VehicleApi(http); } } } return vehicleApi; }
    public FuelLogApi fuelLogs() { if (fuelLogApi == null) { synchronized (this) { if (fuelLogApi == null) { fuelLogApi = new FuelLogApi(http); } } } return fuelLogApi; }
    public TripLogApi tripLogs() { if (tripLogApi == null) { synchronized (this) { if (tripLogApi == null) { tripLogApi = new TripLogApi(http); } } } return tripLogApi; }
}
