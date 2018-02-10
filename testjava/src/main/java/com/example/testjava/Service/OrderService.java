package com.example.testjava.Service;

import com.example.testjava.Entity.Order;
import com.example.testjava.Entity.OrderDetail;

public interface OrderService {
    public Order getOrderById(int Id);
    public String deleteOrder(int Id);
    public Order deleteOrderDetail(int orderId, int productId);
    public String Update(OrderDetail orderDetail);
}
