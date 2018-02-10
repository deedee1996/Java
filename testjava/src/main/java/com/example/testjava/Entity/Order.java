package com.example.testjava.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @Column(name = "orderid")
    private int OrderId;

    @OneToMany
    @JoinColumn(name="orderid")
    private List<OrderDetail> orderDetailList = new ArrayList<>();

    public int getOrderId() {
        return OrderId;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
