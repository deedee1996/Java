package com.example.testjava.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="`order details`")
@IdClass(OrderDetailPK.class)
public class OrderDetail implements Serializable {


    @Id
    @Column(name = "orderid")
    private int OrderId;

    public int getOrderId() {
        return OrderId;
    }

    @Id
    @Column(name = "productid")
    private int ProductId;

    @Column(name = "unitprice")
    private double UnitPrice;

    @Column(name = "quantity")
    private int Quantity;

    @Column(name = "discount")
    private double Discount;

    @OneToOne
    @JoinColumn(name="productid", insertable=false, updatable=false)
    private Product productName;

    public Product getProduct() {
        return productName;
    }

    public int getProductId() {
        return ProductId;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double discount) {
        Discount = discount;
    }
}
