package com.example.testjava.Entity;

import java.io.Serializable;

public class OrderDetailPK implements Serializable {

    private int OrderId;
    private int ProductId;

    public OrderDetailPK(){}

    public OrderDetailPK(int orderId, int productId) {
        OrderId = orderId;
        ProductId = productId;
    }
}
