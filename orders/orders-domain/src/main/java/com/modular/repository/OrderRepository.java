package com.modular.repository;

import com.modular.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(String memberId);
    List<Order> getOrderHistory(String memberId);
}
