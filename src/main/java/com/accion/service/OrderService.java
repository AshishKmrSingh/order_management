package com.accion.service;


import com.accion.dao.OrderRepository;
import com.accion.model.DecoratedItem;
import com.accion.model.DecoratedOrder;
import com.accion.model.Item;
import com.accion.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    public OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    private ItemService itemService;

    private static final double extraDiscount = 5.0;

    public UUID createOrder(Order order) {
        // we will create an order here.
        // call order service to create order
    }

    public DecoratedOrder getOrderDetails(UUID orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            DecoratedOrder decOrder = (DecoratedOrder) order.get();
            List<DecoratedItem> orderItems = itemService.getDecoratedItems(orderId);
            decOrder.decoratedItems = orderItems;
            LocalDateTime date = LocalDateTime.now();
            if (date.getDayOfMonth() == 10) {
                decOrder.extraDiscount = extraDiscount;
            }
            return decOrder;
        }

        return null;
    }

}
