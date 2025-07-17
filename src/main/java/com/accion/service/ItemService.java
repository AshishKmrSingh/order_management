package com.accion.service;

import com.accion.dao.ItemRepository;

import java.util.ArrayList;
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

    public List<DecoratedItem> getDecoratedItems(UUID orderid) {
        List<Item> items = itemRepository.getItems(orderid);
        List<DecoratedItem> decoratedItems = new ArrayList<>();

        for(Item item: items) {
            DecoratedItem decItem = itemDecorator.getDecorateditem(item);
            decoratedItems.add(decItem);
        }

        return decoratedItems;

    }

}
