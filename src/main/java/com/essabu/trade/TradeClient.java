package com.essabu.trade;

import com.essabu.common.internal.HttpClientWrapper;
import com.essabu.trade.api.commerce.CustomerApi;
import com.essabu.trade.api.commerce.DeliveryApi;
import com.essabu.trade.api.commerce.ProductApi;
import com.essabu.trade.api.commerce.ReceiptApi;
import com.essabu.trade.api.commerce.SalesOrderApi;

/**
 * Trade module client providing access to all Trade API endpoints.
 *
 * @author Essabu Team
 * @since 1.0.0
 */
public final class TradeClient {

    private final HttpClientWrapper http;

    private volatile CustomerApi customerApi;
    private volatile DeliveryApi deliveryApi;
    private volatile ProductApi productApi;
    private volatile ReceiptApi receiptApi;
    private volatile SalesOrderApi salesOrderApi;

    public TradeClient(HttpClientWrapper http) {
        this.http = http;
    }

    public CustomerApi customers() { if (customerApi == null) { synchronized (this) { if (customerApi == null) { customerApi = new CustomerApi(http); } } } return customerApi; }
    public DeliveryApi deliveries() { if (deliveryApi == null) { synchronized (this) { if (deliveryApi == null) { deliveryApi = new DeliveryApi(http); } } } return deliveryApi; }
    public ProductApi products() { if (productApi == null) { synchronized (this) { if (productApi == null) { productApi = new ProductApi(http); } } } return productApi; }
    public ReceiptApi receipts() { if (receiptApi == null) { synchronized (this) { if (receiptApi == null) { receiptApi = new ReceiptApi(http); } } } return receiptApi; }
    public SalesOrderApi salesOrders() { if (salesOrderApi == null) { synchronized (this) { if (salesOrderApi == null) { salesOrderApi = new SalesOrderApi(http); } } } return salesOrderApi; }
}
