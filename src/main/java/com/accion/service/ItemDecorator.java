package com.accion.service;

import com.accion.configs.ItemInventory;
import com.accion.model.DecoratedItem;
import com.accion.model.Item;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class ItemDecorator {

    private static Map<UUID, ItemInventory.ItemI> itemMap = ItemInventory.getItems();

    public DecoratedItem getDecorateditem(Item item) {
        UUID id = item.itemId;
        ItemInventory.ItemI itemDetails = itemMap.get(id);

        DecoratedItem decItem = (DecoratedItem) item;
        decItem.itemDetails = itemDetails;
        return decItem;
    }
}
