package com.accion.dao;

import com.accion.model.Order;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class OrderRepository extends JpaRepository<UUID, Order> {}
