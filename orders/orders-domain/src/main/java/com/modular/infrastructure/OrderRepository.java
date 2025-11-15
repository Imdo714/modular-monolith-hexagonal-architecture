package com.modular.infrastructure;

import com.modular.entity.Order;

import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(String memberId);
}
