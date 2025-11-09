package com.modular.domain.port.out.order;

import com.modular.domain.entity.Order;

import java.util.Optional;

public interface OrderRepository{ // Order-Modular port.out
    // DB는 외부에 있기 때문에
    void save(Order order);
    Optional<Order> findById(String id);
}
