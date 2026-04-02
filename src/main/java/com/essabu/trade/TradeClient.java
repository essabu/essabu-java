package com.essabu.trade;

import com.essabu.common.internal.HttpClientWrapper;

/**
 * Client for the Trade service module.
 * Provides access to CRM, sales, purchasing, inventory, and contract management.
 */
public final class TradeClient {

    private final HttpClientWrapper http;

    private volatile CustomerApi customerApi;
    private volatile ContactApi contactApi;
    private volatile OpportunityApi opportunityApi;
    private volatile ProductApi productApi;
    private volatile SalesOrderApi salesOrderApi;
    private volatile PurchaseOrderApi purchaseOrderApi;
    private volatile SupplierApi supplierApi;
    private volatile ContractApi contractApi;
    private volatile CampaignApi campaignApi;
    private volatile ActivityApi activityApi;
    private volatile WarehouseApi warehouseApi;
    private volatile StockApi stockApi;
    private volatile DeliveryNoteApi deliveryNoteApi;
    private volatile GoodsReceiptApi goodsReceiptApi;
    private volatile ReportApi reportApi;

    public TradeClient(HttpClientWrapper http) {
        this.http = http;
    }

    public CustomerApi customers() {
        if (customerApi == null) { synchronized (this) { if (customerApi == null) customerApi = new CustomerApi(http); } }
        return customerApi;
    }

    public ContactApi contacts() {
        if (contactApi == null) { synchronized (this) { if (contactApi == null) contactApi = new ContactApi(http); } }
        return contactApi;
    }

    public OpportunityApi opportunities() {
        if (opportunityApi == null) { synchronized (this) { if (opportunityApi == null) opportunityApi = new OpportunityApi(http); } }
        return opportunityApi;
    }

    public ProductApi products() {
        if (productApi == null) { synchronized (this) { if (productApi == null) productApi = new ProductApi(http); } }
        return productApi;
    }

    public SalesOrderApi salesOrders() {
        if (salesOrderApi == null) { synchronized (this) { if (salesOrderApi == null) salesOrderApi = new SalesOrderApi(http); } }
        return salesOrderApi;
    }

    public PurchaseOrderApi purchaseOrders() {
        if (purchaseOrderApi == null) { synchronized (this) { if (purchaseOrderApi == null) purchaseOrderApi = new PurchaseOrderApi(http); } }
        return purchaseOrderApi;
    }

    public SupplierApi suppliers() {
        if (supplierApi == null) { synchronized (this) { if (supplierApi == null) supplierApi = new SupplierApi(http); } }
        return supplierApi;
    }

    public ContractApi contracts() {
        if (contractApi == null) { synchronized (this) { if (contractApi == null) contractApi = new ContractApi(http); } }
        return contractApi;
    }

    public CampaignApi campaigns() {
        if (campaignApi == null) { synchronized (this) { if (campaignApi == null) campaignApi = new CampaignApi(http); } }
        return campaignApi;
    }

    public ActivityApi activities() {
        if (activityApi == null) { synchronized (this) { if (activityApi == null) activityApi = new ActivityApi(http); } }
        return activityApi;
    }

    public WarehouseApi warehouses() {
        if (warehouseApi == null) { synchronized (this) { if (warehouseApi == null) warehouseApi = new WarehouseApi(http); } }
        return warehouseApi;
    }

    public StockApi stock() {
        if (stockApi == null) { synchronized (this) { if (stockApi == null) stockApi = new StockApi(http); } }
        return stockApi;
    }

    public DeliveryNoteApi deliveryNotes() {
        if (deliveryNoteApi == null) { synchronized (this) { if (deliveryNoteApi == null) deliveryNoteApi = new DeliveryNoteApi(http); } }
        return deliveryNoteApi;
    }

    public GoodsReceiptApi goodsReceipts() {
        if (goodsReceiptApi == null) { synchronized (this) { if (goodsReceiptApi == null) goodsReceiptApi = new GoodsReceiptApi(http); } }
        return goodsReceiptApi;
    }

    public ReportApi reports() {
        if (reportApi == null) { synchronized (this) { if (reportApi == null) reportApi = new ReportApi(http); } }
        return reportApi;
    }
}
