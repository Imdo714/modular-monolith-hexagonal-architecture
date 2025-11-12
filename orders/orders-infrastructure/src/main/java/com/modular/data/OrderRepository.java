package com.modular.data;

import com.modular.entity.Order;

import java.util.Optional;

public interface OrderRepository {
    void save(Order order);
    Optional<Order> findById(String memberId);
}
