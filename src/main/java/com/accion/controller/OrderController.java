package com.accion.controller;

import com.accion.model.DecoratedOrder;
import com.accion.model.Order;
import com.accion.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order_details/{order_id}")
    public DecoratedOrder getOrderDetails(@PathVariable("order_id") UUID orderId) {
        return orderService.getOrderDetails(orderId);
    }


    @PostMapping("/order_details")
    public UUID getOrderDetails(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

}
