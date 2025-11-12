package com.modular.data;

import com.modular.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryOrderRepository implements OrderRepository {
    private final Map<String, Order> data = new ConcurrentHashMap<>();

    @Override
    public void save(Order order) {
        data.put(Objects.requireNonNull(order).getId(), order);
    }

    @Override
    public Optional<Order> findById(String id) {
        return Optional.ofNullable(data.get(id));
    }
}
