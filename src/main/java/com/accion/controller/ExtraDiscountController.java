package com.accion.controller;

import com.accion.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ExtraDiscountController {

    @Autowired
    private ItemService itemService;

    public void applyExtraDiscount(UUID orderId) {
        
    }
}
