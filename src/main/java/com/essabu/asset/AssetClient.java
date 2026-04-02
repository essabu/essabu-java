package com.essabu.asset;

import com.essabu.common.internal.HttpClientWrapper;

/**
 * Client for the Asset service module.
 * Provides access to asset management, fleet management, and maintenance operations.
 */
public final class AssetClient {

    private final HttpClientWrapper http;

    private volatile AssetApi assetApi;
    private volatile VehicleApi vehicleApi;
    private volatile MaintenanceApi maintenanceApi;
    private volatile FleetApi fleetApi;

    public AssetClient(HttpClientWrapper http) {
        this.http = http;
    }

    public AssetApi assets() {
        if (assetApi == null) { synchronized (this) { if (assetApi == null) assetApi = new AssetApi(http); } }
        return assetApi;
    }

    public VehicleApi vehicles() {
        if (vehicleApi == null) { synchronized (this) { if (vehicleApi == null) vehicleApi = new VehicleApi(http); } }
        return vehicleApi;
    }

    public MaintenanceApi maintenance() {
        if (maintenanceApi == null) { synchronized (this) { if (maintenanceApi == null) maintenanceApi = new MaintenanceApi(http); } }
        return maintenanceApi;
    }

    public FleetApi fleet() {
        if (fleetApi == null) { synchronized (this) { if (fleetApi == null) fleetApi = new FleetApi(http); } }
        return fleetApi;
    }
}
