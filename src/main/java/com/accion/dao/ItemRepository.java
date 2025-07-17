package com.accion.dao;

import com.accion.model.Item;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ItemRepository extends JpaRepository<UUID, Item> {

    @Query("Select * from Item where order_id=?")
    public List<Item> getItems(UUID orderId);
}
