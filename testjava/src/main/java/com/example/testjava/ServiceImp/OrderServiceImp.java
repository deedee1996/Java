package com.example.testjava.ServiceImp;

import com.example.testjava.Entity.Order;
import com.example.testjava.Entity.OrderDetail;
import com.example.testjava.Entity.OrderDetailPK;
import com.example.testjava.Repository.OrderDetailRepository;
import com.example.testjava.Repository.OrderRepository;
import com.example.testjava.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order getOrderById(int Id) {
        return orderRepository.findOne(Id);
    }

    @Override
    public String deleteOrder(int Id) {

        orderRepository.delete(Id);
        return "OK";
    }

    @Override
    public Order deleteOrderDetail(int orderId, int productId) {

         orderDetailRepository.delete(new OrderDetailPK(orderId, productId));
         return orderRepository.findOne(orderId);
    }

    @Override
    public String Update(OrderDetail orderDetail) {
        OrderDetail order = orderDetailRepository.findOne(new OrderDetailPK(orderDetail.getOrderId(), orderDetail.getProductId()));
        order.setQuantity(orderDetail.getQuantity());
        order.setDiscount(orderDetail.getDiscount());
        order.setUnitPrice(orderDetail.getUnitPrice());
        orderDetailRepository.save(order);
        return "OK";
    }
}
