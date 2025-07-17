package com.accion.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {
    public Date orderDate;
    public UUID orderId;
    public double price;
    public double finalPrice;
    public double regularDiscount;
    public double extraDiscount;
    public List<UUID> itemIds;
}
