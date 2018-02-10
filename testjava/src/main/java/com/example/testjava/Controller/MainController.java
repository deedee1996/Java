package com.example.testjava.Controller;

import com.example.testjava.Entity.Order;
import com.example.testjava.Entity.OrderDetail;
import com.example.testjava.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    OrderService orderService;

    @GetMapping("/order")
    public Order getOrder(@RequestParam("id") int Id) {
         return orderService.getOrderById(Id);
    }

    @GetMapping("/delete")
    public Order Delete(@RequestParam("orderId") int OrderId,
                         @RequestParam("productId") int productId){
        orderService.deleteOrderDetail(OrderId, productId);
        if(orderService.getOrderById(OrderId).getOrderDetailList().size() == 0){
            orderService.deleteOrder(OrderId);
        }
        return orderService.getOrderById(OrderId);
    }

    @RequestMapping(value = "/order/update", method = RequestMethod.PUT)
    public String Update(@RequestBody OrderDetail update) {
        orderService.Update(update);
        return "OK";
    };
}
