package com.accion.service;

import com.accion.controller.ExtraDiscountController;
import com.accion.dao.ItemRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.accion.dao.OrderRepository;
import com.accion.model.DecoratedItem;
import com.accion.model.DecoratedOrder;
import com.accion.model.Item;
import com.accion.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemDecorator itemDecorator;

    private static final double extraDiscount = 5.0;

    public List<DecoratedItem> getDecoratedItems(UUID orderid) {
        List<Item> items = itemRepository.getItems(orderid);
        List<DecoratedItem> decoratedItems = new ArrayList<>();

        for(Item item: items) {
            DecoratedItem decItem = itemDecorator.getDecorateditem(item);

            LocalDateTime date = LocalDateTime.now();
            if (date.getDayOfMonth() == 10) {
                decItem.priceApplied = decItem.priceApplied - ((extraDiscount * decItem.priceApplied) / 100);
                decItem.discountApplied = extraDiscount;
            }
            decoratedItems.add(decItem);
        }

        return decoratedItems;

    }

}
