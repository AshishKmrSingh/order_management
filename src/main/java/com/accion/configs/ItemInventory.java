package com.accion.configs;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ItemInventory {

    static Map<UUID, ItemI> itemMap = new ConcurrentHashMap<>();

    public static Map<UUID, ItemI> getItems() {
        if(itemMap.isEmpty()) {
            for (ItemI item : itemInventory) {
                itemMap.put(item.id, item);
            }
        }
        return itemMap;
    }

    static ItemI item1 = new ItemI("Toothpaste", 100.5);
    static ItemI item2 = new ItemI("ToothBrush", 10.2);
    static ItemI item3 = new ItemI("Gun Toy", 400.2);

    public static List<ItemI> itemInventory = List.of(item1, item2, item3);

    public static class ItemI {
        public UUID id;
        public String name;
        double regularPrice;

        ItemI(String name, double price) {
            this.id = UUID.randomUUID();
            this.name = name;
            this.regularPrice = price;
        }
    }
}
